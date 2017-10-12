package com.yancy.guava.base.object;

import com.google.common.base.Objects;

/**
 * Created by yancy on 2017/9/26.
 */
public class ObjectsTest {

    public static void main(String[] args) {
        equals();
    }

    //equals
    private static void equals(){
        //guava objects
        System.out.println(Objects.equal("a", "a")); // returns true
        System.out.println(Objects.equal(null, "a")); // returns false
        System.out.println(Objects.equal("a", null)); // returns false
        System.out.println(Objects.equal(null, null)); // returns true

        //jdk objects
        java.util.Objects.equals("a","a");

        //remark: jdk and guava objects is the same.
    }

    //hashCode
    private static void hashCodeTest(){
        Objects.hashCode(1);
    }
}
