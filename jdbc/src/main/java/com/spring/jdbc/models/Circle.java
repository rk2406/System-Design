package com.spring.jdbc.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Circle {
    @Id
    private int id;
    private String name;

    public Circle(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
