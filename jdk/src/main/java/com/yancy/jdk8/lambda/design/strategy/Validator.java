package com.yancy.jdk8.lambda.design.strategy;

/**
 * Created by yancy on 2017/11/6.
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s){
        return strategy.execute(s);
    }
}
