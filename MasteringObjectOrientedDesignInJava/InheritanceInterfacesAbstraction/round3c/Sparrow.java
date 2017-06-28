public class Sparrow extends Bird implements Flyable {
    
    public Sparrow(int age, String gender, int weightInLbs) {
        super(age, gender, weightInLbs);
    }
    
    //Moves like a bird, but also flies like a plane...
    public void fly() {
        System.out.println("Flying high");
    }

}
