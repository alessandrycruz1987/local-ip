# @cappitolian/local-ip

A Capacitor plugin to retrieve the device's local IP address.

---

## Features

- Get the local IP address of your device on iOS, Android, and Web.
- Simple API, returns an object with the IP address.
- Tested with **Capacitor 7** and **Ionic 7**.

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
LocalIp.getLocalIp().then(result => {
  console.log('Device Local IP:', result.ip);
});
```

- The plugin returns a Promise that resolves to an object like: `{ ip: string }`.

---

## Platforms

- **iOS** (Swift)
- **Android** (Java)
- **Web** (returns `"0.0.0.0"` as placeholder)

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
