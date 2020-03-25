package com.programming.cultivation.proxy.proxy03;

import com.programming.cultivation.proxy.common.IBookService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工具类
 * 封装生成代理类的逻辑，对外暴露一个静态接口即可
 *
 * @author biyue
 * @since 2020/03/25
 */
public class ProxyUtils {

    public static <A> A proxy(Class<A> clazz, A a) {
        A proxyInstance = (A) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置代理");
                Object invoke = method.invoke(a, args);
                System.out.println("后置代理");
                return invoke;
            }
        });
        return proxyInstance;
    }
}
