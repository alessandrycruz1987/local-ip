export interface LocalIpPlugin {
  getLocalIp(): Promise<{ ip: string }>;
}