package clients;
import processes.SmartphoneManufacturingProcess;
import processes.LaptopManufacturingProcess;

public class Factory {

    public static void main(String args[]) {
        
        SmartphoneManufacturingProcess smp = new SmartphoneManufacturingProcess("iPhone");
        smp.manufacture();
        LaptopManufacturingProcess lmp = new LaptopManufacturingProcess("Dell");
        //This is not possible because of the packaging now
        //lmp.store();
        lmp.manufacture();
        SmartphoneManufacturingProcess smp2 = new SmartphoneManufacturingProcess("iPhone");
        smp2.manufacture();
        LaptopManufacturingProcess lmp2 = new LaptopManufacturingProcess("Acer");
        lmp2.manufacture();

    }

}
