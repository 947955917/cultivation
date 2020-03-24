package com.programming.cultivation.netty.chat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.group.ChannelMatchers;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.CharsetUtil;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String text = msg.text();
        JSONObject jsonObject = JSON.parseObject(text);
        if (jsonObject.get("type").equals("login")) {
            ChannelPool.channelMap.put(jsonObject.getString("username"), ctx.channel());
//            ByteBuf info = Unpooled.copiedBuffer("登录成功", CharsetUtil.UTF_8);
//            ctx.writeAndFlush(new TextWebSocketFrame(info));

            ByteBufAllocator alloc = ctx.alloc();
            ByteBuf buffer = alloc.buffer();
            buffer.writeBytes("登录成功".getBytes());
            ctx.writeAndFlush(new TextWebSocketFrame(buffer));

            return;
        }
        if (jsonObject.get("type").equals("send")) {
            String to = jsonObject.getString("to");
            String msg1 = jsonObject.getString("msg");
            ByteBuf info = Unpooled.copiedBuffer(msg1, CharsetUtil.UTF_8);
            ChannelPool.CHANNEL_GROUP.writeAndFlush(new TextWebSocketFrame(info), ChannelMatchers.is(ChannelPool.channelMap.get(to)));
            return;
        }
        System.out.println("ChatHandler channelRead0" + text);
        ByteBuf byteBuf = Unpooled.copiedBuffer(text, CharsetUtil.UTF_8);
        ChannelPool.CHANNEL_GROUP.writeAndFlush(new TextWebSocketFrame(byteBuf));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ChatHandler handlerAdded...");
        Channel channel = ctx.channel();
        ChannelPool.CHANNEL_GROUP.add(channel);
        ChannelPool.channelMap.put(channel.id().asLongText(), channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // super.handlerRemoved(ctx);
        System.out.println(ctx.channel().id().asLongText() + " handlerRemoved...");
    }
}
