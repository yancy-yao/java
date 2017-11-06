package com.yancy.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by yancy on 2017/11/3.
 */
public class FunctionTest {

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<R>();
        for(T s: list) {
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
        );
    }
}
