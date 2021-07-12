package characters;

import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;

public class Mage extends Character {
    public Mage(String name) {
        super(name, 1, 1, 5 ,8);
    }

    @Override
    public void levelUp() {
        PrimaryAttributes primary = getPrimaryAttributes();

        int strength = primary.getStrength();
        int dexterity = primary.getDexterity();
        int intelligence = primary.getIntelligence();
        int vitality = primary.getVitality();

        primary.setStrength(strength += 1);
        primary.setDexterity(dexterity += 1);
        primary.setIntelligence(intelligence += 5);
        primary.setVitality(vitality += 3);
    }
}
