public class VehicleFactory {

    public Vehicle getVehicle(VehicleType type) {
        return type.getVehicle();
    }

}
