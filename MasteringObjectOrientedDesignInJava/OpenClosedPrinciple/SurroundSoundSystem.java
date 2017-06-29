public class SurroundSoundSystem extends Device {

    public SurroundSoundSystem(String name) {
        super(name);
    }

    protected void turnOn(){
        System.out.println("Boom boom pow (Turned on " + name + ").");
    }

    protected void turnOff(){
        System.out.println("'Itna sannata kyun hai bhai?' (Turned off " + name + ")");
    }
}
