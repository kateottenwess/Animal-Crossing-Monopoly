import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GameStateTesting {

    GameState g = new GameState();

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
    public void testGetReturnFrame() {
        assertTrue(g.getReturnFrame() == null);
    }

    @Test 
    public void testGetDice1() {
        assertTrue(g.getDice1() == -1);
    }

    @Test 
    public void testGetDice2() {
        assertTrue(g.getDice2() == -1);
    }

    @Test 
    public void testGameOver() {
        assertTrue(g.gameOver() == false);
    }

    @Test 
    public void testClearChange() {
        
    }

    @Test 
    public void testGetPlayer1() {
        assertTrue(g.getPlayer1().getName().equals("player1"));
    }

    @Test 
    public void testGetPlayer2() {
        assertTrue(g.getPlayer2().getName().equals("player2"));
    }

    @Test 
    public void testPickCCCard() {
        
    }

    @Test 
    public void testPickChanceCards() {
        
    }

    @Test 
    public void testGetPlayerBells() {
        assertTrue(g.getPlayer1().getBells() == 1500);
        assertTrue(g.getPlayer2().getBells() == 1500);
    }

    @Test 
    public void testPropertySpace() {
        
    }

    @Test 
    public void testChangePlayer() {
        
    }

}


