// package com.cappitolian.plugins.localip;

// import com.getcapacitor.JSObject;
// import com.getcapacitor.Plugin;
// import com.getcapacitor.PluginCall;
// import com.getcapacitor.PluginMethod;
// import com.getcapacitor.annotation.CapacitorPlugin;

// @CapacitorPlugin(name = "LocalIp")
// public class LocalIpPlugin extends Plugin {

//     private LocalIp implementation = new LocalIp();

//     @PluginMethod
//     public void echo(PluginCall call) {
//         String value = call.getString("value");

//         JSObject ret = new JSObject();
//         ret.put("value", implementation.echo(value));
//         call.resolve(ret);
//     }
// }

package com.cappitolian.plugins.localip;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "LocalIp")
public class LocalIpPlugin extends Plugin {
    private LocalIp implementation = new LocalIp();

    @PluginMethod
    public void getLocalIp(PluginCall call) {
        try {
            String localIp = implementation.getLocalIp();
            if (localIp != null) {
                JSObject ret = new JSObject();
                ret.put("ip", localIp);
                call.resolve(ret);
            } else {
                call.reject("Local IP address not found");
            }
        } catch (Exception e) {
            call.reject("Error retrieving IP: " + e.getMessage());
        }
    }
}