import characters.Mage;

public class Program {
    public static void main(String[] args) {
        Mage mage = new Mage("Max");

        System.out.println(mage.toString());

        mage.levelUp();

        System.out.println(mage.toString());
    }
}
