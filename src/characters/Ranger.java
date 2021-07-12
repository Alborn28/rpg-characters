package characters;

public class Ranger extends Character {
    public Ranger(String name) {
        super(name, 1, 7, 8 ,1);
    }

    @Override
    public void levelUp() {
        levelUpChar(1, 5, 2, 1);
    }
}
