package com.programming.cultivation.rpc.rpc03;

import com.programming.cultivation.rpc.common.User;
import com.programming.cultivation.rpc.rpc02.UserServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
