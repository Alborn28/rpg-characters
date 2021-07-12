package characters;

public class Mage extends Character {
    public Mage(String name) {
        super(name, 1, 1, 5 ,8);
    }

    @Override
    public void levelUp() {
        levelUpChar(1, 1, 3, 5);
    }
}
