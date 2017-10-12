package com.yancy.netty.nio;

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
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
