package com.yancy.guava.base.optional;

import com.google.common.base.Optional;

/**
 * Created by yancy on 2017/9/26.
 */
public class OptionalTest {

    public static void main(String[] args) {
        try {
            testOptional();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void testOptional() throws Exception {
        Optional<Integer> possible = Optional.of(6);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
    }
}
