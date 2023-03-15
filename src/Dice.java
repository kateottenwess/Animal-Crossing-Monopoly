public class Dice {

    private static int dice1;
    private static int dice2;
    private static int numDouble = 0;

    public static int rollDice() {

        dice1 = (int) (Math.random() * 6 + 1);
        dice2 = (int) (Math.random() * 6 + 1);

        return dice1 + dice2;
    }
    
    public boolean doubleRoll() {
        if (dice1 == dice2) {
            numDouble++;
            return true;
        } else {
            numDouble = 0;
            return false;
        }
    }

    public boolean doubleJail() {
        if (numDouble == 3) {
            return true;
        } else {
            return false;
        }
    }
}
