package com.programming.cultivation.rpc.common;

import java.io.Serializable;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class User implements Serializable {
    private static final long serialVersionUID = 947916016182017001L;
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

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
