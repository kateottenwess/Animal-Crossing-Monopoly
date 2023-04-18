/**********************************************************************.
 * Class stores the dice functionailty for the game
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Dice {

    /* int values that keeps track of how many doubles are rolled in a row */
    private int numDouble = 0;

    /* int of how many values are on dice */
    static final int VALUES_ON_DICE = 6;

    /* Value of how many doubles need to be rolled in a row in order to be sent to jail */
    static final int NUM_DOUBLES_TO_JAIL = 3;

    
    /*******************************************************************
     * Method to roll dice 1
     * @return int
     ******************************************************************/
    public int rollDice() {

        return ((int) (Math.random() * VALUES_ON_DICE + 1));
        
    }


    /*******************************************************************
     * Method to determine if a double was rolled
     * @return boolean true if double was rolled
     ******************************************************************/
    public boolean doubleRoll(int dice1, int dice2) {

        //if dice values are the same
        if (dice1 == dice2) {

            //increase number of doubles rolled in a row
            numDouble++;

            //return true as doubles were rolled
            return true;
        } 
        
        //if dice values are not the same
        else {

            //reset number of doubles rolled in a row to 0
            numDouble = 0;

            //returns false as a double was not rolled
            return false;
        }
    }


    /*******************************************************************
     * Method to determine if three doubles were rolled
     * @return boolean true if 3 doubles were rolled
     ******************************************************************/
    public boolean doubleJail() {
        return numDouble == NUM_DOUBLES_TO_JAIL;
    }
}
