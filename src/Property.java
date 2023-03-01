public class Property {
    public int[] properties;
    public String propertyName;
    public String color;
    public int spaceIdentifier;
    public int purchaseCost;
    public int rentCost;
    public int mortgage;
    public int oneHouse;
    public double rentIncreaseRate;
    final double UNMORTAGE_PERC = 1.1;
    final double RR_INITIAL_COST = 25;
    final double RR_INCREASE = 2;
    final int UTILITIES_ONE_OWNED = 4;
    final int UTILITIES_TWO_OWNED = 10;

    public Property(String name, int space,int purchase, int rent, int mortgage, double rentIncreaseRate, String color, int oneHouse) {
        this.propertyName = name;
        this.spaceIdentifier = space;
        this.purchaseCost = purchase;
        this.rentCost = rent;
        this.mortgage = mortgage;
        this.rentIncreaseRate = rentIncreaseRate;
        this.color = color;
        this.oneHouse = oneHouse;
    }

    //brown properties 
    Property rodney = new Property("Rodney's House", 1, 60,2, 30, 2.0, "brown", 10);

    Property rocket = new Property("Rocket's House", 3, 60, 4, 30, 2.3, "brown", 20);


    //light blue properties
    Property melba = new Property("Melba's House", 6, 100, 6, 50, 2.6, "light blue", 30);

    Property marina = new Property("Marina's House", 8, 100, 6, 50, 2.6, "light blue", 30);

    Property mitzi = new Property("Mitzi's House", 9, 120, 8, 60, 2.6, "light blue", 40);

   
    //pink properties
    Property flora = new Property("Flora's House", 11, 140, 10, 70, 3.0, "pink", 50);

    Property rosie = new Property("Rosie's House", 13, 140, 10, 70, 3.0, "pink", 50);

    Property chrissy = new Property("Chrissy's House", 14, 160, 12, 80, 2.8, "pink", 60);
   

    //orange properties
    Property bones = new Property("Bones House", 16, 180, 14, 90, 2.5, "orange", 70);

    Property cephalobot = new Property("Cephalobot's House", 18, 180, 14, 90, 2.5, "orange", 70);

    Property hopkins = new Property("Hopkin's House", 19, 200, 16, 100, 2.9, "orange", 80);


    //red properties
    Property octavin = new Property("Octavin's House", 21, 220, 18, 110, 2.8, "red", 90);

    Property fang = new Property("Fang's House", 23, 220, 18, 110, 2.8, "red", 90);

    Property kabuki = new Property("Kabuki's House", 24, 240, 20, 120, 2.8, "red", 100);
   

    //yellow properties
    Property stitches = new Property("Stiches's House", 26, 260, 22, 130, 2.8, "yellow", 110);

    Property shino = new Property("Shino's House", 27, 260, 22, 130, 2.8, "yellow", 110);

    Property bob = new Property("Bob's House", 29, 280, 24, 140, 2.8, "yellow", 120);
    

    //green properties
    Property francine = new Property("Francine's House", 21, 300, 26, 150, 2.8, "green", 130);

    Property judy = new Property("Judy's House", 32, 300, 26, 150, 2.8, "green", 130);

    Property diana = new Property("Diana's House", 34, 320, 28, 160, 2.8, "green", 150);
    
    
    //dark blue properties
    Property marshall = new Property("Marshall's House", 37, 350, 35, 175, 2.8, "dark blue", 175);
    
    Property raymond = new Property("Raymond's House", 39, 400, 50, 200, 2.8, "dark blue", 200);

}
