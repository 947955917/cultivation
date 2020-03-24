package com.programming.cultivation.netty.chat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class ChatServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        System.out.println("ChatServerInitializer initChannel...");
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        pipeline.addLast("ChunkedWriteHandler", new ChunkedWriteHandler());
        pipeline.addLast("HttpObjectAggregator", new HttpObjectAggregator(1024 * 60));
        // =============================以上是对http协议的支持========================================

        // WebSocket服务器处理协议
        pipeline.addLast("WebSocketServerProtocolHandler", new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast("ChatHandler", new ChatHandler());
    }


}
