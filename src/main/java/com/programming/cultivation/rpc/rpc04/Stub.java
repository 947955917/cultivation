package com.programming.cultivation.rpc.rpc04;

import com.programming.cultivation.rpc.common.IUserService;
import com.programming.cultivation.rpc.common.User;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class Stub {

    public static IUserService getStub() {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // Socket连接
                Socket socket = new Socket("127.0.0.1", 8089);
                // 写出去
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                oos.writeUTF(method.getName());
                oos.writeObject(method.getParameterTypes());
                oos.writeObject(args);
                oos.flush();
                // 读回来
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                int ids = dataInputStream.readInt();
                String name = dataInputStream.readUTF();
                User user = new User(ids, name);
                return user;
            }
        };
        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[]{IUserService.class}, invocationHandler);
        return (IUserService) o;
    }
}
