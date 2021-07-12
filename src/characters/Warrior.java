package characters;

import items.Item;
import items.ItemSlot;
import items.Weapon;
import items.WeaponType;
import items.exceptions.InvalidWeaponException;

import java.util.HashMap;

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
            HashMap<ItemSlot, Item> equipment = super.getEquipment();
            equipment.put(weapon.getSlot(), weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }
}
