package monopoly;

/**********************************************************************
 * Class stores jail capabilities and actions
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Jail extends MiscSpaces {
    //class to configure the jail code for use in board/space classes
    private BoardSpaceType spaceType;



    /*******************************************************************
    * Constructor that sets the space type and the square
    ******************************************************************/
    public Jail(final BoardSpaceType spaceType) {
        this.spaceType = spaceType;
    }

    /******************************************************************
     * Method to jail player
     * 
     * @param jailed Player
     ******************************************************************/
    public void jailPlayer(final Player jailed) {
        
    }
    
}
