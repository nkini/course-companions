// Sparrow now implements Flyable, and the method in it fly()
public class Sparrow extends Bird implements Flyable {
    
    public Sparrow(int age, String gender, int weightInLbs) {
        super(age, gender, weightInLbs);
    }

    // Won't compile if not defined
    public void fly() {
        System.out.println("Flying...");
    }

}
