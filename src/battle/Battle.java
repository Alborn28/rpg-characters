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
     * A basic fighting simulation which ignores defensive stats.
     * It simply divides fighter 1's DPS with fighter 2's health, calculating how long it would take for fighter 1 to kill fighter 2.
     * Then it does the same calculation with fighter 2's DPS and fighter 1's health,
     * and the fighter taking the shortest time to kill the other wins.
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

    public void fightAdvanced() throws Exception {
        if(fighter1 == null || fighter2 == null) {
            throw new Exception("The battle must have two fighters!");
        }

        int healthFighter1 = fighter1.getSecondaryAttributes().getHealth();
        int healthFighter2 = fighter2.getSecondaryAttributes().getHealth();

        int seconds = 0;

        while((healthFighter1 > 0 && healthFighter2 > 0) && seconds < 30) {
            BattleView.printStatus(fighter1, fighter2, healthFighter1, healthFighter2);

            healthFighter2 -= BattleCalculations.calcDamage(fighter1, fighter2);
            healthFighter1 -= BattleCalculations.calcDamage(fighter2, fighter1);

            seconds++;
        }

        if(healthFighter1 > healthFighter2) {
            BattleView.printResult(fighter1, fighter2, seconds);
        }

        else {
            BattleView.printResult(fighter1, fighter2, seconds);
        }
    }
}
