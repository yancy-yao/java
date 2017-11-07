package com.yancy.jdk8.lambda.design.strategy;

/**
 * Created by yancy on 2017/11/6.
 */
public class IsAllLowerCase implements ValidationStrategy {

    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
