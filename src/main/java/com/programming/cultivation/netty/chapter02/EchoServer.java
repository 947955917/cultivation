package com.programming.cultivation.netty.chapter02;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EchoServerHandler serverHandler = new EchoServerHandler();
        // 创建 EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建服务端引导
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class) // 指定所使用的NIO传输Channel
                    .localAddress(new InetSocketAddress(port)) // 设置Socket地址+端口
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 添加ChannelHandler到子Channel 的ChannelPipeline
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(serverHandler);
                            System.out.println("初始化通道");
                        }
                    });
            // 异步绑定服务器，sync()方法是同步方法，直到绑定完成
            ChannelFuture f = b.bind().sync();
            // 获取Channle的CloseFuture,并且阻塞当前线程，直到它完成
            f.channel().closeFuture().sync();
        } finally {
            // 关闭EventLoopGroup,释放所有的资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoServer(8080).start();
    }

}

