/**********************************************************************
 * Class contains player information and actions
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Player {
    private static String name;
    private int playerNum;
    private static int boardPos;
    private static int bells;
    
    //indices are the space identifiers, the value in the array will be either 0 (false-not owned) or 1 (true-owned)
    private int[] properties;


    /*******************************************************************
    * Constructor that initializes the players name, money amount, and 
    * board position
    ******************************************************************/
    public Player(int playerNum, String name) {
        this.playerNum = playerNum;
        this.name = name;
        this.bells = 1500;
        this.boardPos = 0;
    }
    
    
    /******************************************************************
     * Getter to return player name
     * @return String
     ******************************************************************/
    public String getName() {
        return name;
    }


    /******************************************************************
     * Setter to set player name
     * @param name String
     ******************************************************************/
    public void setName(final String name) {
        this.name = name;
    }


    /******************************************************************
     * Getter to return players board position
     * @return int
     ******************************************************************/
    public int getBoardPos() {
        return boardPos;
    }


    /******************************************************************
     * Setter to set player board position
     * @param boardPos int
     ******************************************************************/
    public void setBoardPos(final int boardPos) {
        this.boardPos = boardPos;
    }


    /******************************************************************
     * Getter to return player bells
     * @return int
     ******************************************************************/
    public int getBells() {
        return bells;
    }


    /******************************************************************
     * Setter to set player bells amount
     * @param bells int
     ******************************************************************/
    public void setBells(final int bells) {
        this.bells = bells;
    }


    /******************************************************************
     * Method to return if a player has a certain property
     * @param player player
     * @param property Property
     * @return int
     ******************************************************************/
    public int hasProperty(final Player player, final Property property) {
        //wip
        return 1;
    }

    public void move(int dice1, int dice2, int newPosition) {
        int totalmove = dice1 + dice2;
        this.setBoardPos(newPosition);
    
        if (totalmove + this.getBoardPos() >= 40) {
            int greater40 = totalmove + this.getBoardPos();
            int afterGo = greater40 - 40;
            this.setBoardPos(afterGo - 1);
            int currentBells = this.getBells();
            this.setBells(currentBells + 200);
        } else {
            this.setBoardPos(this.getBoardPos() + totalmove);
        }
    }
    

    // public void buyProperty(int spaceIdentifier) {
        
    // }

    // public void mortageProperty(int spaceIdentifier) {}

    // public int rollDice() {

    // }

}
