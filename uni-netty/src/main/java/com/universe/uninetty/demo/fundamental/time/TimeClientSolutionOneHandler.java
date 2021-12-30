package com.universe.uninetty.demo.fundamental.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * client handler solution1
 * 数据传输是字节流，不会按包发送，所以数据会碎片化
 * 解决1：内部累计缓存区，累计够规定的容量统一处理
 */
@Slf4j
public class TimeClientSolutionOneHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf byteBuf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("TimeClientSolutionOneHandler-handlerAdded");
        byteBuf = ctx.alloc().buffer(2);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        log.info("TimeClientSolutionOneHandler-handlerRemoved");
        byteBuf.release();
        byteBuf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;
        log.info("TimeClientSolutionOneHandler-channelRead-ByteBuf:{},m:{}",byteBuf,m);
        byteBuf.writeBytes(m);
        m.release();
        log.info("TimeClientSolutionOneHandler-channelRead-byteBuf.readableBytes():{}",byteBuf.readableBytes());
        if (byteBuf.readableBytes() >= 4) {
            long currentTimeMillis = (byteBuf.readUnsignedInt()) * 1000000L;
            boolean b = byteBuf.readBoolean();
            System.out.println(new Date(currentTimeMillis));
            System.out.println(b);
            ctx.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
