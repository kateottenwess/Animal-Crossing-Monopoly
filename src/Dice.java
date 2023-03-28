/**********************************************************************.
 * Class stores the dice functionailty for the game
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Dice {

    private int numDouble = 0;

    
    /*******************************************************************
     * Method to roll dice 1
     * @return int
     ******************************************************************/
    public int rollDice() {

        return ((int) (Math.random() * 6 + 1));
        
    }

    

    /*******************************************************************
     * Method to determine if a double was rolled
     * @return boolean true if double was rolled
     ******************************************************************/
    public boolean doubleRoll(int dice1, int dice2) {
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
        return numDouble == 3;
    }
}
