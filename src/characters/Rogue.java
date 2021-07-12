package characters;

public class Rogue extends Hero {
    public Rogue(String name) {
        super(name, 2, 6, 8 ,1);
    }

    @Override
    public void levelUp() {
        levelUpHero(1, 4, 3, 1);
    }
}
