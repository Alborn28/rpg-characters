package characters;

import items.*;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

import java.util.HashMap;

public class Mage extends Hero {
    public Mage(String name) {
        super(name, 1, 1, 5 ,8);
    }

    @Override
    public void levelUp() {
        levelUpHero(1, 1, 3, 5);
    }

    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.STAFF || weapon.getWeaponType() == WeaponType.WAND) {
            super.equipHero(weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() == ArmorType.CLOTH) {
            super.equipHero(armor);
        }

        else {
            throw new InvalidArmorException("This type of armor can't be equipped on this character!");
        }
    }
}
