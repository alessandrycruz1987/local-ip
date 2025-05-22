// package com.cappitolian.plugins.localip;

// import android.util.Log;

// public class LocalIp {

//     public String echo(String value) {
//         Log.i("Echo", value);
//         return value;
//     }
// }

package com.cappitolian.plugins.localip;

import java.net.Inet4Address;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class LocalIp {
    public String getLocalIp() throws Exception {
        String localIp = null;
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface intf = interfaces.nextElement();
            Enumeration<java.net.InetAddress> addrs = intf.getInetAddresses();
            while (addrs.hasMoreElements()) {
                java.net.InetAddress addr = addrs.nextElement();
                if (!addr.isLoopbackAddress() && addr instanceof Inet4Address) {
                    localIp = addr.getHostAddress();
                    break;
                }
            }
            if (localIp != null) break;
        }
        return localIp;
    }
}
