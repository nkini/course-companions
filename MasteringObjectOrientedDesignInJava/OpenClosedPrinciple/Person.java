public class Person {

    public static void main(String args[]) {
        TV tv = new TV("Toshiba");
        SurroundSoundSystem sss = new SurroundSoundSystem("Akai");
        Projector projector = new Projector("Canon");

        pressChooseDevice(tv);
        pressOn();
        pressChooseDevice(sss);
        pressOn();
        pressOff();
        pressChooseDevice(projector);
        pressOn();
        pressChooseDevice(tv);
        pressOff();
        pressChooseDevice(sss);
        pressOff();
        pressChooseDevice(projector);
        pressOff();
    }

    private static void pressOn() {
        RemoteControl.pressOn();
    }

    private static void pressOff() {
        RemoteControl.pressOff();
    }

    private static void pressChooseDevice(Device device) {
        RemoteControl.chooseDevice(device);
    }

}
