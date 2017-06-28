public class Chicken extends Bird {

    public Chicken(int age, String gender, int weightInLbs) {
        super(age, gender, weightInLbs);
    }

    // Overrides Bird's fly
    public void fly() {
        System.out.println("Unable to fly...");
    }

}
