public class Vehicle {

    float price;
    String type;
    String make;
    int horsePower;
    String model;
    String color;
    int doors;

    private Vehicle(Builder builder) {
        this.price = builder.price;
        this.type = builder.type;
        this.make = builder.make;
        this.horsePower = builder.horsePower;
        this.model = builder.model;
        this.color = builder.color;
        this.doors = builder.doors;
    }

    public String toString() {
        return   "Vehicle [price=" + price + ", type=" + type
               + ", make=" + make + ", horsePower=" + horsePower
               + ", model=" + model + ", color=" + color
               + ", doors=" + doors + "]"; 
    }

    public static class Builder {

        float price;
        String type;
        String make;
        int horsePower;
        String model;
        String color;
        int doors;

        public Vehicle build() {
            return new Vehicle(this);
        }

        public Builder price(float value) {
            this.price = value;
            return this;
        }

        public Builder type(String value) {
            this.type = value;
            return this;
        }

        public Builder make(String value) {
            this.make = value;
            return this;
        }

        public Builder horsePower(int value) {
            this.horsePower = value;
            return this;
        }

        public Builder model(String value) {
            this.model = value;
            return this;
        }

        public Builder color(String value) {
            this.color = value;
            return this;
        }

        public Builder doors(int value) {
            this.doors = value;
            return this;
        }


    }
}
