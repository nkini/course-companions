public class CoffeeShop {

    static CoffeeAttendant pam;

    public static void main(String args[]) {

        pam = new CoffeeAttendant();

        Customer jim = new Customer("Jim","Mocha");
        pam.takeOrder(jim);

        pam.prepareDrink("Mocha");

        Customer phyllis = new Customer("Phyllis", "Coke");
        pam.takeOrder(phyllis);

        Customer dwight = new Customer("Dwight", "Beet juice");
        pam.takeOrder(dwight);

        pam.prepareDrink("Coke");
        pam.prepareDrink("Beet juice");

        Customer mike = new Customer("Michael", "Double Espresso");
        pam.takeOrder(mike);

        pam.prepareDrink("Double Espresso");

        Customer angela = new Customer("Angela", "Virgin Pinacolada");
        pam.takeOrder(angela);

        pam.prepareDrink("Virgin Pinacolada");
        
    }

}

