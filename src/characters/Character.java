package characters;

import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;

public abstract class Character {
    private String name;
    private int level;
    private PrimaryAttributes primaryAttributes;
    private SecondaryAttributes secondaryAttributes;

    public Character(String name, int strength, int dexterity, int vitality, int intelligence) {
        this.name = name;
        level = 1;

        this.primaryAttributes = new PrimaryAttributes(strength, dexterity, intelligence, vitality);

        int health = vitality * 10;
        int armorRating = strength + dexterity;
        int elementalResistance = intelligence;
        this.secondaryAttributes = new SecondaryAttributes(health, armorRating, elementalResistance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public abstract void levelUp();

    private void updateSecondaryAttributes() {
        int health = primaryAttributes.getVitality() * 10;
        int armorRating = primaryAttributes.getStrength() + primaryAttributes.getDexterity();
        int elementalResistance = primaryAttributes.getIntelligence();
        this.secondaryAttributes = new SecondaryAttributes(health, armorRating, elementalResistance);
    }

    public String toString() {
        updateSecondaryAttributes();

        StringBuilder result = new StringBuilder();

        result.append("Name: " + name + "\n");
        result.append("Level: " + level + "\n");
        result.append("Strength: " + primaryAttributes.getStrength() + "\n");
        result.append("Dexterity: " + primaryAttributes.getDexterity() + "\n");
        result.append("Intelligence: " + primaryAttributes.getIntelligence() + "\n");
        result.append("Vitality: " + primaryAttributes.getVitality() + "\n");
        result.append("Health: " + secondaryAttributes.getHealth() + "\n");
        result.append("Armor Rating: " + secondaryAttributes.getArmorRating() + "\n");
        result.append("Elemental Resistance: " + secondaryAttributes.getElementalResistance() + "\n");

        return result.toString();
    }
}