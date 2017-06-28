public class Zoo {

    public static void main(String args[]) {
        
        Animal animal1 = new Animal(12, "M", 23);
        animal1.eat();

        Bird bird1 = new Bird();
        bird1.fly();
        //birds should also be able to sleep and eat though

        Fish fish1 = new Fish();
        fish1.swim();
        //fish should also be able to sleep and eat though

    }    

}
