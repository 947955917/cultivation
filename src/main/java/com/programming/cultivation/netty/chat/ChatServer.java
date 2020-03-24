package com.programming.cultivation.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class ChatServer {


    public static void main(String[] args) throws Exception {
        // 事件轮询组
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitializer());
            System.out.println(1);
            ChannelFuture future = b.bind(8080).sync();
            System.out.println(2);
            future.channel().closeFuture().sync();
            System.out.println(3);
        } finally {
            System.out.println(4);
            group.shutdownGracefully();
            System.out.println(5);
        }


    }
}
