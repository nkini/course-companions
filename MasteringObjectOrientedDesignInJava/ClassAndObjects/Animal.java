public class Animal {

    int age;
    String gender;
    float weightInPounds;
    String kindOfAnimal;

    public Animal(int age, String gender, float weightInPounds, String kindOfAnimal) {
        this.age = age;
        this.gender = gender;
        this.weightInPounds = weightInPounds;
        this.kindOfAnimal = kindOfAnimal;
    }

    public void speak() {

        if (kindOfAnimal.equals("dog")) {
            System.out.println("woof");
        }
        else if (kindOfAnimal.equals("cat")) {
            System.out.println("meow");
        }
        else if (kindOfAnimal.equals("bird")) {
            System.out.println("tweet");
        }
        else if (kindOfAnimal.equals("mouse")) {
            System.out.println("squeek");
        }
        else if (kindOfAnimal.equals("cow")) {
            System.out.println("moo");
        }
        else if (kindOfAnimal.equals("frog")) {
            System.out.println("croak");
        }
        else if (kindOfAnimal.equals("elephant")) {
            System.out.println("toot");
        }
        else if (kindOfAnimal.equals("duck")) {
            System.out.println("quack");
        }
        else if (kindOfAnimal.equals("fish")) {
            System.out.println("blub");
        }
        else if (kindOfAnimal.equals("seal")) {
            System.out.println("ow ow ow");
        }
        else if (kindOfAnimal.equals("fox")) {
            System.out.println("Abay-ba-da bum-bum bay-do");
        }
        else {
            System.out.println("What does the " + kindOfAnimal + " say?");
        }


    }

    public void eat() {
        System.out.println("It's a " + kindOfAnimal + " eat " + kindOfAnimal + " world I tell ya... And I'm full...");
    }

    public void sleep() {
        System.out.println("Zzzzzz");
    }

}
