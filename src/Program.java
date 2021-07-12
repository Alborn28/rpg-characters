import characters.*;
import characters.Hero;

public class Program {
    public static void main(String[] args) {
        Hero hero = new Warrior("Max");

        System.out.println(hero.toString());

        hero.levelUp();

        System.out.println(hero.toString());
    }
}
