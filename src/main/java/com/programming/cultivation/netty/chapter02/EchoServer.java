package com.programming.cultivation.netty.chapter02;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 引导服务器
 *
 * @author biyue
 * @since 2019/12/31
 */
public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        // 创建channel handler
        EchoServerHandler echoServerHandler = new EchoServerHandler();
        // 创建 EventLoopGroup
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            // 创建 ServerBootstrap
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(eventLoopGroup) //
                    .channel(NioServerSocketChannel.class) // 指定所使用的NIO传输Channel
                    .localAddress(new InetSocketAddress(port)) // 使用指定的端口设置套接字地址
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 添加一个EchoServerHandler到子Channel的ChannelPipeline
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(echoServerHandler);
                        }
                    });
            ChannelFuture channelFuture = serverBootstrap.bind().sync(); // 异步地绑定服务器，调用sync方法阻塞，等待直到绑定完成
            channelFuture.channel().closeFuture().sync(); // 获取channel的CloseFuture,并且阻塞当前线程直到他完成
        } finally {
            // 关闭EventLoopGroup,释放所有资源
            eventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoServer(8080).start();
    }
}
