package com.yancy.netty.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by yancy on 2017/10/11.
 */
public class TimeServerHandler implements  Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while(true){
                body = in.readLine();
                if(body == null)
                    break;
                System.out.println("The time server receiver order: " + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new
                        Date(System.currentTimeMillis()).toString(): "BAD ORDER";
                System.out.println("currentTime: " + currentTime);
                // out.print(currentTime) client端获取不到时间， PrintWriter 的println和print区别？
                out.println(currentTime);

            }
        } catch (Exception e){
            if(in != null){
                try{
                    in.close();
                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            if(out != null){
                out.close();
                out = null;
            }
            if(this.socket !=  null){
                try{
                    this.socket.close();
                } catch (IOException e2){
                    e2.printStackTrace();
                }
            }
            this.socket = null;
        }
    }
}
