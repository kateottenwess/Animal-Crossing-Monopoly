import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PropertyTesting {

    Property p = new Property("Test Property", 16, 200, 50);
    Player player = new Player(1, "Kate");

    
    /**************************************************************
     * 
     * INTEGRATION TESTING
     *  
    ****************************************************************/ 


    /**************************************************************
     * 
     * UNIT TESTING
     *  
    ****************************************************************/ 

    @Test
    public void testGetPropertyName() {
        assertTrue(p.getPropertyName().equals("Test Property"));
    }

    @Test
    public void testGetSpaceIdentifier() {
        assertTrue(p.getSpaceIdentifier() == 16);
    }


    @Test
    public void testGetPurchaseCost() {
        assertTrue(p.getPurchaseCost() == 200);
    }

    @Test
    public void testGetRentCost() {
        assertTrue(p.getRentCost() == 50);
    }

    @Test
    public void testIsOwned() {
        assertTrue(p.isOwned() == false);
    }

    @Test
    public void testSetOwned() {
        p.setOwned(true, player);

        assertTrue(p.isOwned() == true);
    }

    @Test
    public void testCanBuyTrue1() {
        assertTrue(p.canBuy(300, p));
    }

    @Test
    public void testCanBuyTrue2() {
        assertTrue(p.canBuy(200, p));
    }

    @Test
    public void testCanBuyFalseMoney() {
        assertFalse(p.canBuy(199, p));
    }

    @Test
    public void testCanBuyFalseOwned() {
        p.setOwned(true, player);
        
        assertFalse(p.canBuy(300, p));
    }

}
