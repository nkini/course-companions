public class App {

    public static void main(String args[]) {
        Vehicle car = new Vehicle.Builder().price(10300.76f)
                                           .type("car")
                                           .make("Honda")
                                           .horsePower(150)
                                           .model("Accord")
                                           .color("red")
                                           .doors(4)
                                           .build();
        System.out.println(car);
    }

}
