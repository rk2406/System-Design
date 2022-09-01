package models;

import lombok.Data;

import java.util.List;

@Data
public class Library {
    private List<Rack> racks;
    private int NUM_RACKS;

    private String name;
    public Library(List<Rack> racks, int NUM_RACKS) {
        this.racks = racks;
        this.NUM_RACKS = NUM_RACKS;
    }
}
