package models;

public class Location {
    String city;
    String pinCode;

    public Location(String city, String pinCode) {
        this.city = city;
        this.pinCode = pinCode;
    }

    public String getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }
}
