public class Zoo {

    public static void main(String args[]) {
        
        Animal animal1 = new Animal(12, "M", 23);
        animal1.eat();
        // Of course, an Animal can't swim() or fly()
        //animal.fly();  //Wrong
        //animal.swim(); //Wrong

        // 3. Since the constructor changed, the call changes too
        Bird bird1 = new Bird(3, "F", 10);
        bird1.fly(); 
        bird1.eat(); //Bird can eat and sleep now

        Fish fish1 = new Fish(1, "M", 1);
        fish1.swim();
        fish1.sleep(); //Fish can eat and sleep now

    }    

}
