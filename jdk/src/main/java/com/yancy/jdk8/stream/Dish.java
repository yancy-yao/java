package com.yancy.jdk8.stream;

/**
 * Created by yancy on 2017/11/2.
 */
public class Dish {

    private final int calories;

    private final String name;

    private final boolean vegetarian;

    private final Type type;

    public enum Type {
        MEAT, FISH ,OTHER
    }
    public Dish() {
        calories = 0;
        name = "";
        vegetarian = false;
        type = Type.OTHER;
    }

    public Dish(int calories, String name) {
        this.calories = calories;
        this.name = name;
        vegetarian = false;
        type = Type.OTHER;
    }

    public Dish(int calories, String name, boolean vegetarian, Type type) {
        this.calories = calories;
        this.name = name;
        this.vegetarian = vegetarian;
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public Type getType() {
        return type;
    }
}
