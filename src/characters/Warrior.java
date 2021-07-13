package characters;

import items.*;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name,5,2,10 ,1);
    }

    @Override
    public void levelUp(int level) {
        if(level > 0) {
            levelUpHero(level,3 * level,2 * level,5 * level,1 * level);
        }

        else {
            throw new IllegalArgumentException("A character must gain 1 or more levels!");
        }
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.AXE || weapon.getWeaponType() == WeaponType.HAMMER || weapon.getWeaponType() == WeaponType.SWORD) {
            return super.equipHero(weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() == ArmorType.MAIL || armor.getArmorType() == ArmorType.PLATE) {
            return super.equipHero(armor);
        }

        else {
            throw new InvalidArmorException("This type of armor can't be equipped on this character!");
        }
    }

    @Override
    public double getDamage() {
        return getDamageHero(getTotalPrimaryAttributes().getStrength());
    }
}
