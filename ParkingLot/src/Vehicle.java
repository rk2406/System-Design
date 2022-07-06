public class Vehicle {
    private String license;
    private VehicleCategory vehicleCategory;

    Vehicle(String license, VehicleCategory vehicleCategory) {
        this.license = license;
        this.vehicleCategory = vehicleCategory;
    }

    String getLicense() {
        return license;
    }

    VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }
}
