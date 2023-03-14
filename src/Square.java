public class Square {
    private String name;
    private int position;
    private int price;
    private Player owner;
    private PropertyType propertyType;
    private Property property;

    public Square(String name, int position, int price, PropertyType propertyType, Property property) {
        this.name = name;
        this.position = position;
        this.price = price;
        this.owner = null;
        this.propertyType = propertyType;
        this.property = property;
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
        return owner;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public Property getProperty() {
        return property; 
    }

    public boolean isOwned() {
        if (owner != null) {
            return true;
        } else {
            return false;
        }
    }


}