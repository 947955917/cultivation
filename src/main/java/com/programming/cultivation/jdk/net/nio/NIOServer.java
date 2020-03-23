package com.programming.cultivation.jdk.net.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;


public class NIOServer implements Runnable {

    public static void main(String[] args) {
        new Thread(new NIOServer(8080)).start();
    }

    /**
     * 多路复用器，选择器
     */
    private Selector selector;
    /**
     * 定义两个缓存，分别用于读和写
     */
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    private void init(int port) {
        try {
            System.out.println("server starting at port：" + port + "...");
            this.selector = Selector.open();
            // 开启服务端
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 绑定端口
            serverSocketChannel.bind(new InetSocketAddress(port));
            // 非阻塞
            serverSocketChannel.configureBlocking(false);
            // 注册，并标记当前服务通道状态
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server started...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NIOServer(int port) {
        init(port);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 这是一个阻塞方法，当至少一个通道被选中时返回。
                System.out.println("this.selector.select() before");
                int select = this.selector.select();
                System.out.println("this.selector.select()=" + select + " after");
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    // 从迭代器中取出被选中的通道
                    SelectionKey key = keys.next();
                    // 将本次需要处理的通道从集合中删除
                    keys.remove();
                    // 通道是否有效
                    if (key.isValid()) {
                        try {
                            if (key.isAcceptable()) {
                                accept(key);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            key.cancel();
                        }

                        try {
                            if (key.isReadable()) {
                                read(key);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            key.cancel();
                        }

                        try {
                            if (key.isWritable()) {
                                write(key);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            key.cancel();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key) {
        try {
            System.out.println("执行 accept 方法");
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(this.selector, SelectionKey.OP_READ);
            socketChannel.register(this.selector, SelectionKey.OP_WRITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        try {
            System.out.println("执行 read 方法");
            // 清空读缓存
            this.readBuffer.clear();
            // 获取通道
            SocketChannel socketChannel = (SocketChannel) key.channel();
            // 将通道中的数据读取到缓存中
            int readLength = socketChannel.read(readBuffer);
            if (readLength == -1) {
                key.channel().close();
                key.cancel();
                return;
            }
            this.readBuffer.flip();
            System.out.println("readBuffer.remaining() = " + readBuffer.remaining());
            byte[] datas = new byte[readBuffer.remaining()];
            readBuffer.get(datas);
            System.out.println("readBuffer.remaining() = " + readBuffer.remaining());
            System.out.println("from " + socketChannel.getRemoteAddress() + " client : " + new String(datas));
            socketChannel.register(this.selector, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void write(SelectionKey key) {
        try {
            writeBuffer.clear();
            System.out.println("执行 write 方法");
            SocketChannel socketChannel = (SocketChannel) key.channel();
            writeBuffer.put("我是服务端".getBytes());
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            socketChannel.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
