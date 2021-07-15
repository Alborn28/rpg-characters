package battle;

import characters.Character;

public class ConsoleView implements BattleView {

    public void showResult(Character winner, Character loser) {
        System.out.println(winner.getName() + " killed " + loser.getName());
    }
    public void showResult(Character winner, Character loser, int seconds) {
        System.out.println("\n" + winner.getName() + " killed " + loser.getName() + " after " + seconds + " seconds.");
    }

    /*
     * Print the fighter's names and their corresponding health.
     */
    public void showStatus(Character fighter1, Character fighter2, int health1, int health2) {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println(String.format("%-15s%15s\n%-15d%15d", fighter1.getName(), fighter2.getName(), health1, health2));
        System.out.println("------------------------------");
        System.out.println();
    }
}
