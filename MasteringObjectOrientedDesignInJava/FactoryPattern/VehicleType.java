public enum VehicleType {

    CAR {
        public Vehicle getVehicle() {
            return new Car();
        }
    }, 

    BUS {
        public Vehicle getVehicle() {
            return new Bus();
        }
    }, 

    TRUCK {
        public Vehicle getVehicle() {
            return new Truck();
        }
    }, 

    ELECTRIC_CAR {
        public Vehicle getVehicle() {
            return new ElectricCar();
        }
    };

    abstract Vehicle getVehicle();
        
}
