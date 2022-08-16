package com.springpractice.tutorial;
import lombok.Data;

@Data
public class Triangle {
    private String type;
    private int height;
    public Triangle(String type){
        this.type=type;
    }
    public Triangle(int height){
        this.height=height;
    }
    public void  draw()
    {
        System.out.println(getType()+" Triangle drawn of height "+getHeight());
    }}
