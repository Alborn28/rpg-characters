package battle;

import characters.Hero;

public class Battle {
    private Hero fighter1;
    private Hero fighter2;

    public Battle() {}

    public Battle(Hero fighter1, Hero fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public void setFighter1(Hero fighter1) {
        this.fighter1 = fighter1;
    }

    public void setFighter2(Hero fighter2) {
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
            BattleView.printResult(fighter1, fighter2);

        else
            BattleView.printResult(fighter2, fighter1);
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
            BattleView.printStatus(fighter1, fighter2, healthFighter1, healthFighter2);

            healthFighter2 -= BattleCalculations.calcDamagePerSecond(fighter1, fighter2);
            healthFighter1 -= BattleCalculations.calcDamagePerSecond(fighter2, fighter1);

            seconds++;
            Thread.sleep(1000);
        }

        if(healthFighter1 > healthFighter2) {
            BattleView.printResult(fighter1, fighter2, seconds);
        }

        else {
            BattleView.printResult(fighter2, fighter1, seconds);
        }
    }
}
