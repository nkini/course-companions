public class TV extends Device {

    public TV(String name) {
        super(name);
    }

    protected void turnOn(){
        System.out.println("Look at all these pictures and sounds... (Turned on " + name + ").");
    }

    protected void turnOff(){
        System.out.println("Turned off the " + name + " TV.");
    }
}
