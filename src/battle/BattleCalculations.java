package battle;

import characters.Hero;
import characters.Mage;
import items.Weapon;
import items.enumerations.ItemSlot;

public class BattleCalculations {
    protected static double timeToKillFighter(Hero defender, Hero attacker) {
        double result = (double) defender.getSecondaryAttributes().getHealth() / attacker.getDPS();
        return result;
    }

    protected static int calcDamage(Hero attacker, Hero defender) {
        int damage;
        double attackSpeed = 1;
        if(attacker.getEquipment().get(ItemSlot.WEAPON) != null) {
            Weapon weapon = (Weapon) attacker.getEquipment().get(ItemSlot.WEAPON);
            attackSpeed = weapon.getAttackSpeed();
        }

        if(attacker instanceof Mage) {
            double defence = defender.getSecondaryAttributes().getElementalResistance() * attackSpeed;
            damage = (int) Math.round(attacker.getDPS() - defence);
        }

        else {
            double defence = defender.getSecondaryAttributes().getArmorRating() * attackSpeed;
            damage = (int) Math.round(attacker.getDPS() - defence);
        }

        if(damage > 0) {
            System.out.println(attacker.getName() + " did " + damage + " damage to " + defender.getName());
            return damage;
        }

        return 0;
    }

}
