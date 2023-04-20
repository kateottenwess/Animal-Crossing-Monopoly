/**********************************************************************
 * Class stores all monopoly properties.
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Property {

    /* Name of the property */
    private String propertyName;

    /* Integer value of what space it is on the board */
    private int spaceIdentifier;

    /* Cost to purchase the property */
    private int purchaseCost;

    /* Cost to rent the property */
    private int rentCost;

    /* Boolean representing if the property is owned or not */
    private boolean owned;

    /* Player who owns specific property */
    private Player playerOwning;

    /* Percent multiplied by mortgage price- this is price to unmortgage */
    final double UNMORTAGE_PERC = 1.1;

    /* Initial cost of railroad purchase */
    final double RR_INITIAL_COST = 25;

    /* Rate of increase of railroad rent */
    final double RR_INCREASE = 2;

    /* Rate purchase cost is multiplied by to get mortgage cost */
    final double MORTGAGE_PERC_OF_PURCHASE = 0.5;

    /* Rate * value of dice roll is the amount of rent if one is owned */
    final int UTILITIES_ONE_OWNED = 4;

    /* Rate * value of dice roll is the amount of rent if both are owned by the same player */
    final int UTILITIES_TWO_OWNED = 10;

    /* Max amount of homes allowed on property */
    final int MAX_AMOUNT_HOUSES = 4;


    /*******************************************************************
     * Constructor used to set each property for the game.
     * Values -1 or "NA" means that the specification it is associated 
     * with is not applicable for that property type.
     * 
     * @param name name of the property
     * @param space the space on the board
     * @param purchase purchase price of the property
     * @param rent rent price of the property
     * @param mortgage price received from mortgaging the property
     * @param rentIncreaseRate the rate rent increases when homes are 
     *                         added to the property
     * @param oneHouse price of one house to place on the property
     * @param owned boolean representing if owned or not
     * @param numHouses number of houses on property
     ******************************************************************/
    public Property(String name, int space, int purchase, int rent) {
        this.propertyName = name;
        this.spaceIdentifier = space;
        this.purchaseCost = purchase;
        this.rentCost = rent;
        this.owned = false;
        this.playerOwning = null;
    }


    /******************************************************************
     * Getter to return property name.
     * @return String
     ******************************************************************/
    public String getPropertyName() {
        return this.propertyName;
    }


    /******************************************************************
     * Getter to return property space.
     * @return int
     ******************************************************************/
    public int getSpaceIdentifier() {
        return this.spaceIdentifier;
    }


     /******************************************************************
     * Getter to return if property is owned or not.
     * @return boolean
     ******************************************************************/
    public boolean getOwned() {
        return this.owned;
    }


    /******************************************************************
     * Getter to return property purchase cost.
     * @return int
     ******************************************************************/
    public int getPurchaseCost() {
        return this.purchaseCost;
    }


    /******************************************************************
     * Getter to return property rent cost.
     * @return int
     ******************************************************************/
    public int getRentCost() {
        return this.rentCost;
    }


    /******************************************************************
     * Getter to return if property is owned.
     * @return boolean
     ******************************************************************/
    public boolean isOwned() {
        return this.owned;
    }


    /******************************************************************
     * Setter to set if property is owned or not.
     * @param owned boolean
     ******************************************************************/
    public void setOwned(boolean owned, Player player) {

        //set owned to owned boolean
        this.owned = owned;

        //set who owns the property
        this.playerOwning = player;
    }


    /******************************************************************
     * Method that determines if a space is purchasable or not.
     * @param bells int value of current players bells
     * @param p Property to be bought
     * @return boolean, true if purchasable, false otherwise
     ******************************************************************/
    public boolean canBuy(int bells, Property p) {
        boolean answer = false;

        if (p.getPurchaseCost() < bells) {
            if (!p.getOwned()) {
                answer = true;
            }
        }
        return answer;
    }
}
