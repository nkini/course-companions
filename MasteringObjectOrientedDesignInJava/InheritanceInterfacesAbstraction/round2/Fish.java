// 1. First, note that we've extended Animal for Fish
public class Fish extends Animal{

    // 2. Note that this necessitates an constructor definition that 
    //    matches the parent.
    public Fish(int age, String gender, int weightInLbs) {
        // Just passes initialization to the parent
        super(age, gender, weightInLbs);
    }

    public void swim() {
        System.out.println("Swimming...");
    }

}
