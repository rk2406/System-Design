package com.spring.aop.services;

import com.spring.aop.aspect.Loggable;
import com.spring.aop.models.Circle;
import com.spring.aop.models.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShapeService {
    private Circle circle;
    private Triangle triangle;

    @Loggable
    public Exception getCircle() {
        throw new RuntimeException("Hello world");
    }

    @Autowired
    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    @Autowired
    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
