import { LocalIpPlugin } from '@cappitolian/local-ip';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    LocalIpPlugin.echo({ value: inputValue })
}
