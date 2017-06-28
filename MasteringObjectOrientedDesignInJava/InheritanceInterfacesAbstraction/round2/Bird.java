// 1. First, note that we've extended Animal for Bird
public class Bird extends Animal{

    // 2. Note that this necessitates an constructor definition that 
    //    matches the parent.
    public Bird(int age, String gender, int weightInLbs) {
        // Just passes initialization to the parent
        super(age, gender, weightInLbs);
    }

    public void fly() {
        System.out.println("Flying...");
    } 

}
