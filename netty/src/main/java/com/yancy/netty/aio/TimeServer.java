package com.yancy.netty.aio;

import com.yancy.netty.bio.TimeServerHandler;
import com.yancy.netty.bio.TimeServerHandlerExecutePool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yancy on 2017/10/11.
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args != null && args.length > 0){
            try{
                port = Integer.valueOf(args[0]);
            }catch(NumberFormatException e){

            }
        }

        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
