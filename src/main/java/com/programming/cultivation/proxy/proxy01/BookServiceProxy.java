package com.programming.cultivation.proxy.proxy01;

import com.programming.cultivation.proxy.common.Book;
import com.programming.cultivation.proxy.common.IBookService;

/**
 * 这种代理方式的完全可以实现我么的代理功能，但是有很大的局限性
 * 缺点：
 * 只能对特定的类进行代理,如果现在新增一个类，则必须针对新增的类增加一个代理类
 *
 * @author biyue
 * @since 2020/03/25
 */
public class BookServiceProxy implements IBookService {

    private IBookService bookService;

    public BookServiceProxy(IBookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Book getBook(Integer id, String name) {
        System.out.println("前置代理");
        Book book = bookService.getBook(id, name);
        System.out.println("后置代理");
        return book;
    }
}
