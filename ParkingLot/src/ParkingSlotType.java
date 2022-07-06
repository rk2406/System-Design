public enum ParkingSlotType {
    TwoWheeler{
        double getPrice(long duration) {
            return duration * 0.05;
        }
    },
    Medium{
        double getPrice(long duration) {
            return duration * 0.075;
        }
    },
    Large{
        double getPrice(long duration) {
            return duration * 0.1;
        }
    };

    abstract double getPrice(long duration);

}
