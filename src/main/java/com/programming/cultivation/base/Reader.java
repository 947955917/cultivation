package com.programming.cultivation.base;

import com.programming.cultivation.base.Book;

import java.util.List;

/**
 * @author biyue
 * @since 2020/01/09
 */
public class Reader {

    private Integer id;

    private String username;

    private String password;

    private List<Book> ownBooks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getOwnBooks() {
        return ownBooks;
    }

    public void setOwnBooks(List<Book> ownBooks) {
        this.ownBooks = ownBooks;
    }

    public Reader(Integer id, String username, String password, List<Book> ownBooks) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ownBooks = ownBooks;
    }

    public Reader() {
    }
}
