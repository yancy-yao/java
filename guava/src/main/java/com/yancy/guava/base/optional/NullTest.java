package com.yancy.guava.base.optional;

/**
 * Created by yancy on 2017/9/26.
 */
public class NullTest {

    public static void main(String[] args) {
        testNullObject();
    }

    public static void testNullObject() {
        if (null instanceof java.lang.Object) {
            System.out.println("null属于java.lang.Object类型");
        } else {
            System.out.println("null不属于java.lang.Object类型");
        }
    }

    public static void testNull() {
        int age = 0;
        System.out.println("user age:"+age);

        long money;
        money=10L;
        System.out.println("user money"+money);

        String name = null;
        System.out.println("user name:"+name);
    }
}
