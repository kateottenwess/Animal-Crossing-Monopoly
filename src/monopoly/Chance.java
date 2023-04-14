package monopoly;
/**********************************************************************
 * Class stores chance cards for the game
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Chance extends MiscSpaces {

    /* String array that holds all of the chance cards */
    String[] chanceCards = {"GO BACK THREE SPACES","ADVANCE TO GO (COLLECT 200 BELLS)","BANK PAYS YOU DIVIDEND OF 50 BELLS","ADVANCE TO FRANCINE'S HOUSE","GET OUT OF JAIL FREE",
    "ADVANCE TO RAYMOND'S HOUSE","PAY POOR TAX OF 15 BELLS","GO TO JAIL","ADVANCE TOKEN TO CHRISSY'S HOUSE","YOUR BUSINESS MATURES: COLLECT 150 BELLS"};


    /****************************************************************** 
     * Method to return a random chance card
     * 
     * @return String chance card
     ******************************************************************/
    public String pickChanceCards(){
        int randInt = (int) (Math.random() * 9);
        return chanceCards[randInt];

        /* 
        if (chanceCards[randInt] == chanceCards[0]){
            int current = Player.getBoardPos();
            Player.setBoardPos(current - 3);
        }
        if (chanceCards[randInt] == chanceCards[1]){
            Player.setBoardPos(0);
            Player.setBells(Player.getBells() + 200);
        }
        if(chanceCards[randInt] == chanceCards[2]){
            Player.setBells(Player.getBells() + 50);
        }
        if(chanceCards[randInt] == chanceCards[3]){
            Player.setBoardPos(34);
        }
        if(chanceCards[randInt] == chanceCards[4]){
            //get out of jail
        }
        if(chanceCards[randInt] == chanceCards[5]){
            Player.setBoardPos(34);
        }
        if(chanceCards[randInt] == chanceCards[6]){
            Player.setBells(Player.getBells() - 15);
        }
        if(chanceCards[randInt] == chanceCards[7]){
            //Go to jail
        }
        if(chanceCards[randInt] == chanceCards[8]){
            Player.setBoardPos(11);
        }
        if(chanceCards[randInt] == chanceCards[9]){
            Player.setBells(Player.getBells() + 150);
        }
        */
    }
    //possible chance cards- should probably make like 1 or something
}
