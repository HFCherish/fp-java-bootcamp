package com.tw.training.fp.designpattern.observer;

import org.junit.Test;

/**
 * @author pzzheng
 * @date 1/18/18
 */
public class FootballMatchTest {
    /**
     * @author pzzheng
     */
    @Test
    public void should_update_score_right_when_score() {
        FootballMatch footballMatch = new FootballMatch();
        footballMatch.addObserver(FootballObserver.scoreBoard(new Score("teama", 0), new Score("teamb", 0)));
        footballMatch.score("teama");
        footballMatch.score("teama");
        footballMatch.score("teama");
    }

    @Test
    public void should_update_score_right_when_score2() {
        FootballMatch footballMatch = new FootballMatch();
        footballMatch.addObserver(FootballObserver.scoreBoard("teama", "teamb"));
        footballMatch.score("teama");
        footballMatch.score("teama");
        footballMatch.score("teama");
    }
}