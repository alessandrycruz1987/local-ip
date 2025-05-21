package com.cappitolian.localip;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.net.Inet4Address;
import java.net.NetworkInterface;
import java.util.Enumeration;

@CapacitorPlugin(name = "LocalIp")
public class LocalIpPlugin extends Plugin {
    @PluginMethod
    public void getLocalIp(PluginCall call) {
        try {
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