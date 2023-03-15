public class Board extends BoardSpaceType {
    private final int spaces = 40;
    //private final Square[] board;
    private BoardSpaceType[] board = new BoardSpaceType[spaces];

    //constructor
    public Board() {
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

    //return the space info of the space
    public BoardSpaceType returnSpaceInfo(int spaceIdentifier) {
        if (board[spaceIdentifier].p.getProperty(spaceIdentifier) != null) {
            return board[spaceIdentifier].p.getProperty(spaceIdentifier);
        }
        else {
            return board[spaceIdentifier].m.getType(spaceIdentifier);
        }
    }

}


