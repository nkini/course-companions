public class Zoo {

    public static void main(String args[]) {
        Animal hoover = new Animal(12, "female", 1000.56f, "seal");
        Animal dunston = new Animal(3, "male", 208.3f, "orangutan");
        Animal mr = new Animal(4, "male", 87.17f, "fox");
        Bird tweety = new Bird(false, 5);
        Fish nemo = new Fish("clown fish");


        hoover.eat();
        mr.speak();
        dunston.sleep();
        tweety.eat();
        nemo.drown();
    }

}
