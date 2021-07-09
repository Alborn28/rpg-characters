package characters;

import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;

public class Mage extends Character {
    private String name;
    private int level;
    private PrimaryAttributes primaryAttributes;
    private SecondaryAttributes secondaryAttributes;

    public Mage(String name) {
        this.name = name;
        this.level = 1;
        int strength = 1;
        int dexterity = 1;
        int vitality = 5;
        int intelligence = 8;
        this.primaryAttributes = new PrimaryAttributes(strength, dexterity, intelligence, vitality);

        int health = vitality * 10;
        int armorRating = strength + dexterity;
        int elementalResistance = intelligence;
        this.secondaryAttributes = new SecondaryAttributes(health, armorRating, elementalResistance);
    }

    @Override
    public void levelUp() {
        int strength = primaryAttributes.getStrength();
        int dexterity = primaryAttributes.getDexterity();
        int intelligence = primaryAttributes.getIntelligence();
        int vitality = primaryAttributes.getVitality();

        primaryAttributes.setStrength(strength += 1);
        primaryAttributes.setDexterity(dexterity += 1);
        primaryAttributes.setIntelligence(intelligence += 5);
        primaryAttributes.setVitality(vitality += 3);
    }

    @Override
    public String toString() {
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
