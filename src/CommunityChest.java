/**********************************************************************
 * Class stores mcommunity chest cards for the game
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class CommunityChest extends MiscSpaces {

    /* String array that holds all of the community chest cards */
    String[] ccCards = {"GRAND MUSEUM OPENING: COLLECT 50 BELLS","YOU DUG UP A SACK OF BELLS! COLLECT 100 BELLS","GO TO JAIL \n DO NOT PASS GO, DO NOT COLLECT 200 BELLS","GET OUT OF JAIL, FREE!","ADVANCE TO GO: COLLECT 200 BELLS",
    "RECEIVE 25 BELLS FOR YOUR SERVICES TO THE VILLAGE","INCOME TAX REFUND: COLLECT 20 BELLS","YOU INHERITED 100 BELLS","PAY VILLAGE TAX OF 150 BELLS","BANK ERROR IN YOUR FAVOR: COLLECT 200 BELLS"};

    //cCards[0] = "GRAND MUSEUM OPENING: COLLECT 50 BELLS";
    //ccCards[1] = "YOU DO UP A SACK OF BELLS! COLLECT 100 BELLS";
    //ccCards[2] = "GO TO JAIL \n DO NOT PASS GO, DO NOT COLLECT 200 BELLS";
    //ccCards[3] = "GET OUT OF JAIL, FREE!";
    //ccCards[4] = "ADVANCE TO GO: COLLECT 200 BELLS";
    //ccCards[5] = "RECEIVE 25 BELLS FOR YOUR SERVICES TO THE VILLAGE";
    //ccCards[6] = "INCOME TAX REFUND: COLLECT 20 BELLS";
   //ccCards[7] = "YOU INHERITED 100 BELLS";
    //ccCards[8] = "PAY VILLAGE TAX OF 150 BELLS";
    //ccCards[9] = "BANK ERROR IN YOUR FAVOR: COLLECT 200 BELLS";
    //possible community chest cards- should probably make like 10


     /***************************************************************** 
     * Method to return a random community chest card
     * 
     * @return String chance card
     ******************************************************************/
    public String pickCCCard(){
        int randInt = (int) (Math.random() * 9);
        return ccCards[randInt];
/* 
        if (ccCards[randInt] == ccCards[0]){
            //int bells = Player.getBells();
            //Player.setBells(Player.getBells() + 50);
        }
        if (ccCards[randInt] == ccCards[1]){
            //int bells = Player.getBells();
            //Player.setBells(Player.getBells() + 100);
        }
        if (ccCards[randInt] == ccCards[2]){
            //go to jail
        }
        if (ccCards[randInt] == ccCards[3]){
            //get out of jail
        }
        if (ccCards[randInt] == ccCards[4]){
            //int bells = Player.getBells();
            //Player.setBells(Player.getBells() + 200);
            //Player.setBoardPos(0);
        }
        if (ccCards[randInt] == ccCards[5]){
            //int bells = Player.getBells();
            //Player.setBells(Player.getBells() + 25);
        }
        if (ccCards[randInt] == ccCards[6]){
            //int bells = Player.getBells();
            //Player.setBells(Player.getBells() + 20);
        }
        if (ccCards[randInt] == ccCards[7]){
            //int bells = Player.getBells();
            //Player.setBells(Player.getBells() + 100);
        }
        if (ccCards[randInt] == ccCards[8]){
            //int bells = Player.getBells();
            //Player.setBells(Player.getBells() + 150);
        }
        if (ccCards[randInt] == ccCards[1]){
            //int bells = Player.getBells();
            //Player.setBells(Player.getBells() + 200);
        }*/
    }
}
