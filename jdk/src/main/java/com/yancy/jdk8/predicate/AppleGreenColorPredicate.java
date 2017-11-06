package com.yancy.jdk8.predicate;

/**
 * Created by yancy on 2017/11/3.
 */
public class AppleGreenColorPredicate implements  ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
