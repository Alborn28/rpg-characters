package battle;

import battle.Battle;
import battle.ConsoleView;
import characters.*;
import characters.Character;
import items.*;
import items.enumerations.ItemSlot;
import items.enumerations.WeaponType;
import items.exceptions.InvalidWeaponException;

public class BattleDemo {
    public static void main(String[] args) {
        Character character1 = new Rogue("Max");
        Character character2 = new Warrior("Kevin");
        Battle battle = new Battle(new ConsoleView(), character1, character2);

        character1.levelUp(2);
        character2.levelUp(1);

        Weapon weapon1 = new Weapon("Small Dagger", 1, ItemSlot.WEAPON, WeaponType.DAGGER, 15, 2.4);
        Weapon weapon2 = new Weapon("Small Axe", 1, ItemSlot.WEAPON, WeaponType.AXE, 35, 1.1);

        try {
            character1.equip(weapon1);
            character2.equip(weapon2);
        } catch (InvalidWeaponException e) {
            e.printStackTrace();
        }

        try {
            battle.fightAdvanced();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
