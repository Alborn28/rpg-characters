package battle;

import characters.Character;
public interface BattleView {
    public void showResult(Character winner, Character loser);
    public void showResult(Character winner, Character loser, int seconds);
    public void showStatus(Character fighter1, Character fighter2, int health1, int health2);
}
