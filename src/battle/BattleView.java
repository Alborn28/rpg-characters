package battle;

import characters.Hero;

public class BattleView {

    protected static void printResult(Hero winner, Hero loser) {
        System.out.println(winner.getName() + " killed " + loser.getName());
    }
    protected static void printResult(Hero winner, Hero loser, int seconds) {
        System.out.println("\n" + winner.getName() + " killed " + loser.getName() + " after " + seconds + " seconds.");
    }

    /*
     * Print the fighter's names and their corresponding health.
     */
    protected static void printStatus(Hero fighter1, Hero fighter2, int health1, int health2) {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println(String.format("%-15s%15s\n%-15d%15d", fighter1.getName(), fighter2.getName(), health1, health2));
        System.out.println("------------------------------");
        System.out.println();
    }
}
