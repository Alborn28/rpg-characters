package characters;

import items.*;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, 5, 2, 10 ,1);
    }

    @Override
    public void levelUp() {
        levelUpHero(3, 2, 5, 1);
    }

    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.AXE || weapon.getWeaponType() == WeaponType.HAMMER || weapon.getWeaponType() == WeaponType.SWORD) {
            super.equipHero(weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() == ArmorType.MAIL || armor.getArmorType() == ArmorType.PLATE) {
            super.equipHero(armor);
        }

        else {
            throw new InvalidArmorException("This type of armor can't be equipped on this character!");
        }
    }
}
