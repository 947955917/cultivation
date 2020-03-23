package com.programming.cultivation.jdk.net.nio;

import java.nio.ByteBuffer;

public class BufferTest {

    public static void main(String[] args) {
        // 分配一个字节缓冲区，指定容量
        ByteBuffer buffer = ByteBuffer.allocate(77);
        // 返回position 和 limit 之间的元素数量
        buffer.put((byte) 1);
        buffer.put((byte) 20);
        buffer.put((byte) 38);
        buffer.put((byte) 24);
        buffer.flip();
        byte[] data = new byte[buffer.remaining()];
        System.out.println(buffer.remaining());
        buffer.get(data);
        System.out.println(buffer.remaining());
        ByteBuffer temp = ByteBuffer.allocate(77);
        temp.put(data);

    }
}
