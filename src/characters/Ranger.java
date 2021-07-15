package characters;

import items.*;
import items.enumerations.ArmorType;
import items.enumerations.WeaponType;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

public class Ranger extends Character {
    public Ranger(String name) {
        super(name,1,7,8 ,1);
    }

    @Override
    public void levelUp(int levels) {
        if(levels > 0) {
            //Use a help-method to level up, located in the parent-class
            super.levelUpCharacter(levels,1 * levels,5 * levels,2 * levels,1 * levels);
        }

        else {
            throw new IllegalArgumentException("A character must gain 1 or more levels!");
        }
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.BOW) {
            return super.equip(weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() == ArmorType.LEATHER || armor.getArmorType() == ArmorType.MAIL) {
            return super.equip(armor);
        }

        else {
            throw new InvalidArmorException("This type of armor can't be equipped on this character!");
        }
    }

    /*
     * DPS is calculated using a help-method in the parent-class.
     * The parameter used is this character's primary attribute, in the Ranger's case it's Dexterity.
     */
    @Override
    public double getDPS() {
        return super.getDPSCharacter(getTotalPrimaryAttributes().getDexterity());
    }
}
