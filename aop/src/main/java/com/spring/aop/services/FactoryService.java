package com.spring.aop.services;

import com.spring.aop.models.Circle;
import com.spring.aop.models.Triangle;

public class FactoryService {
    public Object getBean(String beanType){
        if(beanType.equals("ShapeService")) return new ShapeService();
        else if(beanType.equals("Circle")) return new Circle();
        else if(beanType.equals("Triangle")) return new Triangle();
        else return null;
    }
}
