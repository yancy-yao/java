package com.yancy.jdk8.lambda.design.observer;

/**
 * Created by yancy on 2017/11/6.
 */
public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")){
            System.out.println("Yet another news in Landon! " +tweet);
        }
    }
}
