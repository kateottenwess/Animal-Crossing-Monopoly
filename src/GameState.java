import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class GameState {
    private int numPlayers;
    private static ArrayList<Player> players;
    private Board board;
    private static Dice dice;
    private static GUI gui;
    private Jail jail;
    private boolean gameEnded;

    public GameState(int numPlayers) throws IOException, URISyntaxException {
        this.numPlayers = numPlayers;
        players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            String name = JOptionPane.showInputDialog("Enter name for Player " + i);
            Player player = new Player(i, name);
            players.add(player);
        }
        //board = new Board(); is throwing null pointer
        dice = new Dice();
        gui = new GUI();

    }
    
    public static void startGame() throws IOException, URISyntaxException {
        for (Player player : players) {
            int dice1 = dice.rollDice1();
            int dice2 = dice.rollDice2();
            int newPosition = player.getBoardPos() + dice1 + dice2;
            if (newPosition >= 40) {
                newPosition -= 40;
            } else {
                player.move(dice1, dice2);
            }
            gui.movePiece(newPosition);
            
        }
    }
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        new GameState(1);
        startGame();
    }

    //help initialize player in gui? only works for one player rn but that's all we need
    public Player getPlayer(){
        return players.get(0);
    } 

}
