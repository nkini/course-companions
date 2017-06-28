public class Zoo {

    public static void main(String args[]) {
        
        Sparrow sparrow1 = new Sparrow(12, "M", 23);
        sparrow1.move();//Will flap wings

        //Look what you can also do:
        //The object is of type Sparrow (RHS)
        Animal sparrow2 = new Sparrow(1, "F", 4);
        //But the variable that points to that object is of type Animal (LHS)
        //And the method you can invoke on the variable depends on the Type Specification
        //sparrow2.fly(); //will not work now
        sparrow2.move();//this will, a higher level method.


        // But if you have to implement move in both Chicken and Sparrow
        //    (and indeed, every extending class), what's the point of having an Abstract method?
        //    Why not just define move in every subclass without abstraction?
        //    Because polymorphism:
        Animal fish1 = new Fish(1, "F", 2);
        fish1.move();
        // You wouldn't be able to call move on the parent type Animal otherwise...
        moveAnimal(fish1);
        moveAnimal(sparrow1);

        // You can also do this:
        Flyable flyingBird = new Sparrow(1, "M", 4);
        //However, flyingBird can only fly, and not move
        //   (Flyable determines which methods are accessible)

        // And of course you can't do this,
        //    because Bird never implemented Flyable, contrary to your intuition.
        //Flyable flyingBird2 = new Bird(1, "F", 5); //Type mismatch. Can't convert from Bird to Flyable.

    }    

    // Parameter is parent type
    // Method call can be on any child
    public static void moveAnimal(Animal animal) {
        animal.move();
    }

}
