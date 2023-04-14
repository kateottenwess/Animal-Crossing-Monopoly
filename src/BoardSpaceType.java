/**********************************************************************
 * Class stores monopoly board space types 
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class BoardSpaceType {
    
    /* object p to represent type Property */
    public Property propertySpace;

    /* object m to represent type MiscSpaces */
    public MiscSpaces miscSpace;


    /*******************************************************************
    * Constructor that sets p and m to null as their purpose is simply 
    * to signify their type
    ******************************************************************/
    public BoardSpaceType () {
        propertySpace = null;
        miscSpace = null;
    }
}
