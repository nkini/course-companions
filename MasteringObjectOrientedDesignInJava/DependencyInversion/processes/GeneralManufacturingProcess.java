package processes;

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

    // Notice that the methods are all protected. 
    // The importance is that these methods should not
    //    be visible to the clients, only manufacture should be visible.
    protected abstract void assemble();
    protected abstract void test();
    protected abstract void pack();
    protected abstract void store();
}
