public class Zoo {

    public static void main(String args[]) {
        
        Chicken chick1 = new Chicken(12, "M", 23);
        chick1.fly();
        //Will print "Unable to fly..."
        //If you don't override fly() in Chicken, chick1 will fly too

    }    

}
