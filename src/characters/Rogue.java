package characters;

import items.Item;
import items.ItemSlot;
import items.Weapon;
import items.WeaponType;
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
            HashMap<ItemSlot, Item> equipment = super.getEquipment();
            equipment.put(weapon.getSlot(), weapon);
        }

        else {
            throw new InvalidWeaponException("This weapon can't be equipped on this character!");
        }
    }
}
