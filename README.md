# Assignment 1

## Task

The task of assignment 1 is to create a Java console application that creates RPG characters. There are four different types of characters: Mage, Ranger, Rogue and Warrior. Each Character has the following primary stats: Strength, Dexterity, Vitality and Intelligence. There are also secondary stats which are calculated based on the primary stats, they are: Health, Armor Rating and Elemental Resistance. A Character is able to level up, which increases their stats, as well as equip armor and weapons. Equipping armor gives bonuses to the hero's stats. There is also a Battle-class where you can simulate fights between characters.

## Tests

In the /test folder there are two test-classes testing the functionality of the application. /test/CharacterTest tests the functionality of Characters, such as checking so the primary and secondary stats increase correctly when levelling up. /test/ItemTest tests the functionality of Items, for example that characters can only equip items that are valid for their class and that a character's attributes are updated correctly when equipping armor.
