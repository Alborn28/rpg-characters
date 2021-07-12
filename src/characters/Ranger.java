package characters;

import items.*;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

import java.util.HashMap;

public class Ranger extends Hero {
    public Ranger(String name) {
        super(name, 1, 7, 8 ,1);
    }

    @Override
    public void levelUp() {
        levelUpHero(1, 5, 2, 1);
    }

    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getWeaponType() == WeaponType.BOW) {
            if(weapon.getRequiredLevel() <= this.getLevel()) {
                HashMap<ItemSlot, Item> equipment = this.getEquipment();
                equipment.put(weapon.getSlot(), weapon);
            }

            else {
                throw new InvalidWeaponException("Your character's level is not high enough to equip that weapon!");
            }
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        if(armor.getArmorType() == ArmorType.LEATHER || armor.getArmorType() == ArmorType.MAIL) {
            if(armor.getRequiredLevel() <= this.getLevel()) {
                HashMap<ItemSlot, Item> equipment = this.getEquipment();
                equipment.put(armor.getSlot(), armor);
            }

            else {
                throw new InvalidArmorException("Your character's level is not high enough to equip that piece of armor!");
            }
        }

        else {
            throw new InvalidArmorException("This type of armor can't be equipped on this character!");
        }
    }
}
