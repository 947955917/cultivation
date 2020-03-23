package com.programming.cultivation.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // websocket 基于http协议的，所以需要用http编解码器
        pipeline.addLast("HttpServerCodec", new HttpServerCodec());
        // 对写大数据流的支持
        pipeline.addLast("ChunkedWriteHandler", new ChunkedWriteHandler());
        // 对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse
        // 在Netty中编程中，几乎所有地方都会使用此Handler
        pipeline.addLast("HttpObjectAggregator", new HttpObjectAggregator(1024 * 64));

        // ===============================以上是用于支持Http协议的Handler===========================

        /**
         * websocket 服务器处理的协议，用于指定给客户端连接访问的路由
         * 本handler会帮你处理一些繁重复杂的事情
         * 会帮你处理握手动作：handshaking(close,ping,pong) ping+pong=心跳
         * 对于websocket来讲，都是以frames进行传输的,不同的数据类型对应的frames也不同
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        // 自定义Handler
        pipeline.addLast(new ChatHandler());
    }
}
