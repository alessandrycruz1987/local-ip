// export interface LocalIpPlugin {
//   echo(options: { value: string }): Promise<{ value: string }>;
// }

export interface LocalIpPlugin {
  /**
   * Gets the local IP address of the device.
   * @returns A promise resolving with an object containing the IP address.
   */
  getLocalIp(): Promise<{ ip: string }>;
}