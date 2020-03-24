package com.programming.cultivation.rpc.rpc06;

import com.programming.cultivation.rpc.common.User;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class Stub {

    public static <T> T proxy(Class<T> clazz) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // Socket连接
                Socket socket = new Socket("127.0.0.1", 8089);
                // 写出去
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                oos.writeUTF(clazz.getName());
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
        T t = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, handler);
        return t;
    }

}
