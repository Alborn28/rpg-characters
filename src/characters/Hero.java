package characters;

import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;
import items.*;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

import java.util.HashMap;

public abstract class Hero {
    private String name;
    private int level;
    private PrimaryAttributes basePrimaryAttributes;
    private PrimaryAttributes totalPrimaryAttributes;
    private SecondaryAttributes secondaryAttributes;
    private HashMap<ItemSlot, Item> equipment;

    public Hero(String name, int strength, int dexterity, int vitality, int intelligence) {
        this.name = name;
        level = 1;

        this.basePrimaryAttributes = new PrimaryAttributes(strength, dexterity, vitality, intelligence);

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

    public PrimaryAttributes getBasePrimaryAttributes() {
        return basePrimaryAttributes;
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
        int currentStrength = basePrimaryAttributes.getStrength();
        int currentDexterity = basePrimaryAttributes.getDexterity();
        int currentIntelligence = basePrimaryAttributes.getIntelligence();
        int currentVitality = basePrimaryAttributes.getVitality();

        basePrimaryAttributes.setStrength(currentStrength += strength);
        basePrimaryAttributes.setDexterity(currentDexterity += dexterity);
        basePrimaryAttributes.setVitality(currentVitality += vitality);
        basePrimaryAttributes.setIntelligence(currentIntelligence += intelligence);

        level++;
    }

    public abstract void equip(Weapon weapon) throws InvalidWeaponException;

    public abstract void equip(Armor armor) throws InvalidArmorException;

    protected void equipHero(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getRequiredLevel() <= this.getLevel()) {
            if(weapon.getSlot() == ItemSlot.WEAPON) {
                HashMap<ItemSlot, Item> equipment = this.getEquipment();
                equipment.put(weapon.getSlot(), weapon);
            }

            else {
                throw new InvalidWeaponException("You can't equip a weapon in the " + weapon.getSlot().name() + " slot!");
            }
        }

        else {
            throw new InvalidWeaponException("Your character's level is not high enough to equip that weapon!");
        }
    }

    protected void equipHero(Armor armor) throws InvalidArmorException {
        if(armor.getRequiredLevel() <= this.getLevel()) {
            if(armor.getSlot() != ItemSlot.WEAPON) {
                HashMap<ItemSlot, Item> equipment = this.getEquipment();
                equipment.put(armor.getSlot(), armor);
            }

            else {
                throw new InvalidArmorException("You can't equip armor in the WEAPON slot!");
            }
        }

        else {
            throw new InvalidArmorException("Your character's level is not high enough to equip that piece of armor!");
        }
    }

    private void updateSecondaryAttributes() {
        int health = basePrimaryAttributes.getVitality() * 10;
        int armorRating = basePrimaryAttributes.getStrength() + basePrimaryAttributes.getDexterity();
        int elementalResistance = basePrimaryAttributes.getIntelligence();
        this.secondaryAttributes = new SecondaryAttributes(health, armorRating, elementalResistance);
    }

    public String toString() {
        this.updateSecondaryAttributes();

        StringBuilder result = new StringBuilder();

        result.append("Name: " + this.getName() + "\n");
        result.append("Level: " + this.getLevel() + "\n");
        result.append("Strength: " + basePrimaryAttributes.getStrength() + "\n");
        result.append("Dexterity: " + basePrimaryAttributes.getDexterity() + "\n");
        result.append("Intelligence: " + basePrimaryAttributes.getIntelligence() + "\n");
        result.append("Vitality: " + basePrimaryAttributes.getVitality() + "\n");
        result.append("Health: " + secondaryAttributes.getHealth() + "\n");
        result.append("Armor Rating: " + secondaryAttributes.getArmorRating() + "\n");
        result.append("Elemental Resistance: " + secondaryAttributes.getElementalResistance() + "\n");

        return result.toString();
    }
}