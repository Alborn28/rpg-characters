package attributes;

public class SecondaryAttributes {
    private int health;
    private int armorRating;
    private int elementalResistance;

    public SecondaryAttributes(int health, int armorRating, int elementalResistance) {
        this.health = health;
        this.armorRating = armorRating;
        this.elementalResistance = elementalResistance;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    public int getElementalResistance() {
        return elementalResistance;
    }

    public void setElementalResistance(int elementalResistance) {
        this.elementalResistance = elementalResistance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Health: " + this.getHealth() + "\n");
        result.append("Armor rating: " + this.getArmorRating() + "\n");
        result.append("Elemental resistance: " + this.getElementalResistance());

        return result.toString();
    }

    /*
     *  Method used to compare SecondaryAttributes-objects and check if they are equal. Used in the unit tests.
     *  If both objects are SecondaryAttributes-objects and all properties are equal, the objects are considered equal.
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof SecondaryAttributes) {
            SecondaryAttributes attributes = (SecondaryAttributes) o;

            if(this.getHealth() == attributes.getHealth() && this.getArmorRating() == attributes.getArmorRating() && this.getElementalResistance() == attributes.getElementalResistance()) {
                return true;
            }

            else {
                return false;
            }
        }

        else {
            return false;
        }
    }
}
