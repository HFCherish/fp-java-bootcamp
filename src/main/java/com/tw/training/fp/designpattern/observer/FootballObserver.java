package com.tw.training.fp.designpattern.observer;

/**
 * @author pzzheng
 * @date 1/18/18
 */
@FunctionalInterface
public interface FootballObserver {
    void notify(String team);

    FootballObserver fan = x -> System.out.println("haoo");


    static FootballObserver scoreBoard(Score teama, Score teamb) {
        return team ->  {
            if(team.equals(teama.getTeam())) {
                teama.addScore();
            } else {
                teamb.addScore();
            }
        };
    }

    static FootballObserver scoreBoard(String teama, String teamb) {
        return new FootballObserver() {
            private String teama;
            private String teamb;
            private int scorea;
            private int scoreb;

            private FootballObserver init(String teama, String teamb) {
                this.teama = teama;
                this.teamb = teamb;
                return this;
            }


            @Override
            public void notify(String team) {
                if(team.equals(teama)) {
                    scorea++;
                } else {
                    scoreb++;
                }

                System.out.println(teama + " : " + teamb + " = " + scorea + " : " + scoreb);
            }
        }.init(teama,teamb);
    }
}
