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
            //String name = JOptionPane.showInputDialog("Enter name for Player " + i);
            //Player player = new Player(i, name);
            //players.add(player);
        }
        //board = new Board(); is throwing null pointer
        dice = new Dice();
        gui = new GUI();

    }
    
    public static void startGame() throws IOException, URISyntaxException {
        Player player = new Player(1, "player1");
        int dice1 = dice.getDice1();
        System.out.println(dice1);
        int dice2 = dice.getDice2();
        System.out.println(dice2);
        player.move(dice1, dice2);
        System.out.println(player.getBoardPos());
    }
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        new GameState(1);
        startGame();
    }

    //help initialize player in gui? only works for one player rn but that's all we need
    public Player getPlayer(){
        Player player1 = new Player(1, "player1");
        return player1;
    } 

}
