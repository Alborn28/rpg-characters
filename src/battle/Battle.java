package battle;

import characters.Character;

public class Battle {
    private Character fighter1;
    private Character fighter2;
    private BattleView view;

    public Battle(BattleView view) {
        this.view = view;
    }

    public Battle(BattleView view, Character fighter1, Character fighter2) {
        this.view = view;
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public void setFighter1(Character fighter1) {
        this.fighter1 = fighter1;
    }

    public void setFighter2(Character fighter2) {
        this.fighter2 = fighter2;
    }

    /*
     *  A basic fighting simulation which ignores defensive stats.
     *  It simply divides fighter 1's DPS with fighter 2's health, calculating how long it would take for fighter 1 to kill fighter 2.
     *  Then it does the same calculation with fighter 2's DPS and fighter 1's health,
     *  and the fighter taking the shortest time to kill the other wins.
     */
    public void fightBasic() throws Exception {
        if(fighter1 == null || fighter2 == null) {
            throw new Exception("The battle must have two fighters!");
        }

        double timeToKillFighter1 = BattleCalculations.timeToKillFighter(fighter1, fighter2);
        double timeToKillFighter2 = BattleCalculations.timeToKillFighter(fighter2, fighter1);

        if(timeToKillFighter1 > timeToKillFighter2)
            view.showResult(fighter1, fighter2);

        else
            view.showResult(fighter2, fighter1);
    }

    /*
     *  A slightly more advanced fighting simulation which takes defensive stats into account as well.
     *  The way it works is that it calculates how much damage each fighter does to the other each second.
     *  The damage is subtracted from the fighter's health. This goes on until either a fighter dies, or
     *  the duration runs out.
     */
    public void fightAdvanced() throws Exception {
        if(fighter1 == null || fighter2 == null) {
            throw new Exception("The battle must have two fighters!");
        }

        int duration = 30;  //How long the fight will last, unless someone dies earlier.

        int healthFighter1 = fighter1.getSecondaryAttributes().getHealth();
        int healthFighter2 = fighter2.getSecondaryAttributes().getHealth();

        int seconds = 0;

        while((healthFighter1 > 0 && healthFighter2 > 0) && seconds < duration) {
            view.showStatus(fighter1, fighter2, healthFighter1, healthFighter2);

            healthFighter2 -= BattleCalculations.calcDamagePerSecond(fighter1, fighter2);
            healthFighter1 -= BattleCalculations.calcDamagePerSecond(fighter2, fighter1);

            seconds++;
            Thread.sleep(1000);
        }

        if(healthFighter1 > healthFighter2) {
            view.showResult(fighter1, fighter2, seconds);
        }

        else {
            view.showResult(fighter2, fighter1, seconds);
        }
    }
}
