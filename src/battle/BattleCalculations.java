package battle;

import characters.Character;
import characters.Mage;
import items.Weapon;
import items.enumerations.ItemSlot;

public class BattleCalculations {
    protected static double timeToKillFighter(Character defender, Character attacker) {
        double result = (double) defender.getSecondaryAttributes().getHealth() / attacker.getDPS();
        return result;
    }

    /*
     * A method to calculate how much damage an attacker does to a defender each second.
     *
     * To note is that the defensive stats are multiplied by the attacker's attack speed.
     * This is so that the defensive stats are applied to every hit by the attacker.
     */
    protected static int calcDamagePerSecond(Character attacker, Character defender) {
        int damage;
        double attackSpeed = 1;
        double defence;

        //If the attacker has a weapon, that weapon's attack speed is used. Otherwise, the attack speed is set to 1.
        if(attacker.getEquipment().get(ItemSlot.WEAPON) != null) {
            Weapon weapon = (Weapon) attacker.getEquipment().get(ItemSlot.WEAPON);
            attackSpeed = weapon.getAttackSpeed();
        }

        //If the attacker is a mage, he deals magic damage thus elemental resistance is the defensive stat used.
        if(attacker instanceof Mage) {
            defence = defender.getSecondaryAttributes().getElementalResistance() * attackSpeed;
        }

        //If the attacker is not a mage, he deals physical damage so armor rating is what decreases the damage.
        else {
            defence = defender.getSecondaryAttributes().getArmorRating() * attackSpeed;
        }

        damage = (int) Math.round(attacker.getDPS() - defence);

        //If the attacker dealt any damage, return it. If damage is negative, return 0.
        if(damage > 0) {
            return damage;
        }

        return 0;
    }

}
