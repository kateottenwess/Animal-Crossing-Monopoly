/**********************************************************************
 * Class stores non-property spaces in the board
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class MiscSpaces extends BoardSpaceType {

    /* object for the go space */
    public MiscSpaces go;

    /* object for the income tax space */
    public MiscSpaces incomeTax;

    /* object for the free parking space */
    public MiscSpaces freeParking;

    /* object for the go to jail space */
    public MiscSpaces goToJail;

    /* object for the luxury tax space */
    public MiscSpaces luxuryTax;

    /* object for the jail space */
    public MiscSpaces jail;

    
    /***********************************************************
     * Method that returns the specific mis space from the space       
     * identifier
     *  
     * @param spaceIdentifier
     * @return MiscSpaces
     ************************************************************/
    public MiscSpaces getType(final int spaceIdentifier) {
        switch (spaceIdentifier) {
            case 0:
                return go;
            case 4:
                return incomeTax;
            case 10:
                return jail;
            case 20:
                return freeParking;
            case 30:
                return goToJail;
            case 38:
                return luxuryTax;
            default:
                return null;
        }
    }
}
