
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
        GameState gameState = new GameState(1);

        JFrame frame = buildFrame();
        frame.setVisible(true);

        // Upload image of Monopoly board and resize to fit size of window
        BufferedImage board = ImageIO.read(new File(GUI.class.getResource("/resources/ACBoard.jpg").toURI()));
        Image newBoard = board.getScaledInstance(1000, 778, Image.SCALE_SMOOTH);

        // Upload immage of piece 1
        BufferedImage piece1 = ImageIO.read(new File(GUI.class.getResource("/resources/Piece1ACMon.png").toURI()));
        Image p1Label = piece1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        // upload image of dice 1
        BufferedImage dice1Buffer = ImageIO.read(new File(GUI.class.getResource("/resources/Dice1.png").toURI()));
        Image dice1Img = dice1Buffer.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        // upload image of dice 2
        BufferedImage dice2Buffer = ImageIO.read(new File(GUI.class.getResource("/resources/Dice2.png").toURI()));
        Image dice2Img = dice2Buffer.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        JPanel panel = new JPanel();

        // Make spaces clickable
        frame.addMouseListener(gameState);

        frame.add(panel);
        frame.repaint();

        // Make the image show up on the window
        Graphics g = frame.getGraphics();
        g.drawImage(newBoard, 0, 30, null);
        g.drawImage(p1Label, 930, 740, null);
        g.drawImage(dice1Img, 410, 550, null);
        g.drawImage(dice2Img, 510, 550, null);

        while (gameState.gameOver() == false) {

            // Wait for change. Sleep to ensure other computation can occur.
            while (gameState.stateChanged() == false) {
                Thread.sleep(30);
            }
            // Clear changes
            gameState.clearChange();

            // TODO: update gui

            //this means a property wasn't clicked
            if (gameState.getReturnFrame() == null) {
                g.drawImage(p1Label, (int) gameState.getNewCoords().getX(), (int) gameState.getNewCoords().getY(), null);

                
            } 
            else {

            JFrame returnFrame = gameState.getReturnFrame();
            returnFrame.setVisible(true);

            }
            
            // graphics.fillRect(0, 0, frame.getWidth(), frame.getHeight());
            // graphics.drawImage(image, model.getX(), model.getY(), null);

            // Limit FPS
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