public class Dice {

    private int dice1;
    private int dice2;

    public int rollDice() {

        dice1 = (int) (Math.random() * 6 + 1);
        dice2 = (int) (Math.random() * 6 + 1);

        return dice1 + dice2;
    }
    
    public boolean doubleRoll() {
        if (dice1 == dice2) {
            return true;
        } else {
            return false;
        }
    }
}
