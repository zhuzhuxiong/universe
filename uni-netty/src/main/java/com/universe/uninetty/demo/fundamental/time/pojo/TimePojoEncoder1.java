package com.universe.uninetty.demo.fundamental.time.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class TimePojoEncoder1 extends MessageToByteEncoder<TimePojo> {
    @Override
    protected void encode(ChannelHandlerContext ctx, TimePojo msg, ByteBuf out) throws Exception {
        out.writeInt((int)msg.getValue());
    }
}
