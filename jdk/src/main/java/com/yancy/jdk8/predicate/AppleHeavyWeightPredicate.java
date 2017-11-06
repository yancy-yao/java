package com.yancy.jdk8.predicate;

/**
 * Created by yancy on 2017/11/3.
 */
public class AppleHeavyWeightPredicate implements  ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
