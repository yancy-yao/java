package com.yancy.jdk8.lambda.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yancy on 2017/11/6.
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}
