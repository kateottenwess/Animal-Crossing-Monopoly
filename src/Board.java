public class Board {
    private final int spaces = 40;
    //private final Square[] board;
    private BoardSpaceType[] board = new BoardSpaceType[spaces];

    //constructor to remove later
    public Board(BoardSpaceType[] board) {
        this.board = board;
    }

    public Player getPlayer(Square space, Player player) {
        //return player on square if we need this idfk
        return player;
    }

    //get board space type function - is it a property, community chest, etc
    public BoardSpaceType getSpaceType(int spaceIdentifier) {

    }
    //please god just kill me
    
}


