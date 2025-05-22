// import { registerPlugin } from '@capacitor/core';

// import type { LocalIpPlugin } from './definitions';

// const LocalIp = registerPlugin<LocalIpPlugin>('LocalIp', {
//   web: () => import('./web').then((m) => new m.LocalIpWeb()),
// });

// export * from './definitions';
// export { LocalIp };

import { registerPlugin } from '@capacitor/core';
import type { LocalIpPlugin } from './definitions';

const LocalIp = registerPlugin<LocalIpPlugin>('LocalIp');

export * from './definitions';
export default LocalIp;
