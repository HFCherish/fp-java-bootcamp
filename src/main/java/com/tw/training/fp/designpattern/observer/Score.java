package com.tw.training.fp.designpattern.observer;

/**
 * @author pzzheng
 * @date 1/18/18
 */
public class Score {
    private String team;
    private int initScore;

    public Score(String team, int initScore) {
        this.team = team;
        this.initScore = initScore;
    }

    public Score addScore() {
        initScore++;
        System.out.println(team + " score! " + initScore);
        return this;
    }

    public String getTeam() {
        return team;
    }
}
