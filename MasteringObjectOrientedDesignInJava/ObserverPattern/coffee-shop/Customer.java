public class Customer implements WaitingCustomer {

    String name;
    String drinkOrdered;

    public Customer(String name, String drinkOrdered) {
        this.name = name;
        this.drinkOrdered = drinkOrdered;
    }

    public void orderReady(String preparedDrink) {
        System.out.println("Hi I'm "+ name +". Thanks for my " + preparedDrink + ".");
    }

    public String orderDrink() {
        System.out.println("Hi I'm " + name + ". I'd like a " + drinkOrdered + " please.");
        return drinkOrdered;
    }

    public String getName() {
        return name;
    }

    public String getDrinkOrdered() {
        return drinkOrdered;
    }
    

}
