package characters;

import items.*;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

public class Mage extends Hero {
    public Mage(String name) {
        super(name,1,1,5 ,8);
    }

    @Override
    public void levelUp(int level) {
        if(level > 0) {
            levelUpHero(level,1 * level,1 * level,3 * level,5 * level);
        }

        else {
            throw new IllegalArgumentException("A character must gain 1 or more levels!");
        }
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.STAFF || weapon.getWeaponType() == WeaponType.WAND) {
            return super.equipHero(weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() == ArmorType.CLOTH) {
            return super.equipHero(armor);
        }

        else {
            throw new InvalidArmorException("This type of armor can't be equipped on this character!");
        }
    }

    @Override
    public double getDamage() {
        for( Item item : getEquipment().values()) {
            if(item instanceof Weapon) {
                Weapon weapon = (Weapon) item;
                double weaponDPS = weapon.getDPS();
                double result = weaponDPS * (1 + ((double) getTotalPrimaryAttributes().getIntelligence() / 100));
                result = (double) Math.round(result * 10) / 10;
                return result;
            }
        }

        double result = 1 * (1 + ((double) getTotalPrimaryAttributes().getIntelligence() / 100));
        result = (double) Math.round(result * 10) / 10;
        return result;
    }
}
