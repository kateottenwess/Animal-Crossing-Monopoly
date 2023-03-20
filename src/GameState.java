import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class GameState {
    private int numPlayers;
    private ArrayList<Player> players;
    private Board board;
    private Dice dice;
    private GUI gui;
    private Jail jail;
    private boolean gameEnded;

    public GameState(int numPlayers) {
        this.numPlayers = numPlayers;
        players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            String name = JOptionPane.showInputDialog("Enter name for Player " + i);
            Player player = new Player(i, name);
            players.add(player);
        }
        board = new Board();
        dice = new Dice();
        gui = new GUI();
        
    }
}
