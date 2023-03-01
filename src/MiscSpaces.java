public class MiscSpaces extends BoardSpaceType {
    MiscSpaces go;
    MiscSpaces incomeTax;
    MiscSpaces freeParking;
    MiscSpaces goToJail;
    MiscSpaces luxuryTax;
    MiscSpaces jail;

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
