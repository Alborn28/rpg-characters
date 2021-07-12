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

    }
}
