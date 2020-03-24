package com.programming.cultivation.rpc.rpc02;

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
public class Stub {

    public User getUser(Integer id) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8089);
        // 写出去
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(99);
        dataOutputStream.flush();
        // 读回来
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int ids = dataInputStream.readInt();
        String name = dataInputStream.readUTF();
        User user = new User(ids, name);
        return user;
    }
}
