package com.programming.cultivation.rpc.rpc04;

import com.programming.cultivation.rpc.common.User;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class Server {

    public static void main(String[] args) throws Exception {
        // 创建服务端
        ServerSocket server = new ServerSocket(8089);
        // 监听连接
        while (true) {
            Socket accept = server.accept();
            process(accept);
        }
    }

    public static void process(Socket socket) throws Exception {
        // 读进来
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        String methodName = ois.readUTF();
        Class[] paramsType = (Class[]) ois.readObject();
        Object[] params = (Object[]) ois.readObject();
        // 反射调用
        UserServiceImpl userService = new UserServiceImpl();
        Method method = userService.getClass().getMethod(methodName, paramsType);
        User user = (User)method.invoke(userService, params);
        // 写出去
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
        dos.close();
    }
}
