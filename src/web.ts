import { WebPlugin } from '@capacitor/core';
import type { LocalIpPlugin } from './definitions';

export class LocalIpWeb extends WebPlugin implements LocalIpPlugin {
  async getLocalIp(): Promise<{ ip: string }> {
    return { ip: '' }; // Not implemented for web
  }
}