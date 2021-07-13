import attributes.PrimaryAttributes;
import characters.Warrior;
import items.Armor;
import items.Weapon;
import items.enumerations.ArmorType;
import items.enumerations.ItemSlot;
import items.enumerations.WeaponType;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    void TestEquipWeapon_ValidWeapon_ShouldPass() {
        Warrior warrior = new Warrior("Max");
        Weapon weapon = new Weapon("Common Axe",1, ItemSlot.WEAPON, WeaponType.AXE,7,1.1);

        try {
            assertTrue(warrior.equip(weapon));
        }
        catch(InvalidWeaponException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestEquipWeapon_HigherRequiredLevel_ShouldThrowException() {
        Warrior warrior = new Warrior("Max");
        Weapon weapon = new Weapon("Common Axe",2, ItemSlot.WEAPON, WeaponType.AXE,7,1.1);

        assertThrows(InvalidWeaponException.class, () -> {
            warrior.equip(weapon);
        });
    }

    @Test
    void TestEquipWeapon_WrongType_ShouldThrowException() {
        Warrior warrior = new Warrior("Max");
        Weapon weapon = new Weapon("Common Bow",1, ItemSlot.WEAPON, WeaponType.BOW,12,0.8);

        assertThrows(InvalidWeaponException.class, () -> {
            warrior.equip(weapon);
        });
    }

    @Test
    void TestEquipArmor_ValidArmor_ShouldPass() {
        Warrior warrior = new Warrior("Max");
        PrimaryAttributes attributes = new PrimaryAttributes(1,0,2,0);
        Armor armor = new Armor("Common Plate Body Armor",1,ItemSlot.BODY, ArmorType.PLATE,attributes);

        try {
            assertTrue(warrior.equip(armor));
        }
        catch(InvalidArmorException e) {
            e.printStackTrace();
        }
    }

    @Test
    void TestEquipArmor_HigherRequiredLevel_ShouldThrowException() {
        Warrior warrior = new Warrior("Max");
        PrimaryAttributes attributes = new PrimaryAttributes(1,0,2,0);
        Armor armor = new Armor("Common Plate Body Armor",2,ItemSlot.BODY, ArmorType.PLATE,attributes);

        assertThrows(InvalidArmorException.class, () -> {
            warrior.equip(armor);
        });
    }

    @Test
    void TestEquipArmor_WrongType_ShouldThrowException() {
        Warrior warrior = new Warrior("Max");
        PrimaryAttributes attributes = new PrimaryAttributes(1,0,2,0);
        Armor armor = new Armor("Common Cloth Head Armor",1,ItemSlot.HEAD, ArmorType.CLOTH,attributes);

        assertThrows(InvalidArmorException.class, () -> {
            warrior.equip(armor);
        });
    }

    @Test
    void TestTotalAttributes_NoEquipment_ShouldGiveExpectedResult() {
        Warrior warrior = new Warrior("Max");
        PrimaryAttributes expected = new PrimaryAttributes(5,2,10,1);
        PrimaryAttributes actual = warrior.getTotalPrimaryAttributes();

        assertEquals(expected, actual);
    }

    @Test
    void TestTotalAttributes_WithArmor_ShouldGiveExpectedResult() {
        Warrior warrior = new Warrior("Max");
        PrimaryAttributes attributes = new PrimaryAttributes(1,1,2,1);
        Armor armor = new Armor("Common Plate Body Armor",1,ItemSlot.BODY, ArmorType.PLATE,attributes);

        try {
            warrior.equip(armor);
        } catch (InvalidArmorException e) {
            e.printStackTrace();
        }

        PrimaryAttributes expected = new PrimaryAttributes(6,3,12,2);
        PrimaryAttributes actual = warrior.getTotalPrimaryAttributes();

        assertEquals(expected, actual);
    }

    @Test
    void TestDPS_NoWeapon_ShouldGiveExpectedResult() {
        Warrior warrior = new Warrior("Max");
        double expected = 1.05;
        double actual = warrior.getDPS();

        assertEquals(expected, actual);
    }

    @Test
    void TestDPS_WithWeapon_ShouldGiveExpectedResult() {
        Warrior warrior = new Warrior("Max");
        Weapon weapon = new Weapon("Common Axe",1, ItemSlot.WEAPON, WeaponType.AXE,7,1.1);
        try {
            warrior.equip(weapon);
        } catch (InvalidWeaponException e) {
            e.printStackTrace();
        }

        double expected = 8.09;
        double actual = warrior.getDPS();

        assertEquals(expected, actual);
    }

    @Test
    void TestDPS_WithWeaponAndArmor_ShouldGiveExpectedResult() {
        Warrior warrior = new Warrior("Max");
        Weapon weapon = new Weapon("Common Axe",1, ItemSlot.WEAPON, WeaponType.AXE,7,1.1);
        PrimaryAttributes attributes = new PrimaryAttributes(1,0,2,0);
        Armor armor = new Armor("Common Plate Body Armor",1, ItemSlot.BODY, ArmorType.PLATE, attributes);
        try {
            warrior.equip(weapon);
            warrior.equip(armor);
        } catch (InvalidWeaponException | InvalidArmorException e) {
            e.printStackTrace();
        }

        double expected = 8.16;
        double actual = warrior.getDPS();

        assertEquals(expected, actual);
    }
}