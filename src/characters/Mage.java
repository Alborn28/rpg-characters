package characters;

public class Mage extends Hero {
    public Mage(String name) {
        super(name, 1, 1, 5 ,8);
    }

    @Override
    public void levelUp() {
        levelUpHero(1, 1, 3, 5);
    }
}
