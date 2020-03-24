package com.programming.cultivation.netty.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class ByteBufTest {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("abcd", CharsetUtil.UTF_8);
        System.out.println("hasArray : " + byteBuf.hasArray());
        System.out.println("arrayOffset : " + byteBuf.arrayOffset());
        System.out.println("readerIndex : " + byteBuf.readerIndex());
        System.out.println("readableBytes : " + byteBuf.readableBytes());
        System.out.println("capacity : " + byteBuf.capacity());
        System.out.println("writerIndex : " + byteBuf.writerIndex());





    }
}
