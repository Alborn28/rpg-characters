package items;

import attributes.PrimaryAttributes;

public class Armor extends Item {
    ArmorType armorType;
    PrimaryAttributes primaryAttributes;

    public Armor(String name, int requiredLevel, ItemSlot slot, ArmorType armorType, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.primaryAttributes = primaryAttributes;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }
}
