package com.programming.cultivation.hessian;

import java.io.Serializable;

/**
 * @author biyue
 * @since 2020/01/09
 */
public class Book implements Serializable {


    private static final long serialVersionUID = -4704009876413943138L;
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book() {
    }

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
