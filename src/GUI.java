
/**********************************************************************
 * GUI for the monopoly board
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.*;

public class GUI {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        GameState gameState = new GameState();

        JFrame frame = buildFrame();
        frame.setVisible(true);

        // Upload image of Monopoly board and resize to fit size of window
        BufferedImage board = ImageIO.read(new File(GUI.class.getResource("/resources/ACBoard.jpg").toURI()));
        Image newBoard = board.getScaledInstance(1000, 778, Image.SCALE_SMOOTH);

        // Upload immage of piece 1
        BufferedImage piece1 = ImageIO.read(new File(GUI.class.getResource("/resources/Piece1ACMon.png").toURI()));
        Image p1Label = piece1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        // Upload immage of piece 2
        BufferedImage piece2 = ImageIO.read(new File(GUI.class.getResource("/resources/Piece2ACMon.png").toURI()));
        Image p2Label = piece2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        JPanel panel = new JPanel();

        // Make spaces clickable
        frame.addMouseListener(gameState);

        frame.add(panel);
        frame.repaint();

        // Make the image show up on the window
        Graphics g = frame.getGraphics();
        g.drawImage(newBoard, 0, 30, null);

        g.drawImage(p1Label, (int) gameState.getPlayer1().getCoordinates().getX(), (int) gameState.getPlayer1().getCoordinates().getY(), null);

        g.drawImage(p2Label, (int) gameState.getPlayer2().getCoordinates().getX(), (int) gameState.getPlayer2().getCoordinates().getY(), null);

        while (gameState.gameOver() == false) {

            // Wait for change. Sleep to ensure other computation can occur.
            while (gameState.stateChanged() == false) {
                Thread.sleep(30);
            }

            // Clear changes
            gameState.clearChange();
            g.drawImage(newBoard, 0, 30, null);

            // TODO: update gui


                g.drawImage(p1Label, (int) gameState.getPlayer1().getCoordinates().getX(), (int) gameState.getPlayer1().getCoordinates().getY(), null);
                
                g.drawImage(p2Label, (int) gameState.getPlayer2().getCoordinates().getX(), (int) gameState.getPlayer2().getCoordinates().getY(), null);

                String dice1Val = String.valueOf(gameState.getDice1());
                String dice2Val = String.valueOf(gameState.getDice2());

                g.setFont(new Font("TimesRoman", Font.BOLD, 40));
                g.drawString(dice1Val, 445, 625);
                g.drawString(dice2Val, 555, 625);

                //obvi gonna have to make it so money value changes but here's this for now
                String moneyP1 = String.valueOf(gameState.getPlayer1().getBells());
                String moneyP2 = String.valueOf(gameState.getPlayer2().getBells());
                g.setFont(new Font("TimesRoman", Font.BOLD, 25));
                g.drawString(moneyP1, 170, 50);
                g.drawString(moneyP2, 175, 75);
                
          

                JFrame returnFrame = gameState.getReturnFrame();
                
                returnFrame.setVisible(true);
          
            // Thread.sleep(30);
        }

        frame.dispose();
    }

    // Frame constructor
    static private JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1008, 815);
        frame.setVisible(true);
        return frame;
    }

    /**********************************
     * NEW
     *************************************************/
    // public void movePiece(int newPosition) {
    // // Move the player's piece to the new position
    // Graphics g = frame.getGraphics();
    // g.clearRect(930, 740, 50, 50);
    // g.drawImage(p1Label, newPosition, 740, null);
    // frame.repaint();
    // }
    // Locations for game pieces

}