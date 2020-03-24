package com.programming.cultivation.rpc.rpc01;

import com.programming.cultivation.rpc.common.User;

import java.io.*;
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
        Socket accept = server.accept();
        process(accept);
    }

    public static void process(Socket socket) throws Exception {
        // 读进来
        InputStream inputStream = socket.getInputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        int i = dis.readInt();
        User user = new UserServiceImpl().getUser(i);
        System.out.println(user);

        // 写出去
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
        dos.close();
    }
}
