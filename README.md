# RPG Characters

## Task

The task was to create a Java console application that creates RPG characters. There are four different types of characters: Mage, Ranger, Rogue and Warrior. Each Character has the following primary stats: Strength, Dexterity, Vitality and Intelligence. There are also secondary stats which are calculated based on the primary stats, they are: Health, Armor Rating and Elemental Resistance. A Character is able to level up, which increases their stats, as well as equip armor and weapons. Equipping armor gives bonuses to the hero's stats. There is also a Battle-class where you can simulate fights between characters.

## Project Structure

The project contains four packages. In the characters-package, all logic concerning characters are located. There is one abstract class called Character, which details the properties and behaviours of a generic Character, and four classes with specific implementations of different character classes. The attributes-package contains two classes, PrimaryAttributes and SecondaryAttributes, which are used to store the attributes of a Character. The items-package contains logic concerning Weapons and Armor. The battle-package contains classes concerning the simulation of a battle between two Characters. 

## Tests

In the /test folder there are two test-classes testing the functionality of the application. /test/CharacterTest tests the functionality of Characters, such as checking so the primary and secondary stats increase correctly when levelling up. /test/ItemTest tests the functionality of Items, for example that characters can only equip items that are valid for their class and that a character's attributes are updated correctly when equipping armor.
