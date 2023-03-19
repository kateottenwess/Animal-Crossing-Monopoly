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

    private Player player1;

    private Player player2;
     
    private Player player3;

    private Player player4;


    /*******************************************************************
    * Constructor that sets the board array with the boardSpaceType     * that goes to that specific space type
    ******************************************************************/
    public Board(String name1, String name2, String name3, String name4) {
        BoardSpaceType b = new BoardSpaceType();
        int i = 0;
        while (i < spaces) {
            if (i == 0 || i ==2 || i == 4 || i == 7 || i == 10 || i == 17 || i == 20 || i == 22 || i == 30 || i == 33 || i ==  36 || i == 38) {
                board[i] = b.m.getType(i);
            }
            
            else {
                board[i] = b.p.getProperty(i);
            }

            i++;
        }

        for(int j = 0; j < spaces; j++) {
            ownedProperties[i] = 0;
        }

        player1 = new Player(1, name1);

        player2 = new Player(2, name2);

        player3 = new Player(3, name3);

        player4 = new Player (4, name4);
    }

    
    /****************************************************************** 
     * Method to return the type of space the space spaceidentifier is
     * for example, is it a property or a misc space
     * 
     * @param spaceIdentifier int representation of space
     * @return BoardSpaceType
     ******************************************************************/
    public BoardSpaceType getSpaceType(int spaceIdentifier) {
        int i = 0;
        BoardSpaceType type = board[0];
        while (i != spaceIdentifier) {
            type = board[i];
            i++;
        }

        return type;
    } 

    
    /****************************************************************** 
     * Method to return the space information of the space located at  
     * spaceIdentifier. It will return the property or the misc space-
     * which are BoardSpaceTypes
     * 
     * @param spaceIdentifier int representation of space
     * @return BoardSpaceType
     ******************************************************************/
    public BoardSpaceType returnSpaceInfo(int spaceIdentifier) {
        if (board[spaceIdentifier].p.getProperty(spaceIdentifier) != null) {
            return board[spaceIdentifier].p.getProperty(spaceIdentifier);
        }
        else {
            return board[spaceIdentifier].m.getType(spaceIdentifier);
        }
    }

}


