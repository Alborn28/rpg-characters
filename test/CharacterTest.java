import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;
import characters.Mage;
import characters.Ranger;
import characters.Rogue;
import characters.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void TestCreateCharacter_NullInput_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Warrior warrior = new Warrior(null);
        });
    }

    @Test
    void TestCreateCharacter_ValidInput_ShouldBeLevelOne() {
        Warrior warrior = new Warrior("Max");
        int level = warrior.getLevel();

        assertEquals(1, level);
    }

    @Test
    void TestLevelUp_ValidInput_ShouldBeLevelTwo() {
        Warrior warrior = new Warrior("Max");
        warrior.levelUp(1);
        int level = warrior.getLevel();

        assertEquals(2, level);
    }

    @Test
    void TestLevelUp_InvalidInput_ShouldThrowException() {
        Warrior warrior = new Warrior("Max");

        assertThrows(IllegalArgumentException.class, () -> {
            warrior.levelUp(-1);
        });
    }

    @Test
    void TestCreateWarrior_ValidInput_ShouldHaveCorrectPrimaryAttributes() {
        Warrior warrior = new Warrior("Max");
        PrimaryAttributes expected = new PrimaryAttributes(5,2,10,1);
        PrimaryAttributes actual = warrior.getBasePrimaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestCreateMage_ValidInput_ShouldHaveCorrectPrimaryAttributes() {
        Mage mage = new Mage("Max");
        PrimaryAttributes expected = new PrimaryAttributes(1,1,5,8);
        PrimaryAttributes actual = mage.getBasePrimaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestCreateRanger_ValidInput_ShouldHaveCorrectPrimaryAttributes() {
        Ranger ranger = new Ranger("Max");
        PrimaryAttributes expected = new PrimaryAttributes(1,7,8,1);
        PrimaryAttributes actual = ranger.getBasePrimaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestCreateRogue_ValidInput_ShouldHaveCorrectPrimaryAttributes() {
        Rogue rogue = new Rogue("Max");
        PrimaryAttributes expected = new PrimaryAttributes(2,6,8,1);
        PrimaryAttributes actual = rogue.getBasePrimaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelUpWarrior_ValidInput_ShouldHaveCorrectPrimaryAttributes() {
        Warrior warrior = new Warrior("Max");
        warrior.levelUp(1);
        PrimaryAttributes expected = new PrimaryAttributes(8,4,15,2);
        PrimaryAttributes actual = warrior.getBasePrimaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelUpMage_ValidInput_ShouldHaveCorrectPrimaryAttributes() {
        Mage mage = new Mage("Max");
        mage.levelUp(1);
        PrimaryAttributes expected = new PrimaryAttributes(2,2,8,13);
        PrimaryAttributes actual = mage.getBasePrimaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelUpRanger_ValidInput_ShouldHaveCorrectPrimaryAttributes() {
        Ranger ranger = new Ranger("Max");
        ranger.levelUp(1);
        PrimaryAttributes expected = new PrimaryAttributes(2,12,10,2);
        PrimaryAttributes actual = ranger.getBasePrimaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelUpRogue_ValidInput_ShouldHaveCorrectPrimaryAttributes() {
        Rogue rogue = new Rogue("Max");
        rogue.levelUp(1);
        PrimaryAttributes expected = new PrimaryAttributes(3,10,11,2);
        PrimaryAttributes actual = rogue.getBasePrimaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelUpWarrior_ValidInput_ShouldHaveCorrectSecondaryAttributes() {
        Warrior warrior = new Warrior("Max");
        warrior.levelUp(1);
        SecondaryAttributes expected = new SecondaryAttributes(150,12,2);
        SecondaryAttributes actual = warrior.getSecondaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelUpMage_ValidInput_ShouldHaveCorrectSecondaryAttributes() {
        Mage mage = new Mage("Max");
        mage.levelUp(1);
        SecondaryAttributes expected = new SecondaryAttributes(80,4,13);
        SecondaryAttributes actual = mage.getSecondaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelUpRanger_ValidInput_ShouldHaveCorrectSecondaryAttributes() {
        Ranger ranger = new Ranger("Max");
        ranger.levelUp(1);
        SecondaryAttributes expected = new SecondaryAttributes(100,14,2);
        SecondaryAttributes actual = ranger.getSecondaryAttributes();
        assertEquals(expected, actual);
    }

    @Test
    void TestLevelUpRogue_ValidInput_ShouldHaveCorrectSecondaryAttributes() {
        Rogue rogue = new Rogue("Max");
        rogue.levelUp(1);
        SecondaryAttributes expected = new SecondaryAttributes(110,13,2);
        SecondaryAttributes actual = rogue.getSecondaryAttributes();
        assertEquals(expected, actual);
    }
}