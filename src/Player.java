/**********************************************************************
 * Class contains player information and actions
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Player {
    private String name;
    private int boardPos;
    private int bells;
    
    //indices are the space identifiers, the value in the array will be either 0 (false-not owned) or 1 (true-owned)
    private int[] properties;

    public Player(String name) {
        this.name = name;
        this.bells = 1500;
        this.boardPos = 0;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoardPos() {
        return boardPos;
    }

    public void setBoardPos(int boardPos) {
        this.boardPos = boardPos;
    }

    public int getBells() {
        return bells;
    }

    public void setBells(int bells) {
        this.bells = bells;
    }

    public int hasProperty(Player player, Property property) {
        //wip
        return 1;
    }

    // public void buyProperty(int spaceIdentifier) {
        
    // }

    // public void mortageProperty(int spaceIdentifier) {}

    // public int rollDice() {

    // }

}
