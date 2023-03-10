public class Square {
    private String name;
    private int position;
    private int price;
    private Player player;
    private PropertyType propertyType;
    private Property property;
    private BoardSpaceType spaceType;

    public Square(String name, int position, int price, PropertyType propertyType, Property property, 
    BoardSpaceType spaceType) {
        this.name = name;
        this.position = position;
        this.price = price;
        this.player = null;
        this.propertyType = propertyType;
        this.property = property;
        this.spaceType = spaceType;
    }

    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
    
    public int getPrice() {
        return price;
    }

    public Player getPlayer() {
        return player;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public Property getProperty() {
        return property;
    }
    
    public BoardSpaceType getSpaceType(){
        return spaceType;
    }

    public boolean hasPlayer(Square position, Player player) {
        if (position.getPlayer() != null) {
            return true;
        } else {
            return false;
        }
    }


}