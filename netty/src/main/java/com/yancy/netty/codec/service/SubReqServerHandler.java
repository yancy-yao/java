package com.yancy.netty.codec.service;

import com.yancy.netty.codec.protobuf.SubscribeReqProto;
import com.yancy.netty.codec.protobuf.SubscribeRespProto;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by yancy on 2017/10/12.
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
        if("yancy".equalsIgnoreCase(req.getUserName())){
            System.out.println("Service accept client req : [" + req.toString() + "]" );
            ctx.writeAndFlush(resp(req.getSubReqId()));
        }
    }

    private SubscribeRespProto.SubscribeResp resp(int subReqId){
        SubscribeRespProto.SubscribeResp.Builder builder = SubscribeRespProto.SubscribeResp.newBuilder();
        builder.setSubReqId(subReqId);
        builder.setRespCode(0);
        builder.setDesc("netty oder succeed");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
