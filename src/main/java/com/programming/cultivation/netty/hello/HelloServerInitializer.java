package com.programming.cultivation.netty.hello;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HelloServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 当收到请求时，通过编码器解编码
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        // 增加自定义handler
        pipeline.addLast("HelloHandler", new HelloHandler());
    }
}
