package com.programming.cultivation.rpc.rpc01;

import com.programming.cultivation.rpc.common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8089);
        // 写出去
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
        dos.writeInt(99);
        dos.flush();
        // 读回来
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int id = dataInputStream.readInt();
        String name = dataInputStream.readUTF();
        User user = new User(id, name);
        System.out.println(user);

    }
}
