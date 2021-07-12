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
        result.append("Intelligence: " + this.getIntelligence() + "\n");

        return result.toString();
    }
}
