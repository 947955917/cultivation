package com.programming.cultivation.beanfactory;

import org.springframework.beans.factory.annotation.Autowired;

public class Human {

    private String name;

    @Autowired
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", dog=" + dog +
                '}';
    }
}
