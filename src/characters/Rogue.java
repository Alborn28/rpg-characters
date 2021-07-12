package characters;

import items.*;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

import java.util.HashMap;

public class Rogue extends Hero {
    public Rogue(String name) {
        super(name, 2, 6, 8 ,1);
    }

    @Override
    public void levelUp() {
        levelUpHero(1, 4, 3, 1);
    }

    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.DAGGER || weapon.getWeaponType() == WeaponType.SWORD) {
            super.equipHero(weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() == ArmorType.LEATHER || armor.getArmorType() == ArmorType.MAIL) {
            super.equipHero(armor);
        }

        else {
            throw new InvalidArmorException("This type of armor can't be equipped on this character!");
        }
    }
}
