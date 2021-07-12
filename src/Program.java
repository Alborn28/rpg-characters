import characters.*;
import characters.Hero;
import items.Item;
import items.ItemSlot;
import items.Weapon;
import items.WeaponType;

public class Program {
    public static void main(String[] args) {
        /*Hero hero = new Mage("Max");

        hero.levelUp();

        Hero hero2 = new Warrior("Kevin");

        System.out.println(hero.toString());

        System.out.println(hero2.toString());*/

        Item axe = new Weapon("Small axe", 2, ItemSlot.WEAPON, WeaponType.AXE, 10, 0.8);

        System.out.println(axe.toString());


    }
}
