package com.programming.cultivation.hibernate;

import com.programming.cultivation.base.Book;

public class Demo {

    public static void main(String[] args) {
        Book book = new Book();
        book.setName("abcd");
        ValidateResult validate = ValidatorUtils.validate(book);
        System.out.println(validate.toString());
        ValidateResult validate2 = ValidatorUtils.validateProperty(book, "id");
        System.out.println(validate2.toString());
    }
}
