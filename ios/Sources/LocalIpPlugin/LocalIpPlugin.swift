// import Foundation
// import Capacitor

// /**
//  * Please read the Capacitor iOS Plugin Development Guide
//  * here: https://capacitorjs.com/docs/plugins/ios
//  */
// @objc(LocalIpPlugin)
// public class LocalIpPlugin: CAPPlugin, CAPBridgedPlugin {
//     public let identifier = "LocalIpPlugin"
//     public let jsName = "LocalIp"
//     public let pluginMethods: [CAPPluginMethod] = [
//         CAPPluginMethod(name: "echo", returnType: CAPPluginReturnPromise)
//     ]
//     private let implementation = LocalIp()

//     @objc func echo(_ call: CAPPluginCall) {
//         let value = call.getString("value") ?? ""
//         call.resolve([
//             "value": implementation.echo(value)
//         ])
//     }
// }

import Foundation
import Capacitor

@objc(LocalIpPlugin)
public class LocalIpPlugin: CAPPlugin, CAPBridgedPlugin {
    public let identifier = "LocalIpPlugin"
    public let jsName = "LocalIp"
    public let pluginMethods: [CAPPluginMethod] = [
        CAPPluginMethod(name: "getLocalIp", returnType: CAPPluginReturnPromise)
    ]
    private let implementation = LocalIp()

    @objc func getLocalIp(_ call: CAPPluginCall) {
        print("LocalIpPlugin.getLocalIp called!")
        if let ip = implementation.getLocalIp() {
            call.resolve([
                "ip": ip
            ])
        } else {
            call.reject("Unable to determine local IP address")
        }
    }
}
