public class Projector extends Device {

    public Projector(String name) {
        super(name);
    }

    protected void turnOn(){
        System.out.println("Projecting through " + name + "...");
    }

    protected void turnOff(){
        System.out.println("Not projecting through " + name + " anymore.");
    }
}
