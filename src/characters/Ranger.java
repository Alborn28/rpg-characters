package characters;

public class Ranger extends Hero {
    public Ranger(String name) {
        super(name, 1, 7, 8 ,1);
    }

    @Override
    public void levelUp() {
        levelUpHero(1, 5, 2, 1);
    }
}
