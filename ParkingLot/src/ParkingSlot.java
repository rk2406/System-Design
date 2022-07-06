public class ParkingSlot {
    private int id;
    boolean isAvailable=true;
    Vehicle vehicle;
    ParkingSlotType slotType;

    int getId() {
        return id;
    }

    ParkingSlot(int id, ParkingSlotType slotType) {
        this.id=id;
        this.slotType = slotType;
    }

    protected void addVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
        this.isAvailable=false;
    }

    protected void removeVehicle(Vehicle vehicle){
        this.vehicle=null;
        this.isAvailable=true;
    }

}
