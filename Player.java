public class Player {
    private String name;
    private int boardPos;
    private int bells;

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
}
