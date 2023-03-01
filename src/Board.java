public class Board extends BoardSpaceType {
    private final int spaces = 40;
    //private final Square[] board;
    private BoardSpaceType[] board = new BoardSpaceType[spaces];

    //constructor
    public Board() {
        int i = 0;
        while (i < spaces) {
            if (i == 0 || i == 4 || i == 10 || i == 20 || i == 30 || i == 38) {
                board[i] = m;
            }
            else if (i == 2 || i == 17 || i == 33) {
                board[i] = cc;
            }
            else if (i == 7 || i == 22 || i == 36) {
                board[i] = c;
            }
            else {
                board[i] = p;
            }

            i++;
        }
    }

    // public Player getPlayer(BoardSpaceType space) {
    //     //return player on square if we need this idfk
    //     return player;
    // }

    //get board space type function - is it a property, community chest, etc
    public BoardSpaceType getSpaceType(int spaceIdentifier) {
        int i = 0;
        BoardSpaceType type = board[0];
        while (i != spaceIdentifier) {
            type = board[i];
            i++;
        }

        return type;
    } 
}


