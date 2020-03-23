package com.programming.cultivation.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WebSocketServer {

    public static void main(String[] args) throws Exception {
        // 事件轮询组
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            // 服务端引导
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    // 指定IO模型
                    .channel(NioServerSocketChannel.class)
                    // 指定服务端绑定的本地地址
                    .localAddress(8088)
                    // 接收到Channel时，初始化工作
                    .childHandler(new WebSocketInitializer());
            // 绑定服务器，同步接收结果
            ChannelFuture future = b.bind().sync();
            // 获取Channle的CloseFuture,并且阻塞当前线程，直到它完成
            future.channel().closeFuture().sync();
        } finally {
            // 关闭线程池，释放资源
            group.shutdownGracefully();
        }


    }
}
