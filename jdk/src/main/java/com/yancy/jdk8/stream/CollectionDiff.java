package com.yancy.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yancy on 2017/11/2.
 * jdk8相对于jdk7的新特性
 */
public class CollectionDiff {

    public static void jdk7Demo(){
        List<Dish> menu = new ArrayList<Dish>();
        menu.add(new Dish());

        //累加器筛选元素
        List<Dish> lowCaloricDished = new ArrayList<Dish>();
        for (Dish d: menu) {
            if (d.getCalories() < 400) {
                lowCaloricDished.add(d);
            }
        }

        //排序
        Collections.sort(lowCaloricDished, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<String>();
        for (Dish d : lowCaloricDished) {
            lowCaloricDishesName.add(d.getName());
        }
    }

    public static void jdk8Demo() {
        List<Dish> menu = new ArrayList<Dish>();
        menu.add(new Dish(100, "1"));
        menu.add(new Dish(300, "2"));
        menu.add(new Dish(200, "3"));
        menu.add(new Dish(400, "4"));
        menu.add(new Dish(500, "5"));
        menu.add(new Dish(600, "6"));
        menu.add(new Dish(500, "7"));

        List<String> lowCaloricDishesName = menu.stream()
                .filter(d -> d.getCalories() < 400)          //过滤
                .sorted(Comparator.comparing(Dish::getCalories))    //按照卡路里排序
                .map(Dish::getName)
                .collect(Collectors.toList());
        for(String name : lowCaloricDishesName) {
            System.out.println(name);
        }

        List<String> lowCaloricDishesName1 = menu.parallelStream()
                .filter(d -> d.getCalories() < 400)          //过滤
                .sorted(Comparator.comparing(Dish::getCalories))    //按照卡路里排序
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public static void foreach () {
        List<Dish> menu = new ArrayList<Dish>();
        menu.add(new Dish(100, "1"));
        menu.add(new Dish(300, "2"));
        menu.add(new Dish(200, "3"));
        menu.add(new Dish(400, "4"));
        menu.add(new Dish(500, "5"));
        menu.add(new Dish(600, "6"));
        menu.add(new Dish(500, "7"));

        List<String> names = new ArrayList<>();
        for (Dish d : menu) {
            names.add(d.getName());
        }

        List<String> names1 = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish d = iterator.next();
            names.add(d.getName());
        }

        //jdk8 foreach
        List<String> names2 = menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

    }

    public static void findOrMatch() {
        List<Dish> menu = new ArrayList<Dish>();

        //检查谓词是否至少匹配一个元素
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly.");
        }

        //检查谓词是否匹配所有元素
        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() < 100);

        boolean isHealthy1 = menu.stream()
                .noneMatch(d -> d.getCalories() >= 100);

        //查找元素
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSequareDivisibleByThree =
                someNumbers.stream()
                .map(x -> x*x)
                .filter(x -> x % 3 == 0)
                .findFirst();
    }

    //归纳
    public static void induce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //元素求和
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }

        int sum1 = numbers.stream().reduce(0, (a, b) -> a + b);
        int sum2 = numbers.stream().reduce(0, Integer::sum);

        //最大值最小值
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> min1 = numbers.stream().reduce((x, y) -> x < y ? x : y);
    }

    public static void main(String[] args) {
        jdk8Demo();
    }
}
