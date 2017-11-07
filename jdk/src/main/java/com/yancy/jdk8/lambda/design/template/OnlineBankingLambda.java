package com.yancy.jdk8.lambda.design.template;

import java.util.function.Consumer;

/**
 * Created by yancy on 2017/11/6.
 */
public class OnlineBankingLambda {

    public void processCustomer(int id, Consumer<Customer> make){
        Customer c = Database.getCustomerWithId(id);
        make.accept(c);
    }
}
