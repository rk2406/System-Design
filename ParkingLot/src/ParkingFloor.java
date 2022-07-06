import java.util.Map;

public class ParkingFloor {
    int floor;
    Map<ParkingSlotType, Map<Integer,ParkingSlot>> parkingSlots;

    ParkingFloor(int floor, Map<ParkingSlotType, Map<Integer, ParkingSlot>> parkingSlots) {
        this.floor = floor;
        this.parkingSlots = parkingSlots;
    }

    ParkingSlot getSlot(Vehicle vehicle){
        VehicleCategory vehicleCategory= vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType= pickCorrectSlot(vehicleCategory);
        Map<Integer, ParkingSlot> relevantTypeSlots= parkingSlots.get(parkingSlotType);
        ParkingSlot slot=null;
        for(Map.Entry<Integer,ParkingSlot> m:relevantTypeSlots.entrySet()){
            if(m.getValue().isAvailable){
                slot=m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }
        return slot;
    }

    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory){
        if(vehicleCategory.equals(VehicleCategory.BIKE)) return  ParkingSlotType.TwoWheeler;
        else if(vehicleCategory.equals(VehicleCategory.SEDAN)) return ParkingSlotType.Medium;
        else if(vehicleCategory.equals(VehicleCategory.BUS) || vehicleCategory.equals(VehicleCategory.TRUCK)) return ParkingSlotType.Large;
        return null;
    }
}
