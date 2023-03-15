public class Jail extends MiscSpaces {
    //class to configure the jail code for use in board/space classes
    private Square square;
    private BoardSpaceType spaceType;

    public Jail(Square square, BoardSpaceType spaceType) {
        this.square = square;
        this.spaceType = spaceType;
    }
    
    public void jailPlayer(Player jailed) {
        
    }
    
}
