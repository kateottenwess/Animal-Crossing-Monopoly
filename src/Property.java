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
    Property rodney = new Property("Rodney's House", 1, 60, 8, 30, 3.0, "brown", 10);

    Property rocket = new Property("Rocket's House", 2, 60, 10, 30, 3.0, "brown", 20);


    //light blue properties

    // brown properties - shitty ones
    //Node rodney = new Node(1, )
    // rodney
    // rocket
    // blue properties - normal
    // marina
    // mitzi
    // melbaS

    // pink properties - peppy
    // rosie
    // chrissy
    // flora

    // organe properties - lazy
    // bones
    // cephalobot
    // hopkins

    // red properties - cranky
    // octavin
    // kabuki
    // fang

    // yellow properties - i actually hate sisterly so these are random
    // shino
    // stitches
    // bob
    // green properties - snooty
    // francine
    // judy
    // diana

    // dark blue properties - populat ones for some reason
    // raymond
    // marshall

}
