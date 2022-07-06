import java.time.Duration;


public class Ticket {
    private Vehicle vehicle;
    private ParkingSlot slot;
    private int startTime;
    static int id=0;

    private boolean isValid=false;

    Ticket(Vehicle vehicle, ParkingSlot slot, int startTime) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.startTime = startTime;
        id+=1;
        isValid=true;
    }

    Vehicle getVehicle() {
        return vehicle;
    }

    int getStartTime() {
        return startTime;
    }

    ParkingSlot getSlot() {
        return slot;
    }
    void setValid(boolean valid) {
        isValid = valid;
    }
}
