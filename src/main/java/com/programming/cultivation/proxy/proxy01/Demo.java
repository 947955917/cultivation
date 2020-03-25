package com.programming.cultivation.proxy.proxy01;

import com.programming.cultivation.proxy.common.Book;
import com.programming.cultivation.proxy.common.BookServiceImpl;
import com.programming.cultivation.proxy.common.IBookService;

/**
 * @author biyue
 * @since 2020/03/25
 */
public class Demo {

    public static void main(String[] args) {
        IBookService BookServiceImpl = new BookServiceImpl();

        IBookService bookService = new BookServiceProxy(BookServiceImpl);

        Book book = bookService.getBook(5, "唐诗选集");
        System.out.println(book);
    }
}
