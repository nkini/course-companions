import java.util.List;
import java.util.ArrayList;

public class CoffeeAttendant {

    // What a perfect opportunity for using a Queue though...
    private List<Customer> customerList;
    private List<String> drinkList;
    private String completedDrink;

    public CoffeeAttendant() {
        customerList = new ArrayList<Customer>();
        drinkList = new ArrayList<String>();
    }

    public void takeOrder(Customer customer) {
        String order = customer.orderDrink();
        drinkList.add(order);
        customerList.add(customer);
    }

    public void prepareDrink(String drinkToPrepare) {
        // Again, why is this preferred over passing an argument,,,?
        completedDrink = drinkToPrepare;
        callOutCompletedOrder();
    }

    public void callOutCompletedOrder() {
        boolean customerFound = false;
        Customer customerServed = null;
        int i = 0;

        for (Customer customer : customerList) {
            if (customer.getDrinkOrdered() == completedDrink) {
                System.out.println(customer.getName() + ", your " + completedDrink + " is ready!");
                customer.orderReady(completedDrink);
                customerFound = true;
                customerServed = customer;
                break;
            }
        }
        if (customerFound) {
            customerList.remove(customerServed);
            drinkList.remove(customerServed.getDrinkOrdered());
        }
    }

}
