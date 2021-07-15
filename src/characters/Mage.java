package characters;

import items.*;
import items.enumerations.ArmorType;
import items.enumerations.WeaponType;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

public class Mage extends Character {
    public Mage(String name) {
        super(name,1,1,5 ,8);
    }

    @Override
    public void levelUp(int levels) {
        if(levels > 0) {
            //Use a help-method to level up, located in the parent-class
            super.levelUpCharacter(levels,1 * levels,1 * levels,3 * levels,5 * levels);
        }

        else {
            throw new IllegalArgumentException("A character must gain 1 or more levels!");
        }
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.STAFF || weapon.getWeaponType() == WeaponType.WAND) {
            return super.equip(weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() == ArmorType.CLOTH) {
            return super.equip(armor);
        }

        else {
            throw new InvalidArmorException("This type of armor can't be equipped on this character!");
        }
    }

    /*
     * DPS is calculated using a help-method in the parent-class.
     * The parameter used is this character's primary attribute, in the Mage's case it's Intelligence.
     */
    @Override
    public double getDPS() {
        return super.getDPSCharacter(getTotalPrimaryAttributes().getIntelligence());
    }
}
