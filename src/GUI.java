import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.*;

/**********************************************************************
 * GUI for the monopoly board
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class GUI {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        //create gameState instance
        GameState gameState = new GameState();

        //create main frame
        JFrame frame = buildFrame();

        //make frame visible
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

        //create panel for the frame
        JPanel panel = new JPanel();

        // Make spaces clickable
        frame.addMouseListener(gameState);

        //add panel to frame and repaint it
        frame.add(panel);
        frame.repaint();

        // create graphics object for images such as player pieces
        Graphics g = frame.getGraphics();

        //draw the board
        g.drawImage(newBoard, 0, 30, null);

        //draw player 1's piece
        g.drawImage(p1Label, (int) gameState.getPlayer1().getCoordinates().getX(), (int) gameState.getPlayer1().getCoordinates().getY(), null);

        //draw player 2's piece
        g.drawImage(p2Label, (int) gameState.getPlayer2().getCoordinates().getX(), (int) gameState.getPlayer2().getCoordinates().getY(), null);

        //set initial money vals
        //post the money value of each player onto board
        g.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g.drawString("1500", 170, 50);
        g.drawString("1500", 175, 75);

        //loop through to run game while the game is not over
        while (gameState.gameOver() == false) {

            // Wait for change. Sleep to ensure other computation can occur.
            while (gameState.stateChanged() == false) {
                Thread.sleep(30);
            }

            // Clear changes and redraw board
            gameState.clearChange();
            g.drawImage(newBoard, 0, 30, null);

            //redraw player 1, either in same place or at new coords
            g.drawImage(p1Label, (int) gameState.getPlayer1().getCoordinates().getX(), (int) gameState.getPlayer1().getCoordinates().getY(), null);
                
            //redraw player 2, either in same place or at new coords
            g.drawImage(p2Label, (int) gameState.getPlayer2().getCoordinates().getX(), (int) gameState.getPlayer2().getCoordinates().getY(), null);

            //get the values of each dice and turn to string
            String dice1Val = String.valueOf(gameState.getDice1());
            String dice2Val = String.valueOf(gameState.getDice2());

            //put dice values rolled onto board
            g.setFont(new Font("TimesRoman", Font.BOLD, 40));
            g.drawString(dice1Val, 445, 625);
            g.drawString(dice2Val, 555, 625);

            //if there is a pop up frame, make it appear
            JFrame returnFrame = gameState.getReturnFrame();
            returnFrame.setVisible(true);

            //post the money value of each player onto board
            String moneyP1 = String.valueOf(gameState.getPlayer1().getBells());
            String moneyP2 = String.valueOf(gameState.getPlayer2().getBells());
            g.setFont(new Font("TimesRoman", Font.BOLD, 25));
            g.drawString(moneyP1, 170, 50);
            g.drawString(moneyP2, 175, 75);
                
                
            Thread.sleep(30);
        }

        //dispose frame when game is done
        frame.dispose();
    }


    /*************************************************
     * Constructor to create a frame
     *************************************************/
    static private JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1008, 815);
        frame.setVisible(true);
        return frame;
    }
}