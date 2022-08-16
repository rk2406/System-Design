package com.springpractice.tutorial;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor{

    public Object postProcessAfterInitialization(Object bean, String beanName){
        System.out.println(" In After Initialization method . Bean name is : "+beanName);
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName){
        System.out.println(" In Before Initialization method . Bean name is : "+beanName);
        return bean;
    }
}
