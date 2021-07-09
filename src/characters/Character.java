package characters;

import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;

public abstract class Character {
    private String name;
    private int level;
    private PrimaryAttributes primaryAttributes;
    private SecondaryAttributes secondaryAttributes;

    public Character(String name, int level, int strength, int dexterity, int intelligence, int vitality) {
        this.name = name;
        this.level = level;
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

    public abstract void levelUp();

    public abstract String toString();
}