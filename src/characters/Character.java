package characters;

import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;
import items.*;
import items.enumerations.ItemSlot;
import items.exceptions.InvalidArmorException;
import items.exceptions.InvalidWeaponException;

import java.util.HashMap;

public abstract class Character {
    private String name;
    private int level;
    private PrimaryAttributes basePrimaryAttributes;
    private PrimaryAttributes totalPrimaryAttributes;
    private SecondaryAttributes secondaryAttributes;
    private HashMap<ItemSlot, Item> equipment;

    public Character(String name, int strength, int dexterity, int vitality, int intelligence) {
        if(name == null) {
            throw new IllegalArgumentException("Name can't be null!");
        }

        this.name = name;
        this.level = 1;

        //Initiate the attributes with the parameters received from the constructor
        this.basePrimaryAttributes = new PrimaryAttributes(strength, dexterity, vitality, intelligence);
        this.totalPrimaryAttributes = new PrimaryAttributes(strength, dexterity, vitality, intelligence);

        //Calculate and initiate the secondary attributes based on the parameters
        int health = vitality * 10;
        int armorRating = strength + dexterity;
        int elementalResistance = intelligence;
        this.secondaryAttributes = new SecondaryAttributes(health, armorRating, elementalResistance);

        this.equipment = new HashMap<ItemSlot, Item>();
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

    public PrimaryAttributes getBasePrimaryAttributes() {
        return basePrimaryAttributes;
    }

    public PrimaryAttributes getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        this.updateSecondaryAttributes();
        return secondaryAttributes;
    }

    public HashMap<ItemSlot, Item> getEquipment() {
        return equipment;
    }

    public abstract void levelUp(int levels);

    /*
     * Help-method used for levelling up the character, used by the sub-class.
     * The sub-class inputs how much the level should be increased, and how much each attribute should increase.
     */
    protected void levelUpCharacter(int levels, int strength, int dexterity, int vitality, int intelligence) {
        int currentStrength = basePrimaryAttributes.getStrength();
        int currentDexterity = basePrimaryAttributes.getDexterity();
        int currentIntelligence = basePrimaryAttributes.getIntelligence();
        int currentVitality = basePrimaryAttributes.getVitality();

        basePrimaryAttributes.setStrength(currentStrength += strength);
        basePrimaryAttributes.setDexterity(currentDexterity += dexterity);
        basePrimaryAttributes.setVitality(currentVitality += vitality);
        basePrimaryAttributes.setIntelligence(currentIntelligence += intelligence);

        this.level += levels;

        this.updateTotalAttributes();
    }

    /*
     * Method to equip a weapon. First it checks if the character's level is high enough for the weapon, then if the weapon has the correct ItemSlot.
     * If both those requirements are fulfilled, the weapon is equipped.
     */
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if(weapon.getRequiredLevel() <= this.getLevel()) {
            if(weapon.getSlot() == ItemSlot.WEAPON) {
                this.equipment.put(weapon.getSlot(), weapon);

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

    /*
     * Method to equip armor. First it checks if the character's level is high enough for the armor, then if the armor has a valid ItemSlot.
     * If both those requirements are fulfilled, the armor is equipped and the total attributes are updated with the new armor.
     */
    public boolean equip(Armor armor) throws InvalidArmorException {
        if(armor.getRequiredLevel() <= this.getLevel()) {
            if(armor.getSlot() != ItemSlot.WEAPON) {
                this.equipment.put(armor.getSlot(), armor);

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

    public abstract double getDPS();

    /*
     * Help-method used for calculating the DPS, used by the sub-class.
     * The sub-class inputs the value of their primary attribute. Strength for warrior, intelligence for mage etc.
     */
    protected double getDPSCharacter(int primaryAttribute) {
        if(this.getEquipment().get(ItemSlot.WEAPON) != null) {
            Weapon weapon = (Weapon) this.getEquipment().get(ItemSlot.WEAPON);
            double weaponDPS = weapon.getDPS();
            double result = weaponDPS * (1 + ((double) primaryAttribute / 100));
            result = (double) Math.round(result * 100) / 100;
            return result;
        }

        double result = 1 * (1 + ((double) primaryAttribute / 100));
        result = (double) Math.round(result * 100) / 100;
        return result;
    }

    private void updateSecondaryAttributes() {
        int health = totalPrimaryAttributes.getVitality() * 10;
        int armorRating = totalPrimaryAttributes.getStrength() + totalPrimaryAttributes.getDexterity();
        int elementalResistance = totalPrimaryAttributes.getIntelligence();

        this.secondaryAttributes.setHealth(health);
        this.secondaryAttributes.setArmorRating(armorRating);
        this.secondaryAttributes.setElementalResistance(elementalResistance);
    }

    /*
     * Method to calculate and update total attributes. It adds the base attributes + the bonus attributes from all equipped armor.
     */
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

        this.totalPrimaryAttributes.setStrength(strength);
        this.totalPrimaryAttributes.setDexterity(dexterity);
        this.totalPrimaryAttributes.setIntelligence(intelligence);
        this.totalPrimaryAttributes.setIntelligence(vitality);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Name: " + this.getName() + "\n");
        result.append("Level: " + this.getLevel() + "\n");
        result.append("Strength: " + this.totalPrimaryAttributes.getStrength() + "\n");
        result.append("Dexterity: " + this.totalPrimaryAttributes.getDexterity() + "\n");
        result.append("Vitality: " + this.totalPrimaryAttributes.getVitality() + "\n");
        result.append("Intelligence: " + this.totalPrimaryAttributes.getIntelligence() + "\n");
        result.append("Health: " + this.secondaryAttributes.getHealth() + "\n");
        result.append("Armor rating: " + this.secondaryAttributes.getArmorRating() + "\n");
        result.append("Elemental resistance: " + this.secondaryAttributes.getElementalResistance() + "\n");
        result.append("DPS: " + this.getDPS());

        return result.toString();
    }
}