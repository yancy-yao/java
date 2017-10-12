package com.yancy.netty.bio;

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
        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("The time server is start in port: "+ port);
            Socket socket = null;

            // demo1
            /**
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
             */

            //伪异步式I/O，通过创建线程池控制
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
            while(true){
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } finally{
            if(server != null){
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
