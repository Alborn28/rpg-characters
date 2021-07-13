package items;

import items.enumerations.ItemSlot;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private ItemSlot slot;

    public Item(String name, int requiredLevel, ItemSlot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public ItemSlot getSlot() {
        return slot;
    }

    public void setSlot(ItemSlot slot) {
        this.slot = slot;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Name: " + getName() + "\n");
        result.append("Required level: " + getRequiredLevel() + "\n");
        result.append("Slot: " + getSlot().name() + "\n");

        return result.toString();
    }
}
