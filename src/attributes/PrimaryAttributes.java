package attributes;

public class PrimaryAttributes {
    private int strength;
    private int dexterity;
    private int vitality;
    private int intelligence;

    public PrimaryAttributes(int strength, int dexterity, int vitality, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.vitality = vitality;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Strength: " + this.getStrength() + "\n");
        result.append("Dexterity: " + this.getDexterity() + "\n");
        result.append("Vitality: " + this.getVitality() + "\n");
        result.append("Intelligence: " + this.getIntelligence());

        return result.toString();
    }

    /*
     *  Method used to compare PrimaryAttribute-objects and check if they are equal. Used in the unit tests.
     *  If both objects are PrimaryAttributes-objects and all properties are equal, the objects are considered equal.
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof PrimaryAttributes) {
            PrimaryAttributes attributes = (PrimaryAttributes) o;

            if((this.getStrength() == attributes.getStrength()) && (this.getDexterity() == attributes.getDexterity()) && (this.getVitality() == attributes.getVitality()) && (this.getIntelligence() == attributes.getIntelligence())) {
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
