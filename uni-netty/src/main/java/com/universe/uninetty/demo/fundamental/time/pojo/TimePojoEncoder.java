package com.universe.uninetty.demo.fundamental.time.pojo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimePojoEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.info("TimePojoEncoder - write - start");
        TimePojo timePojo = (TimePojo) msg;
        log.info("TimePojoEncoder - write - timePojo:{}",timePojo);
        ByteBuf buffer = ctx.alloc().buffer(4);
        buffer.writeInt((int) timePojo.getValue());
        ctx.write(buffer,promise);
    }
}
