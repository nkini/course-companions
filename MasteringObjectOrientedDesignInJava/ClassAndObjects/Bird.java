public class Bird {


    boolean canFly;
    int wokeUpAt;

    public Bird(boolean canFly, int wokeUpAt) {
        this.canFly = canFly;
        if (wokeUpAt >= 0 && wokeUpAt <= 23) {
            this.wokeUpAt = wokeUpAt;
        }
        else {
            throw new IllegalArgumentException("wokeUpAt value should be between 0 and 23");
        }
    }

    public void fly() {
        if (canFly) {
            System.out.println("I believe I can fly");
        }
        else {
            System.out.println("Flap flap flop flop flop");
        }
    }

    public void chirp() {
        System.out.println("Cheep chip chip...");
    }

    public void eat() {
        if (wokeUpAt < 6) {
            System.out.println("Arrived early. Got the worm.");
        }
        else {
            System.out.println("Hello Dominoes? Can I order a Farmer's Friend please?");
        }
    }

    public void tweet() {
        System.out.println("SAD!");
    }

}
