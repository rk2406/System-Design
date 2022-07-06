import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ParkingSlot slot1= new ParkingSlot(1,ParkingSlotType.TwoWheeler);
        ParkingSlot slot2= new ParkingSlot(2,ParkingSlotType.TwoWheeler);
        ParkingSlot slot3= new ParkingSlot(3,ParkingSlotType.Medium);
        ParkingSlot slot4= new ParkingSlot(4,ParkingSlotType.Large);

        Map<Integer,ParkingSlot> twoWheelerParkingSlotMap = new HashMap<>();
        twoWheelerParkingSlotMap.put(slot1.getId(),slot1);
        twoWheelerParkingSlotMap.put(slot2.getId(),slot2);

        Map<Integer,ParkingSlot> mediumParkingSlotMap = new HashMap<>();
        mediumParkingSlotMap.put(slot3.getId(),slot3);

        Map<Integer,ParkingSlot> largeParkingSlotMap = new HashMap<>();
        largeParkingSlotMap.put(slot4.getId(),slot4);

        Map<ParkingSlotType,Map<Integer,ParkingSlot>> parkingSlotTypeMap= new HashMap<>();
        parkingSlotTypeMap.put(ParkingSlotType.TwoWheeler,twoWheelerParkingSlotMap);
        parkingSlotTypeMap.put(ParkingSlotType.Medium,mediumParkingSlotMap);
        parkingSlotTypeMap.put(ParkingSlotType.Large,largeParkingSlotMap);

        ParkingFloor parkingFloor= new ParkingFloor(1, parkingSlotTypeMap);

        Address address= new Address();

        List<ParkingFloor> parkingFloorList=new ArrayList<>();
        parkingFloorList.add(parkingFloor);

        ParkingLot parkingLot= ParkingLot.getInstance("Microsoft",address,parkingFloorList);

        Vehicle vehicle1= new Vehicle("AXCD",VehicleCategory.BIKE);

        Vehicle vehicle2= new Vehicle("AXYD",VehicleCategory.TRUCK);

        Ticket ticket1=parkingLot.assignTicket(vehicle1);
        System.out.println(ticket1.getSlot().getId());

        Ticket ticket2=parkingLot.assignTicket(vehicle2);
        System.out.println(ticket2.getSlot().getId());

        System.out.println(parkingLot.getPrice(ticket1,30));
        System.out.println(parkingLot.getPrice(ticket2,60));
    }
}