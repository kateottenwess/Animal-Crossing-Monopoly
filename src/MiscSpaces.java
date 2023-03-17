/**********************************************************************
 * Class stores non-property spaces in the board
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class MiscSpaces extends BoardSpaceType {
    public MiscSpaces go;
    public MiscSpaces incomeTax;
    public MiscSpaces freeParking;
    public MiscSpaces goToJail;
    public MiscSpaces luxuryTax;
    public MiscSpaces jail;

    public MiscSpaces getType(int spaceIdentifier) {
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
