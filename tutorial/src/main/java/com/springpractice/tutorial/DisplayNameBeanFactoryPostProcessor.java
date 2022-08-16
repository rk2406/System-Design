package com.springpractice.tutorial;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DisplayNameBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
//    this is run by spring before bean factory itself is initialised
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("inside bean factory post processor");

    }
}
