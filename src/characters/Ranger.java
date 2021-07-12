package characters;

import items.Item;
import items.ItemSlot;
import items.Weapon;
import items.WeaponType;
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
            HashMap<ItemSlot, Item> equipment = super.getEquipment();
            equipment.put(weapon.getSlot(), weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }
}
