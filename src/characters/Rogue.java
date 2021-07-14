package characters;

import items.*;
import items.enumerations.ArmorType;
import items.enumerations.WeaponType;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

public class Rogue extends Character {
    public Rogue(String name) {
        super(name,2,6,8 ,1);
    }

    @Override
    public void levelUp(int level) {
        if(level > 0) {
            levelUpHero(level,1 * level,4 * level,3 * level,1 * level);
        }

        else {
            throw new IllegalArgumentException("A character must gain 1 or more levels!");
        }
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.DAGGER || weapon.getWeaponType() == WeaponType.SWORD) {
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

    @Override
    public double getDPS() {
        return getDPSHero(getTotalPrimaryAttributes().getDexterity());
    }
}
