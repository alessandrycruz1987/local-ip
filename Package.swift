// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CappitolianLocalIp",
    platforms: [.iOS(.v15)],
    products: [
        .library(
            name: "CappitolianLocalIp",
            targets: ["LocalIpPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "LocalIpPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/LocalIpPlugin"),
        .testTarget(
            name: "LocalIpTests",
            dependencies: ["LocalIpPlugin"],
            path: "ios/Tests/LocalIpTests")
    ]
)