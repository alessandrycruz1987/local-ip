# @cappitolian/local-ip

A Capacitor plugin to retrieve the device's local IPv4 address.

---

## Features

- Get the local IPv4 address of your device on iOS, Android, and Web
- Returns `null` when no suitable address is found (no WiFi on iOS, no active non-loopback interface on Android)
- No permissions required on any platform
- Tested with **Capacitor 7** and **Ionic 7**

---

## Installation

```bash
npm install @cappitolian/local-ip
npx cap sync
```

---

## Usage

### Import

```typescript
import LocalIp from '@cappitolian/local-ip';
```

### Get Local IP

```typescript
const result = await LocalIp.getLocalIp();

if (result.ip) {
  console.log('Device Local IP:', result.ip);
} else {
  console.log('No active network interface found');
}
```

Returns `Promise<{ ip: string | null }>`.

---

## Platform Behavior

| Platform | Interface | Returns `null` when |
|---|---|---|
| iOS | `en0` (WiFi only) | WiFi is disconnected or unavailable |
| Android | First non-loopback IPv4 (any interface) | No active non-loopback interface found |
| Web | — | Always returns `null` (no native access) |

> **iOS vs Android:** On iOS the plugin is WiFi-specific — it reads exclusively from the `en0` interface. On Android it iterates all network interfaces and returns the first non-loopback IPv4 found, which may be WiFi, a mobile hotspot, or an ethernet adapter.

---

## Platforms

- **iOS** (Swift)
- **Android** (Java)
- **Web** (returns `null`)

---

## Requirements

- [Capacitor 7](https://capacitorjs.com/)
- [Ionic 7](https://ionicframework.com/) (optional, but tested)

---

## License

MIT

---

## Support

If you have any issues or feature requests, please open an issue on the repository.