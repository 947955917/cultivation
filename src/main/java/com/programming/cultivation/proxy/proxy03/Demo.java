package com.programming.cultivation.proxy.proxy03;

import com.programming.cultivation.proxy.common.Book;
import com.programming.cultivation.proxy.common.BookServiceImpl;
import com.programming.cultivation.proxy.common.IBookService;

/**
 * @author biyue
 * @since 2020/03/25
 */
public class Demo {

    public static void main(String[] args) {
        IBookService proxy = ProxyUtils.proxy(IBookService.class, new BookServiceImpl());
        Book book = proxy.getBook(5, "大树啊");
        System.out.println(book);
    }
}
