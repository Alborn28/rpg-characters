package characters;

import items.Item;
import items.ItemSlot;
import items.Weapon;
import items.WeaponType;
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
            HashMap<ItemSlot, Item> equipment = super.getEquipment();
            equipment.put(weapon.getSlot(), weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }
}
