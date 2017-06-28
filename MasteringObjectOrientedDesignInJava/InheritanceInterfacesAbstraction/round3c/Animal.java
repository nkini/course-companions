// Having one abstract method makes the class abstract
// You can never instantiate an abstract class, only extend it.
public abstract class Animal {
    
    int age;
    String gender;
    int weightInLbs;

    public Animal(int age, String gender, int weightInLbs) {
        this.age = age;
        this.gender = gender;
        this.weightInLbs = weightInLbs;
    }    

    public void eat() {
        System.out.println("Eating...");
    }

    public void sleep() {
        System.out.println("Sleeping...");
    }

    // abstract => no body
    public abstract void move();

}
