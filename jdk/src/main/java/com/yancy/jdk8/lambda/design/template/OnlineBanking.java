package com.yancy.jdk8.lambda.design.template;

/**
 * Created by yancy on 2017/11/6.
 */
public abstract class OnlineBanking {

    public void processCustomer(int id){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);
}
