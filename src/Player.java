import java.awt.Point;

/**********************************************************************
 * Class contains player information and actions.
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class Player {

    /*Name of player*/
    private String name;

    /*Coordinates of player on board*/
    private Point coordinates;

    /*integer value of players board position*/
    private int boardPos;

    /*Bells amount for player*/
    private int bells;


    /*******************************************************************
     * Constructor that initializes the players name, money amount, and
     * board position.
     ******************************************************************/
    public Player(String name) {
        this.name = name;
        this.bells = 1500;
        this.boardPos = 0;
    }


    /******************************************************************
     * Getter to return player name.
     * 
     * @return String
     ******************************************************************/
    public String getName() {
        return name;
    }


    /******************************************************************
     * Getter to return players board position.
     * 
     * @return int
     ******************************************************************/
    public int getBoardPos() {
        return boardPos;
    }


    /******************************************************************
     * Setter to set player board position.
     * 
     * @param boardPos int
     ******************************************************************/
    public void setBoardPos(final int boardPos) {
        this.boardPos = boardPos;
    }


    /******************************************************************
     * Getter to return player bells.
     * 
     * @return int
     ******************************************************************/
    public int getBells() {
        return bells;
    }


    /******************************************************************
     * Setter to set player bells amount.
     * 
     * @param bells int
     ******************************************************************/
    public void setBells(final int bells) {
        this.bells = bells;
    }


    /******************************************************************
     * Setter to set player coordinates for board.
     * 
     * @param p Point
     ******************************************************************/
    public void setCoordinates(Point p) {
        coordinates = p;
    }


    /******************************************************************
     * Getter to return the players coordinates.
     * 
     * @return Point
     ******************************************************************/
    public Point getCoordinates() {
        return coordinates;
    }
}
