/**********************************************************************
 * Class stores all monopoly properties
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Property extends BoardSpaceType {

    /* Name of the property */
    private String propertyName;

    /* Color of the property */
    private String color;

    /* Integer value of what space it is on the board */
    private int spaceIdentifier;

    /* Cost to purchase the property */
    private int purchaseCost;

    /* Cost to rent the property */
    private int rentCost;

    /* Cost to mortgage property */
    private int mortgage;

    /* Cost of rent with one house */
    private int oneHouse;

    /* Number of houses on property */
    private int numHouses;

    /* which player owns specific property */
    private int playerNumOwning;

    /* Rent increase rate when more than one home is placed */
    private double rentIncreaseRate;

    /* Boolean representing if the property is owned or not */
    private boolean owned;

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
     * @param color color of the property
     * @param oneHouse price of one house to place on the property
     * @param owned boolean representing if owned or not
     * @param numHouses number of houses on property
     ******************************************************************/
    public Property(String name, int space, int purchase, int rent, double rentIncreaseRate, String color,
            int oneHouse) {
        this.propertyName = name;
        this.spaceIdentifier = space;
        this.purchaseCost = purchase;
        this.rentCost = rent;
        this.mortgage = (int) MORTGAGE_PERC_OF_PURCHASE * purchase;
        this.rentIncreaseRate = rentIncreaseRate;
        this.color = color;
        this.oneHouse = oneHouse;
        this.owned = false;
        this.numHouses = 0;
        this.playerNumOwning = 0;
    }


    /******************************************************************
     * Getter to return property name
     * @return String
     ******************************************************************/
    public String getPropertyName() {
        return this.propertyName;
    }


    /******************************************************************
     * Getter to return property color
     * @return String
     ******************************************************************/
    public String getColor() {
        return this.color;
    }


    /******************************************************************
     * Getter to return property space
     * @return int
     ******************************************************************/
    public int getSpaceIdentifier() {
        return this.spaceIdentifier;
    }


    /******************************************************************
     * Getter to return property purchase cost
     * @return int
     ******************************************************************/
    public int getPurchaseCost() {
        return this.purchaseCost;
    }


    /******************************************************************
     * Getter to return property rent cost
     * @return int
     ******************************************************************/
    public int getRentCost() {
        return this.rentCost;
    }


    /******************************************************************
     * Getter to return property mortgage
     * @return int
     ******************************************************************/
    public int getMortgage() {
        return this.mortgage;
    }


    /******************************************************************
     * Getter to return price of one house for the property
     * @return int
     ******************************************************************/
    public int getOneHouse() {
        return this.oneHouse;
    }


    /******************************************************************
     * Getter to return property rent increase rate
     * @return double
     ******************************************************************/
    public double getRentIncreaseRate() {
        return this.rentIncreaseRate;
    }


    /******************************************************************
     * Getter to return if property is owned
     * @return boolean
     ******************************************************************/
    public boolean isOwned() {
        return this.owned;
    }


    /******************************************************************
     * Setter to set if property is owned or not
     * @param owned boolean
     ******************************************************************/
    public void setOwned(boolean owned, int playerNum) {

        //set owned to owned boolean
        this.owned = owned;

        //set who owns the property
        this.playerNumOwning = playerNum;
    }


    /******************************************************************
     * Getter to return number of house on property
     * @return bint number of houses
     ******************************************************************/
    public int getNumHouses() {
        return this.numHouses;
    }


    /******************************************************************
     * Setter that increases number of houses on property
     * @param numHouses int number of houses purchased
     ******************************************************************/
    public void increaseNumHouses(int numHouses) {
        this.numHouses += numHouses;
    }

    
    /******************************************************************
     * Method to increase the rent of a property if houses are purchased
     * If 1 is return, the rent cost could be increased, else it can't  * be increased.
     * 
     * @param houseNum number of houses purchased
     ******************************************************************/
    public void increaseRent(int houseNum) {

        //if there is one house on the property
        if (houseNum == 1) {

            //increase rent to price with one house
            this.rentCost = this.oneHouse;
        } 
        
        //if there are more than one house and less than the max amount of houses permitted on the property, increase rent by num houses * one house
        else if (houseNum <= MAX_AMOUNT_HOUSES) {
            this.rentCost = (int) (this.rentIncreaseRate * this.oneHouse) * houseNum;
        }
    }

    
    /******************************************************************
     * Method that returns the property that correlates to integer     * space. Returns null if no property is associated to said space
     * 
     * @param space int value of space on board
     * @return property on space, null if no property
     ******************************************************************/
    public Property getProperty(int space) {

        //temporary Property for property that is potentially found
        Property propFound;

        //loop through properties to find if a property is found
        for (int i = 0; i <= GameState.props.size(); i++) {

            //
            if (GameState.props.indexOf(i) == space) {

                //if there is a property on space, return property
                propFound = GameState.props.get(i);
                return propFound;
            }
        }

        //if no property is on space, return null
        return null;
    }
}
