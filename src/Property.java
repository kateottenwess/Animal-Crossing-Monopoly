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

    /* Initial cost of railroad purchase */
    final double RR_INITIAL_COST = 25;

    /* Rate * value of dice roll is the amount of rent if one is owned */
    final int UTILITIES_ONE_OWNED = 4;


    /*******************************************************************
     * Constructor used to set each property for the game.
     * Values -1 or "NA" means that the specification it is associated 
     * with is not applicable for that property type.
     * 
     * @param name name of the property
     * @param space the space on the board
     * @param purchase purchase price of the property
     * @param rent rent price of the property
     ******************************************************************/
    public Property(String name, int space, int purchase, int rent) {
        this.propertyName = name;
        this.spaceIdentifier = space;
        this.purchaseCost = purchase;
        this.rentCost = rent;
        this.owned = false;
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
    public void setOwned(boolean owned) {

        //set owned to owned boolean
        this.owned = owned;

    }


    /******************************************************************
     * Method that determines if a space is purchasable or not.
     * @param bells int value of current players bells
     * @param p Property to be bought
     * @return boolean, true if purchasable, false otherwise
     ******************************************************************/
    public boolean canBuy(int bells, Property p) {
        boolean answer = false;

        if (p.getPurchaseCost() <= bells) {
            if (!p.isOwned()) {
                answer = true;
            }
        }
        return answer;
    }
}
