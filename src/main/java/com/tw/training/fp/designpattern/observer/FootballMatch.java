package com.tw.training.fp.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pzzheng
 * @date 1/18/18
 */
public class FootballMatch {
    List<FootballObserver> observers;

    public FootballMatch() {
        observers = new ArrayList<>();
    }

    public FootballMatch addObserver(FootballObserver observer) {
        observers.add(observer);
        return this;
    }

    public void score(String team) {
        observers.forEach(o -> o.notify(team));
    }
}
