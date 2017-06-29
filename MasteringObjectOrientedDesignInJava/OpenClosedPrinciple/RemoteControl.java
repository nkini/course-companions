public class RemoteControl {

    static Device connectedDevice;    

    public static void chooseDevice(Device device) {
        connectedDevice = device;
    }

    public static void pressOn() {
        connectedDevice.testAndTurnOn();
    }

    public static void pressOff() {
        connectedDevice.testAndTurnOff();
    }
}
