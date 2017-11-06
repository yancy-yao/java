package com.yancy.jdk8.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by yancy on 2017/11/3.
 */
public class ApplePredicateMain {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        //策略模式
        filterApples(inventory, new AppleGreenColorPredicate());
        //匿名类
        filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        //Lambda表达式
        filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));

        List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    //将List类型抽象化
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    //comprator demo
    public static void comparator() {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
    }

    //runnable demo
    public static void runnable() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world.");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Hello world"));
    }
}
