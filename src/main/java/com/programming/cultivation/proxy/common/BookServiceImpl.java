package com.programming.cultivation.proxy.common;

/**
 * @author biyue
 * @since 2020/03/25
 */
public class BookServiceImpl implements IBookService {

    @Override
    public Book getBook(Integer id, String name) {
        return new Book(id, name);
    }
}
