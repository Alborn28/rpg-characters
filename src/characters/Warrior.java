package characters;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, 5, 2, 10 ,1);
    }

    @Override
    public void levelUp() {
        levelUpChar(3, 2, 5, 1);
    }
}
