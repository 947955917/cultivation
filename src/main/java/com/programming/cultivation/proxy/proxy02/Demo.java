package com.programming.cultivation.proxy.proxy02;

import com.programming.cultivation.proxy.common.Book;
import com.programming.cultivation.proxy.common.BookServiceImpl;
import com.programming.cultivation.proxy.common.IBookService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过动态代理的方式生成代理类，解决了多次创建代理类的麻烦
 *
 * @author biyue
 * @since 2020/03/25
 */
public class Demo {

    public static void main(String[] args) {
        BookServiceImpl service = new BookServiceImpl();
        IBookService bookService = (IBookService) Proxy.newProxyInstance(IBookService.class.getClassLoader(), new Class[]{IBookService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置代理");
                Object invoke = method.invoke(service, args);
                System.out.println("后置代理");
                return invoke;
            }
        });

        Book fish = bookService.getBook(5, "小金鱼");
        System.out.println(fish);


    }
}
