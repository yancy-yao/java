package com.yancy.netty.codec.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yancy on 2017/10/12.
 */
public class TestSubscribeReqProto {

    private static byte[] encode(SubscribeReqProto.SubscribeReq req){
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException{
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqId(1);
        builder.setUserName("yancy");
        builder.setProductName("netty");
        List<String> address = new ArrayList<String>();
        address.add("Nanjing");
        address.add("Hangzhou");
        address.add("Beijing");
        builder.addAllAddress(address);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException{
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode : " + req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After encode : " + req.toString());
        System.out.println("Assert equal : " + req2.equals(req));

    }
}
