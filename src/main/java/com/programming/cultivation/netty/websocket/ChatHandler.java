package com.programming.cultivation.netty.websocket;

import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelMatchers;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * TextWebSocketFrame：在Netty中，是用于WebSocket专门处理文本的对象，frame是消息的载体
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 用于记录和管理所有客户端的Channel
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String content = msg.text();
        System.out.println("接收到的数据：" + content);
//        for(Channel channel : clients){
//            channel.writeAndFlush();
//        }
        clients.writeAndFlush(new TextWebSocketFrame(content), ChannelMatchers.isNot(ctx.channel()));
    }

    /**
     * 当客户端连接服务端之后
     * 获取客户端的channel,并且放到ChannelGroup中进行管理
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当触发handlerRemoved时，ChannelGroup会自动移除对应客户端的channel
        // clients.remove(ctx.channel());
        System.out.println("客户端断开，Channel对应的长id为：" + ctx.channel().id().asLongText());
        System.out.println("客户端断开，Channel对应的短id为：" + ctx.channel().id().asShortText());
    }
}
