package processes;

public class SmartphoneManufacturingProcess extends GeneralManufacturingProcess{

    public SmartphoneManufacturingProcess(String deviceType) {
        super(deviceType);
    }

    protected void assemble() {
        System.out.println("Assembling a smartphone: " + this.deviceType);
        addBattery();
        addScreen();
        addSoftware();
    }

    protected void test() {
        System.out.println("Testing a smartphone: " + this.deviceType);
        System.out.println("Software boot... passed");
        System.out.println("Wireless test... passed");
    }

    protected void pack() {
        System.out.println("Packing a smartphone: " + this.deviceType);
    }

    protected void store() {
        System.out.println("Storing a smartphone: " + this.deviceType);
    }

    protected void addBattery() {
        System.out.println("Added battery");
    }

    protected void addScreen() {
        System.out.println("Added screen");
    }

    protected void addSoftware() {
        System.out.println("Added software");
    }
    
}
