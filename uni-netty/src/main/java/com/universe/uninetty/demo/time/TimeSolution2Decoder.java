package com.universe.uninetty.demo.time;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TimeSolution2Decoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4){
            log.info("TimeSolution2Decoder-decode-in");
            return;
        }
        out.add(in.readBytes(5));
        log.info("TimeSolution2Decoder-decode-out:{}",out);
    }
}
