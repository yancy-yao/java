package com.yancy.jdk8.lambda.design.observer;

/**
 * Created by yancy on 2017/11/6.
 */
public class NyTimes implements Observer {
    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")){
            System.out.println("Breaking news in NY! " +tweet);
        }
    }
}
