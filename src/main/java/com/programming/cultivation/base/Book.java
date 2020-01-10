package com.programming.cultivation.base;

import com.programming.cultivation.poi.common.anno.Excel;

import java.io.Serializable;

/**
 * @author biyue
 * @since 2020/01/09
 */
public class Book implements Serializable {

    private static final long serialVersionUID = -4704009876413943138L;

    @Excel(columnName = "ID", sort = 1)
    private int id;

    @Excel(columnName = "年龄", sort = 1)
    private Integer age;

    @Excel(columnName = "Name", sort = 2)
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Book(int id, Integer age, String name) {
        this.id = id;
        this.age = age;
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
