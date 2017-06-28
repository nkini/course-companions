public class Bird extends Animal{

    public Bird(int age, String gender, int weightInLbs) {
        super(age, gender, weightInLbs);
    }

    // Must add unimplemented method
    public void move() {
        System.out.println("Flapping wings...");
    } 

}
