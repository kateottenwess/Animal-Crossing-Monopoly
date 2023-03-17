/**********************************************************************
 * Class stores all monopoly properties
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Property extends BoardSpaceType {

    /* Array to store the properties for easier access */
    public int[] properties;

    /* Name of the property */
    public String propertyName;

    /* Color of the property */
    public String color;

    /* Integer value of what space it is on the board */
    public int spaceIdentifier;

    /* Cost to purchase the property */
    public int purchaseCost;

    /* Cost to rent the property */
    public int rentCost;

    /* Cost to mortgage the property */
    public int mortgage;

    /* Cost of rent with one house */
    public int oneHouse;

    /* Rent increase rate when more than one home is placed */
    public double rentIncreaseRate;

    /* Boolean representing if the property is owned or not */
    public boolean owned;

    /* Percent multiplied by mortgage price- this is price to unmortgage */
    final double UNMORTAGE_PERC = 1.1;


    final double RR_INITIAL_COST = 25;
    final double RR_INCREASE = 2;

    /* Rate * value of dice roll is the amount of rent if one is owned */
    final int UTILITIES_ONE_OWNED = 4;

    /* Rate * value of dice roll is the amount of rent if both are owned by the same player */
    final int UTILITIES_TWO_OWNED = 10;


    /*******************************************************************
	 * Constructor used to set each property for the game.
     * Values -1 or "NA" means that the specification it is associated * with is not applicable for that property type.
	 * 
	 * @param name name of the property
     * @param space the space on the board
     * @param purchase purchase price of the property
     * @param rent rent price of the property
     * @param mortgage price to mortgage the property
     * @param rentIncreaseRate the rate rent increases when homes are   *        added to the property
     * @param color color of the property
     * @param oneHouse price of one house to place on the property
     * @param owned boolean representing if owned or not
	 ******************************************************************/
    public Property(String name, int space, int purchase, int rent, int mortgage, double rentIncreaseRate, String color,
            int oneHouse, boolean owned) {
        this.propertyName = name;
        this.spaceIdentifier = space;
        this.purchaseCost = purchase;
        this.rentCost = rent;
        this.mortgage = mortgage;
        this.rentIncreaseRate = rentIncreaseRate;
        this.color = color;
        this.oneHouse = oneHouse;
        this.owned = owned;
    }

    
    Property rodney = new Property("Rodney's House", 1, 60, 2, 30, 2.0, "brown", 10, false);


    Property rocket = new Property("Rocket's House", 3, 60, 4, 30, 2.3, "brown", 20, false);

    
    Property melba = new Property("Melba's House", 6, 100, 6, 50, 2.6, "light blue", 30, false);


    Property marina = new Property("Marina's House", 8, 100, 6, 50, 2.6, "light blue", 30, false);


    Property mitzi = new Property("Mitzi's House", 9, 120, 8, 60, 2.6, "light blue", 40, false);

    

    Property flora = new Property("Flora's House", 11, 140, 10, 70, 3.0, "pink", 50, false);


    Property rosie = new Property("Rosie's House", 13, 140, 10, 70, 3.0, "pink", 50, false);


    Property chrissy = new Property("Chrissy's House", 14, 160, 12, 80, 2.8, "pink", 60, false);

    
    Property bones = new Property("Bones House", 16, 180, 14, 90, 2.5, "orange", 70, false);


    Property cephalobot = new Property("Cephalobot's House", 18, 180, 14, 90, 2.5, "orange", 70, false);


    Property hopkins = new Property("Hopkin's House", 19, 200, 16, 100, 2.9, "orange", 80, false);

    
    Property octavin = new Property("Octavin's House", 21, 220, 18, 110, 2.8, "red", 90, false);


    Property fang = new Property("Fang's House", 23, 220, 18, 110, 2.8, "red", 90, false);


    Property kabuki = new Property("Kabuki's House", 24, 240, 20, 120, 2.8, "red", 100, false);

    
    Property stitches = new Property("Stiches's House", 26, 260, 22, 130, 2.8, "yellow", 110, false);


    Property shino = new Property("Shino's House", 27, 260, 22, 130, 2.8, "yellow", 110, false);


    Property bob = new Property("Bob's House", 29, 280, 24, 140, 2.8, "yellow", 120, false);

    
    Property francine = new Property("Francine's House", 31, 300, 26, 150, 2.8, "green", 130, false);


    Property judy = new Property("Judy's House", 32, 300, 26, 150, 2.8, "green", 130, false);


    Property diana = new Property("Diana's House", 34, 320, 28, 160, 2.8, "green", 150, false);

    
    Property marshall = new Property("Marshall's House", 37, 350, 35, 175, 2.8, "dark blue", 175, false);


    Property raymond = new Property("Raymond's House", 39, 400, 50, 200, 2.8, "dark blue", 200, false);

    
    // -1 or NA means it is not applicible for this specific property type
    // waterworks
    Property ableSis = new Property("Able Sisters", 28, 150, -1, 75, -1, "NA", -1, false);


    // electrical
    Property nooksCranny = new Property("Nooks Cranny", 12, 150, -1, 75, -1, "NA", -1, false);


    // railroads
    Property rr1 = new Property("Railroad", 5, 200, 25, 100, 2.0, "NA", -1, false);

    
    Property rr2 = new Property("Railroad", 15, 200, 25, 100, 2.0, "NA", -1, false);

    
    Property rr3 = new Property("Railroad", 25, 200, 25, 100, 2.0, "NA", -1, false);

    
    Property rr4 = new Property("Railroad", 35, 200, 35, 100, 2.0, "NA", -1, false);

    
    /********************************************************
     * Method to return which property is which space
     * @param spaceIdentifier
     * @return Property
     *********************************************************/
    public Property getProperty(int spaceIdentifier) {
        switch (spaceIdentifier) {
            case 1:
                return rodney;
            case 3:
                return rocket;
            case 5: 
                return rr1;
            case 6:
                return melba;
            case 8:
                return marina;
            case 9:
                return mitzi;
            case 11:
                return flora;
            case 12:
                return nooksCranny;
            case 13:
                return rosie;
            case 14:
                return chrissy;
            case 15:
                return rr2;
            case 16:
                return bones;
            case 18:
                return cephalobot;
            case 19:    
                return hopkins;
            case 21:
                return octavin;
            case 23:
                return fang;
            case 24:
                return kabuki;
            case 25:
                return rr3;
            case 26:
                return stitches;
            case 27:
                return shino;
            case 28:
                return ableSis;
            case 29:
                return bob;
            case 31:
                return francine;
            case 32:
                return judy;
            case 34:
                return diana;
            case 35:
                return rr4;
            case 37:
                return marshall;
            case 39:
                return raymond;
            default:
                return null;
        }
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
    public int getSpaceIndentifier() {
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
    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    
    /******************************************************************
     * Method to increase the rent of a property if houses are purchased
     * If 1 is return, the rent cost could be increased, else it can't  * be increased
     * @param houseNum number of houses purchased
     * @return int
     ******************************************************************/
    public int increaseRent(int houseNum) {
        if (houseNum == 1) {
            this.rentCost += this.oneHouse;
            return 1;
        }
        else if (houseNum < 5){
            this.rentCost += this.rentIncreaseRate * this.oneHouse;
            return 1;
        }
        else {
            return 0;
        }
    }
}
