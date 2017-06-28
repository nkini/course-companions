public class Fish extends Animal{

    public Fish(int age, String gender, int weightInLbs) {
        super(age, gender, weightInLbs);
    }

    // Adding the unimplemented method from Animal
    public void move() {
        System.out.println("Swimming...");
    }

}
