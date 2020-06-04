package com.programming.cultivation.beanfactory;

import org.springframework.beans.factory.FactoryBean;

public class Dog implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Dog dog = new Dog();
        dog.setName("山水间");
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
