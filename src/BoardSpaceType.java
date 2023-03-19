/**********************************************************************
 * Class stores monopoly board space types 
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class BoardSpaceType {
    
    /* object p to represent type Property */
    public Property p;

    /* object m to represent type MiscSpaces */
    public MiscSpaces m;


    /*******************************************************************
    * Constructor that sets p and m to null as their purpose is simply 
    * to signify their type
    ******************************************************************/
    public BoardSpaceType () {
        p = null;
        m = null;
    }
}
