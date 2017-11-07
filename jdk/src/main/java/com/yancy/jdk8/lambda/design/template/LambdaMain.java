package com.yancy.jdk8.lambda.design.template;

/**
 * Created by yancy on 2017/11/6.
 */
public class LambdaMain {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) ->
                System.out.println("Hello " + c.getName()));
    }
}
