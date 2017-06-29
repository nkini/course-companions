public abstract class Device {
    String name;
    boolean isOn;

    public Device(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void testAndTurnOn() {
        if (this.isOn) {
            System.out.println(name + " is already on.");
        }
        else{
            turnOn();
            isOn = true;
        }
    }

    public void testAndTurnOff() {
        if (!this.isOn) {
            System.out.println(name + " is already off.");
        }
        else{
            turnOff();
            isOn = false;
        }
    }

    // A sub-type can't see private methods
    // So private abstract makes no sense
    protected abstract void turnOn();
    protected abstract void turnOff();
    
}
