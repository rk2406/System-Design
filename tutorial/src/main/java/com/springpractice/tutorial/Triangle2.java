package com.springpractice.tutorial;

import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

@Data
public class Triangle2 implements Shape {
    private List<Point> points;

    public void draw(){
        System.out.println("triangle   "+getPoints());
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Initialising bean init method called");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Destroying bean triangle");
//    }

    public void myInit(){
        System.out.println("Initialising bean init method called for triangle");
    }

    public void myDestroy(){
        System.out.println("Destroying bean triangle");
    }
}
