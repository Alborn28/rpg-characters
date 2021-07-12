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
        this.totalPrimaryAttributes = new PrimaryAttributes(strength, dexterity, vitality, intelligence);

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

    public PrimaryAttributes getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }

    public abstract void levelUp(int level);

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

        this.updateSecondaryAttributes();
        this.updateTotalAttributes();
    }

    public abstract boolean equip(Weapon weapon) throws InvalidWeaponException;

    public abstract boolean equip(Armor armor) throws InvalidArmorException;

    protected boolean equipHero(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getRequiredLevel() <= this.getLevel()) {
            if(weapon.getSlot() == ItemSlot.WEAPON) {
                HashMap<ItemSlot, Item> equipment = this.getEquipment();
                equipment.put(weapon.getSlot(), weapon);

                this.updateSecondaryAttributes();
                this.updateTotalAttributes();

                return true;
            }

            else {
                throw new InvalidWeaponException("You can't equip a weapon in the " + weapon.getSlot().name() + " slot!");
            }
        }

        else {
            throw new InvalidWeaponException("Your character's level is not high enough to equip that weapon!");
        }
    }

    protected boolean equipHero(Armor armor) throws InvalidArmorException {
        if(armor.getRequiredLevel() <= this.getLevel()) {
            if(armor.getSlot() != ItemSlot.WEAPON) {
                HashMap<ItemSlot, Item> equipment = this.getEquipment();
                equipment.put(armor.getSlot(), armor);

                this.updateSecondaryAttributes();
                this.updateTotalAttributes();

                return true;
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
        int health = totalPrimaryAttributes.getVitality() * 10;
        int armorRating = totalPrimaryAttributes.getStrength() + totalPrimaryAttributes.getDexterity();
        int elementalResistance = totalPrimaryAttributes.getIntelligence();
        this.secondaryAttributes = new SecondaryAttributes(health, armorRating, elementalResistance);
    }

    private void updateTotalAttributes() {
        int strength = basePrimaryAttributes.getStrength();
        int dexterity = basePrimaryAttributes.getDexterity();
        int intelligence = basePrimaryAttributes.getIntelligence();
        int vitality = basePrimaryAttributes.getVitality();

        for(Item item : equipment.values()) {
            if(item instanceof items.Armor) {
                Armor armor = (Armor) item;
                strength += armor.getPrimaryAttributes().getStrength();
                dexterity += armor.getPrimaryAttributes().getDexterity();
                intelligence += armor.getPrimaryAttributes().getIntelligence();
                vitality += armor.getPrimaryAttributes().getVitality();
            }
        }

        totalPrimaryAttributes.setStrength(strength);
        totalPrimaryAttributes.setDexterity(dexterity);
        totalPrimaryAttributes.setIntelligence(intelligence);
        totalPrimaryAttributes.setVitality(vitality);
    }

    public String toString() {
        this.updateSecondaryAttributes();
        this.updateTotalAttributes();

        StringBuilder result = new StringBuilder();

        result.append("Name: " + this.getName() + "\n");
        result.append("Level: " + this.getLevel() + "\n");
        result.append("Strength: " + totalPrimaryAttributes.getStrength() + "\n");
        result.append("Dexterity: " + totalPrimaryAttributes.getDexterity() + "\n");
        result.append("Intelligence: " + totalPrimaryAttributes.getIntelligence() + "\n");
        result.append("Vitality: " + totalPrimaryAttributes.getVitality() + "\n");
        result.append("Health: " + secondaryAttributes.getHealth() + "\n");
        result.append("Armor Rating: " + secondaryAttributes.getArmorRating() + "\n");
        result.append("Elemental Resistance: " + secondaryAttributes.getElementalResistance() + "\n");

        return result.toString();
    }
}