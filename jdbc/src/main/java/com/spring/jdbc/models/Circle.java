package com.spring.jdbc.models;

import lombok.Data;

@Data
public class Circle {
    private int id;
    private String name;

    public Circle(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
