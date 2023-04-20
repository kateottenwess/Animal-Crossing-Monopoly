import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class PlayerTesting {

    Player player = new Player("Kate");
    
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
    public void testGetName() {
        assertTrue(player.getName().equals("Kate"));
    }

    @Test 
    public void testGetBoardPos() {
        assertTrue(player.getBoardPos() == 0);
    }

    @Test 
    public void testSetBoardPos() {
        player.setBoardPos(16);
        assertTrue(player.getBoardPos() == 16);
    }

    @Test 
    public void testGetBells() {
        assertTrue(player.getBells() == 1500);
    }

    @Test 
    public void testSetBells() {
        player.setBells(100);
        assertTrue(player.getBells() == 100);
    }

    @Test 
    public void testSetCoordinates() {
        Point p = new Point(209, 899);

        player.setCoordinates(p);
        
        assertTrue(player.getCoordinates().equals(p));
    }

    @Test 
    public void testGetCoordinates() {
        assertTrue(player.getCoordinates() == null);
    }
}