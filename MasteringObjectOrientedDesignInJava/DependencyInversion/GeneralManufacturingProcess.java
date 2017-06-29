public abstract class GeneralManufacturingProcess {

    // Making this private makes it invisible in sub-classes
    protected String deviceType;

    public void manufacture() {
        assemble();
        test();
        pack();
        store();
    }

    public GeneralManufacturingProcess(String deviceType) {
        this.deviceType = deviceType;
    }

    public abstract void assemble();
    public abstract void test();
    public abstract void pack();
    public abstract void store();
}
