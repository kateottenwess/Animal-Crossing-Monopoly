/**********************************************************************
 * Class stores the dice functionailty for the game
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Dice {

    private int dice1;
    private int dice2;
    private int numDouble = 0;

    
    /*******************************************************************
     * Method to roll dice 1
     * @return int
     ******************************************************************/
    public int rollDice1() {

        dice1 = (int) (Math.random() * 6 + 1);
        
        return dice1;
    }


    /*******************************************************************
     * Method to roll dice 2
     * @return int
     ******************************************************************/
    public int rollDice2() {

        dice2 = (int) (Math.random() * 6 + 1);

        return dice2;
    }
    

    /*******************************************************************
     * Method to determine if a double was rolled
     * @return boolean true if double was rolled
     ******************************************************************/
    public boolean doubleRoll() {
        if (dice1 == dice2) {
            numDouble++;
            return true;
        } else {
            numDouble = 0;
            return false;
        }
    }


    /*******************************************************************
     * Method to determine if three doubles were rolled
     * @return boolean true if 3 doubles were rolled
     ******************************************************************/
    public boolean doubleJail() {
        if (numDouble == 3) {
            return true;
        } else {
            return false;
        }
    }
}
