/**********************************************************************
 * Class contains player information and actions
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Player {
    private String name;
    private int playerNum;
    private int boardPos;
    private int bells;
    // used for property-releated functions
    private Property p;

    // indices are the space identifiers, the value in the array will be either 0
    // (false-not owned) or the playernum of who owns it
    private static int[] properties;

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
     * 
     * @return String
     ******************************************************************/
    public String getName() {
        return name;
    }

    /******************************************************************
     * Setter to set player name
     * 
     * @param name String
     ******************************************************************/
    public void setName(final String name) {
        this.name = name;
    }

    /******************************************************************
     * Getter to return players board position
     * 
     * @return int
     ******************************************************************/
    public int getBoardPos() {
        return boardPos;
    }

    /******************************************************************
     * Setter to set player board position
     * 
     * @param boardPos int
     ******************************************************************/
    public void setBoardPos(final int boardPos) {
        this.boardPos = boardPos;
    }

    /******************************************************************
     * Getter to return player bells
     * 
     * @return int
     ******************************************************************/
    public int getBells() {
        return bells;
    }

    /******************************************************************
     * Setter to set player bells amount
     * 
     * @param bells int
     ******************************************************************/
    public void setBells(final int bells) {
        this.bells = bells;
    }

    /******************************************************************
     * Method to return if a player has a certain property
     * 
     * @param player   player
     * @param property Property
     * @return int
     ******************************************************************/
    public int hasProperty(final Player player, final Property property) {
        // wip
        return 1;
    }

    /******************************************************************
     * Method to move a player
     * 
     * @param dice1 dice 1 value
     * @param dice2 dice 2 value
     ******************************************************************/
    public void move(int dice1, int dice2) {
        int totalmove = dice1 + dice2;

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

    /******************************************************************
     * Method to purchase a property
     * 
     * @param spaceIdentifier int space of property on board
     * @throws Exception
     * 
     ******************************************************************/
    public void buyProperty(int spaceIdentifier) throws Exception {

        if (properties[spaceIdentifier] == 0) {
            // subtract bells
            this.setBells(this.bells - p.getProperty(spaceIdentifier).getPurchaseCost());

            // update properties owned array
            properties[spaceIdentifier] = playerNum;

            // set property to owned
            p.getProperty(spaceIdentifier).setOwned(true, this.playerNum);
        } else {
            throw new Exception("ALREADY OWNED");
        }
    }


    public void buyHouse(int spaceIdentifier, int numHouses) throws Exception {

        // if the number of houses on a property doesnt exceed 4
        if (p.getProperty(spaceIdentifier).getNumHouses() + numHouses <= 4) {
            // if player can afford to get properties
            if (this.bells - p.getProperty(spaceIdentifier).getOneHouse() * numHouses >= 0) {
                // if player owns all of the properties of the same color
                if (p.allOwned(p.getProperty(spaceIdentifier).getColor()) == this.playerNum) {

                    // increase number of houses on property
                    p.getProperty(spaceIdentifier).increaseNumHouses(numHouses);

                    // subtract bells from player
                    this.bells -= p.getProperty(spaceIdentifier).getOneHouse() * numHouses;

                    // increase property rent
                    p.getProperty(spaceIdentifier).increaseRent(p.getProperty(spaceIdentifier).getNumHouses());
                } 
                else {
                    throw new Exception("ALL COLORS NOT OWNED");
                }
            } else {
                throw new Exception("CANNOT AFFORD");
            }
        } else {
            throw new Exception("EXCEEDING 4 PROPERTIES");
        }
    }

    public int tryBuy(int spaceIdentifier) {
        try {
            this.buyProperty(spaceIdentifier);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
