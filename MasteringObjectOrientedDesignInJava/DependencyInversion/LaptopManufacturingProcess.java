public class LaptopManufacturingProcess extends GeneralManufacturingProcess {

    public LaptopManufacturingProcess(String deviceType) {
        super(deviceType);
    }

    public void assemble() {
        System.out.println("Assembling a laptop: " + this.deviceType);
        addBattery();
        addScreen();
        addSoftware();
    }

    public void test() {
        System.out.println("Testing a laptop: " + this.deviceType);
        System.out.println("Software boot... passed");
        System.out.println("Wireless test... passed");
    }

    public void pack() {
        System.out.println("Packing a laptop: " + this.deviceType);
    }

    public void store() {
        System.out.println("Storing a laptop: " + this.deviceType);
    }

    protected void addBattery() {
        System.out.println("Added battery");
    }

    protected void addScreen() {
        System.out.println("Added screen");
    }

    protected void addSoftware() {
        System.out.println("Added Linux");
    }
    
}
