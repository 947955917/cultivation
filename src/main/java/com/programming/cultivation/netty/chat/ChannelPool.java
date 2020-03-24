package com.programming.cultivation.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author biyue
 * @since 2020/03/24
 */
public class ChannelPool {

    public static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static final Map<String, Channel> channelMap = new ConcurrentHashMap<>();
}
