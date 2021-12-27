package com.universe.uninetty.demo.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * the most simplify demo -- discard
 *
 * @author L
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 其他兄弟方法：channelReadComplate()、channelRegistered();
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf mg = (ByteBuf) msg;
        try {
            while (mg.isReadable()) {
                System.out.println((char) mg.readByte());
                System.out.flush();
            }
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
