package monopoly;
/**********************************************************************
 * Class stores monopoly board and runs game logic
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Board extends BoardSpaceType {

    //amount of spaces on the board
    public final static int spaces = 40;

    //private final Square[] board;
    private BoardSpaceType[] board = new BoardSpaceType[spaces];

    //int array to contain which players owns which space
    private int[] ownedProperties = new int[spaces];


    /*******************************************************************
    * Constructor that sets the board array with the boardSpaceType     * that goes to that specific space type
    ******************************************************************/
    public Board() {

        //creation of a BoardSpaceType
        BoardSpaceType b = new BoardSpaceType();

        //iteration variable
        int i = 0;

        //loop through spaces array and set the types of the spaces
        while (i < spaces) {

            //these spaces are misc spaces
            if (i == 0 || i ==2 || i == 4 || i == 7 || i == 10 || i == 17 || i == 20 || i == 22 || i == 30 || i == 33 || i ==  36 || i == 38) {
                board[i] = b.miscSpace.getType(i);
            }
            
            //the rest are property spaces
            else {
                board[i] = b.propertySpace.getProperty(i);
            }

            //continue loop
            i++;
        }

        //set owned property array values to 0 because no one owns properties initially
        for(int j = 0; j < spaces; j++) {
            ownedProperties[i] = 0;
        }
    }

    
    /****************************************************************** 
     * Method to return the type of space the space spaceidentifier is
     * for example, is it a property or a misc space
     * 
     * @param spaceIdentifier int representation of space
     * @return BoardSpaceType
     ******************************************************************/
    public BoardSpaceType getSpaceType(int spaceIdentifier) {

        //iteration variable
        int i = 0;

        //temporary BoardSpaceType variable to be returned
        BoardSpaceType type = board[0];

        //loop throuh board spaces
        while (i != spaceIdentifier) {

            //if i is not the space desired, continue
            type = board[i];
            i++;
        }

        //return BoardSpaceType of int spaceIdentifier
        return type;
    } 
}


