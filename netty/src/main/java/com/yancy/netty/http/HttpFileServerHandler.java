package com.yancy.netty.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpVersion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import static io.netty.handler.codec.http.HttpHeaders.setContentLength;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.*;

/**
 * Created by yancy on 2017/10/13.
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{

    private final String url;

    public HttpFileServerHandler(String url) {
        this.url = url;
    }

    protected void messageReceived(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) throws Exception {
        if (!request.getDecoderResult().isSuccess()){
            //sendError(ctx, BAD_REQUEST);
            return;
        }
        if (request.getMethod() != GET){
            //sendError(ctx, METHOD_NOT_ALLOWED);
            return;
        }
        final String uri = request.getUri();
        final String path = "";
        //final String path = sanitizeUri(uri);
        if (path == null){
            //sendError(ctx, FORBIDDEN);
            return;
        }
        File file = new File(path);
        if (file.isHidden() || !file.exists()){
           // sendError(ctx, NOT_FOUND);
            return;
        }
        if (file.isDirectory()) {
            if (uri.endsWith("/")) {
                //sendListing(ctx, file);
            } else {
                //sendRedirect(ctx, url + '/');
            }
            return;
        }
        if (!file.isFile()) {
            //sendError(ctx, FORBIDDEN);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException e) {
            //sendError(ctx, NOT_FOUND);
            return;
        }
        long fileLength = randomAccessFile.length();
        HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1, OK);
        setContentLength(response, fileLength);
        //setContentTypeHeader(response, file);

    }
}
