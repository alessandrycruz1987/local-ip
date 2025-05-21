import Foundation
import Capacitor

@objc(LocalIpPlugin)
public class LocalIpPlugin: CAPPlugin {
    @objc func getLocalIp(_ call: CAPPluginCall) {
        var address: String?

        var ifaddr: UnsafeMutablePointer<ifaddrs>?
        if getifaddrs(&ifaddr) == 0 {
            var ptr = ifaddr
            while ptr != nil {
                defer { ptr = ptr?.pointee.ifa_next }
                guard let interface = ptr?.pointee else { continue }
                let addrFamily = interface.ifa_addr.pointee.sa_family
                if addrFamily == UInt8(AF_INET) {
                    if let name = String(validatingUTF8: interface.ifa_name),
                       name == "en0" { // WiFi interface
                        var hostname = [CChar](repeating: 0, count: Int(NI_MAXHOST))
                        getnameinfo(interface.ifa_addr, socklen_t(interface.ifa_addr.pointee.sa_len),
                                    &hostname, socklen_t(hostname.count),
                                    nil, socklen_t(0), NI_NUMERICHOST)
                        address = String(cString: hostname)
                        break
                    }
                }
            }
            freeifaddrs(ifaddr)
        }

        if let ip = address {
            call.resolve([
                "ip": ip
            ])
        } else {
            call.reject("Unable to determine local IP address")
        }
    }
}