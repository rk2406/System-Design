package com.springpractice.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Circle implements Shape{
    private Point center;
    @Autowired
    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Point getCenter() {
        return center;
    }

    @Autowired
    @Qualifier("circleRelated")
    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw(){
        System.out.println(this.messageSource.getMessage("circle.center",new Object[]{center.getX(),center.getY()},"no message",null));
        System.out.println(this.messageSource.getMessage("greeting",null,"no message",null));
    }

    @PostConstruct
    public void initCircle(){
        System.out.println("initialised circle ");
    }
    @PreDestroy
    public void destroyCircle(){
        System.out.println("destroyed circle");
    }
}
