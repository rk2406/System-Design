import java.util.List;
import  java.util.Map;

public class ParkingLot {
    private final String name;
    private final Address address;
    private final List<ParkingFloor> floors;
    private  static ParkingLot parkingLot=null;

    private ParkingLot(String name, Address address, List<ParkingFloor> floors) {
        this.name = name;
        this.address = address;
        this.floors = floors;
    }

    static ParkingLot getInstance(String name, Address address, List<ParkingFloor> floors){
        if(parkingLot==null){
            parkingLot=new ParkingLot(name,address,floors);
        }
        return  parkingLot;
    }

    void addFloors(int floor, Map<ParkingSlotType,Map<Integer,ParkingSlot>> slots){
        ParkingFloor parkingFloor= new ParkingFloor(floor,slots);
        floors.add(parkingFloor);
    }

    void removeFloor(ParkingFloor parkingFloor){
        floors.remove(parkingFloor);
    }

    private ParkingSlot getParkingSlot(Vehicle vehicle){
        ParkingSlot slot;
        for(ParkingFloor floor: parkingLot.floors){
            slot=floor.getSlot(vehicle);
            if(slot!=null) return  slot;
        }
        return  null;
    }

    Ticket assignTicket(Vehicle vehicle){

        ParkingSlot slot= getParkingSlot(vehicle);
        if(slot==null) return  null;
        return new Ticket(vehicle,slot, 10);
    }

    double getPrice(Ticket ticket,int endTime){
        int startTime= ticket.getStartTime();
        int duration=endTime-startTime;
        ParkingSlotType category=ticket.getSlot().slotType;
        double price= category.getPrice(duration);
        ticket.setValid(false);
        return price;
    }
}
