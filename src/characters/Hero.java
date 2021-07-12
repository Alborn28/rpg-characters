package characters;

import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;
import items.Armor;
import items.Item;
import items.ItemSlot;
import items.Weapon;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

import java.util.HashMap;

public abstract class Hero {
    private String name;
    private int level;
    private PrimaryAttributes primaryAttributes;
    private SecondaryAttributes secondaryAttributes;
    private HashMap<ItemSlot, Item> equipment;

    public Hero(String name, int strength, int dexterity, int vitality, int intelligence) {
        this.name = name;
        level = 1;

        this.primaryAttributes = new PrimaryAttributes(strength, dexterity, vitality, intelligence);

        int health = vitality * 10;
        int armorRating = strength + dexterity;
        int elementalResistance = intelligence;
        this.secondaryAttributes = new SecondaryAttributes(health, armorRating, elementalResistance);

        equipment = new HashMap<ItemSlot, Item>();
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

    public HashMap<ItemSlot, Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(HashMap<ItemSlot, Item> equipment) {
        this.equipment = equipment;
    }

    public Item getEquipmentHead() {
        return equipment.get(ItemSlot.HEAD);
    }

    public abstract void levelUp();

    protected void levelUpHero(int strength, int dexterity, int vitality, int intelligence) {
        int currentStrength = primaryAttributes.getStrength();
        int currentDexterity = primaryAttributes.getDexterity();
        int currentIntelligence = primaryAttributes.getIntelligence();
        int currentVitality = primaryAttributes.getVitality();

        primaryAttributes.setStrength(currentStrength += strength);
        primaryAttributes.setDexterity(currentDexterity += dexterity);
        primaryAttributes.setVitality(currentVitality += vitality);
        primaryAttributes.setIntelligence(currentIntelligence += intelligence);

        level++;
    }

    private void updateSecondaryAttributes() {
        int health = primaryAttributes.getVitality() * 10;
        int armorRating = primaryAttributes.getStrength() + primaryAttributes.getDexterity();
        int elementalResistance = primaryAttributes.getIntelligence();
        this.secondaryAttributes = new SecondaryAttributes(health, armorRating, elementalResistance);
    }

    public abstract void equip(Weapon weapon) throws InvalidWeaponException;

    public abstract void equip(Armor armor) throws InvalidArmorException;

    protected void equipHero(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getRequiredLevel() <= this.getLevel()) {
            HashMap<ItemSlot, Item> equipment = this.getEquipment();
            equipment.put(weapon.getSlot(), weapon);
        }

        else {
            throw new InvalidWeaponException("Your character's level is not high enough to equip that weapon!");
        }
    }

    protected void equipHero(Armor armor) throws InvalidArmorException {
        if(armor.getRequiredLevel() <= this.getLevel()) {
            HashMap<ItemSlot, Item> equipment = this.getEquipment();
            equipment.put(armor.getSlot(), armor);
        }

        else {
            throw new InvalidArmorException("Your character's level is not high enough to equip that piece of armor!");
        }
    }

    public String toString() {
        this.updateSecondaryAttributes();

        StringBuilder result = new StringBuilder();

        result.append("Name: " + this.getName() + "\n");
        result.append("Level: " + this.getLevel() + "\n");
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