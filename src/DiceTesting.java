import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DiceTesting {
    
    Dice d = new Dice();
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
    public void testDiceRoll() {

        int i = 0;
        while (i < 100) {

            int val = d.rollDice();

            assertTrue(val >=1 && val <= 6);

            i++;
        }
    }


    @Test
    public void testDiceDoubleTrue() {
        int diceval1 = 1;
        int diceval2 = 1;

        assertTrue(d.doubleRoll(diceval1, diceval2));
    }

    @Test
    public void testDiceDoubleFalse() {
        int diceval1 = 1;
        int diceval2 = 2;

        assertFalse(d.doubleRoll(diceval1, diceval2));
    }

    @Test
    public void testNumDoublesToJailTrue() {
        int diceval1 = 2;
        int diceval2 = 2;

        d.doubleRoll(diceval1, diceval2);

        diceval1 = 3;
        diceval2 = 3;

        d.doubleRoll(diceval1, diceval2);

        diceval1 = 4;
        diceval2 = 4;

        d.doubleRoll(diceval1, diceval2);

        assertTrue(d.doubleJail());
    }

    @Test
    public void testNumDoublesToJailFalse() {
        int diceval1 = 2;
        int diceval2 = 2;

        d.doubleRoll(diceval1, diceval2);

        diceval1 = 3;
        diceval2 = 3;

        d.doubleRoll(diceval1, diceval2);

        diceval1 = 4;
        diceval2 = 5;

        d.doubleRoll(diceval1, diceval2);

        assertFalse(d.doubleJail());
    }
}


