/**********************************************************************
 * GUI for the monopoly board
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
/*import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.IOException;
import java.awt.*;
import java.io.*;
import java.imageio.*;
import java.net.*; */

import javax.imageio.ImageIO;
//import javax.lang.model.util.ElementScanner14;
//import javax.swing.JComponent;
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

public class MonopolyThatWorks implements MouseListener { 

    public static void main(String[] args) throws IOException, URISyntaxException {

        new MonopolyThatWorks();

    }

    public MonopolyThatWorks() throws IOException, URISyntaxException {
        JFrame frame = buildFrame();
        
        //Upload image of Monopoly board and resize to fit size of window
        BufferedImage board = ImageIO.read(new File(getClass().getResource("/resources/ACBoard.jpg").toURI()));
        Image newBoard = board.getScaledInstance(1000, 778, Image.SCALE_DEFAULT);

        JPanel panel = new JPanel();

        //Make spaces clickable
        frame.addMouseListener(this);

        frame.add(panel);
        frame.repaint();

        //Make the image show up on the window
        Graphics g = frame.getGraphics();
        g.drawImage(newBoard, 0, 30, null);
        
        
    }

    //method for rolling dice
   /*public void rollDice() {
        JFrame diceFrame = buildFrame();

        JLabel dice = new JLabel("Dice Roll");

        JLabel dice1 = new JLabel("Dice 1:" + Dice.rollDice1());
        JLabel dice2 = new JLabel("Dice 2:"+ Dice.rollDice2());
        

    }*/

    //Frame constructor
    private JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1500);
        frame.setVisible(true);
        return frame;
    }
    

    //Click on spaces
    @Override
    public void mouseClicked(MouseEvent e) {
    	
        int x = e.getX();
        int y = e.getY();

        //System.out.println("mouseClicked: (" + x + ", " + y + ")");

        //Left side of board
        if ((x >= 0 ) && (x <= 144)){
            //System.out.println("Sort of working"); //it is not
            if ((y >= 75) && (y <= 200)){
                System.out.println("Free Docking");
            }
            else if ((y > 200) && (y <= 252)){
                System.out.println("Bone's House");
            }
            else if ((y > 252) && (y <= 310)){
                System.out.println("Hopkin's House");
            }
            else if ((y > 310) && (y <= 358)){
                System.out.println("Community Chest");
            }
            else if ((y > 358) && (y <= 417)){
                System.out.println("Cephalobot's House");
            }
            else if ((y > 417) && (y <= 471)){
                System.out.println("Pennsylvania Railroad");
            }
            else if ((y > 471) && (y <= 518)){
                System.out.println("Flora's House");
            }
            else if ((y > 518) && (y <= 570)){
                System.out.println("Rosie's House");
            }
            else if ((y > 570) && (y <= 622)){
                System.out.println("Electric Company");
            }
            else if ((y > 622) && (y <= 690)){
                System.out.println("Chrissy's House");
            }
            else if (y > 690){
                System.out.println("Jail Space");
            }
        }

        //Middle of Board
        if ((x > 144) && (x <= 217)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("Octavia's House");
            }
            if(y > 690){
                System.out.println("Mitzi's House");
            }
        }
        if ((x > 217) && (x <= 296)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("Chance");
            }
            if(y > 690){
                System.out.println("Marina's House");
            }
        }
        if ((x > 296) && (x <= 375)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("Fang's House");
            }
            if(y > 690){
                System.out.println("Chance");
            }
        }
        if ((x > 375) && (x <= 451)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("Kabuki's House");
            }
            if(y > 690){
                System.out.println("Melba's House");
            }
        }
        if ((x > 451) && (x <= 534)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("B. & O. Railroad");
            }
            if(y > 690){
                System.out.println("Reading Railroad");
            }
        }
        if ((x > 534) && (x <= 614)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("Stitches's House");
            }
            if(y > 690){
                System.out.println("Income Tax");
            }
        }
        if ((x > 614) && (x <= 687)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("Shino's House");
            }
            if(y > 690){
                System.out.println("Rocket's House");
            }
        }
        if ((x > 687) && (x <= 769)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("Water Works");
            }
            if(y > 690){
                System.out.println("Community Chest");
            }
        }
        if ((x > 769) && (x <= 846)){
            if ((y >= 75) && (y <= 200)){
                System.out.println("Bob's House");
            }
            if(y > 690){
                System.out.println("Rodney's House");
            }
        }

        //Right Side of Board
        if (x > 846){
            if ((y >= 80) && (y <= 205)){
                System.out.println("Go To Jail");
            }
            else if ((y > 205) && (y <= 260)){
                System.out.println("Judy's House");
            }
            else if ((y > 260) && (y <= 314)){
                System.out.println("Diana's House");
            }
            else if ((y > 314) && (y <= 366)){
                System.out.println("Community Chest");
            }
            else if ((y > 366) && (y <= 422)){
                System.out.println("Francine's House");
            }
            else if ((y > 422) && (y <= 480)){
                System.out.println("Short Line");
            }
            else if ((y > 480) && (y <= 532)){
                System.out.println("Chance");
            }
            else if ((y > 532) && (y <= 586)){
                System.out.println("Marshall's House");
            }
            else if ((y > 586) && (y <= 635)){
                System.out.println("Luxury Tax");
            }
            else if ((y > 635) && (y <= 690)){
                System.out.println("Raymond's House");
            }
            else if (y > 690){
                System.out.println("PASS GO");
            }
        }

        //Bar up top
        //Properties Button
        if ((x >= 365) && (x <= 530)){
            if ((y >= 10) && (y <= 60)){
                System.out.println("Properties Button");
            }
        }
        //Cards Button
        if ((x >= 803) && (x <= 932)){
            if ((y >= 10) && (y <= 60)){
                System.out.println("Cards Button");
            }
        }

        //Roll Dice Button
        if ((x >= 680) && (x <= 830)){
            if ((y >= 235) && (y <= 265)){
                System.out.println("Roll Dice Button");
                JFrame diceFrame = new JFrame();
                //diceFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                diceFrame.setSize(500, 200);
                diceFrame.setVisible(true);

                JLabel diceLabel = new JLabel("Dice Roll");
                //Dimension size = diceLabel.getPreferredSize();
                diceLabel.setBounds(0, 0, 50, 10);

                diceFrame.add(diceLabel);

                JLabel dice1 = new JLabel("Dice 1:" + Dice.rollDice1());
                Dimension size1 = dice1.getPreferredSize();
                diceLabel.setBounds(50, 0, size1.width, size1.height);
                JLabel dice2 = new JLabel("Dice 2:"+ Dice.rollDice2());
                Dimension size2 = dice2.getPreferredSize();
                diceLabel.setBounds(80, 0, size2.width, size2.height);

                diceFrame.add(dice1);
                diceFrame.add(dice2);



            }
        }
        //Trade Button
        if ((x >= 692) && (x <= 830)){
            if ((y >= 280) && (y <= 810)){
                System.out.println("Trade Button");
            }
        }

//        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }


        //Locations for game pieces

        //Bottom of board
    Point passGo1 = new Point(945, 768);
    Point rodneysHouse = new Point(808, 768);
    Point cc1 = new Point(728, 768);
    Point rocketsHouse = new Point(651, 768);
    Point incomeTax = new Point(574, 768);
    Point readingRailroad = new Point(493, 768);
    Point melbasHouse = new Point(259, 768);
    Point chance1 = new Point(336, 768);
    Point marinasHouse = new Point(259, 768);
    Point mitzisHouse = new Point(181, 768);
    Point jailSpace = new Point(20, 768);

    //Left side of board
    Point chrissysHouse = new Point(60, 656);
    Point electricCompany = new Point(60, 596);
    Point rosiesHouse = new Point(60, 544);
    Point florasHouse = new Point(60, 495);
    Point pennsylvaniaRailroad = new Point(60, 444);
    Point cephalobotsHouse = new Point(60, 388);
    Point cc2 = new Point(60, 281);
    Point hopkinsHouse = new Point(60, 281);
    Point bonesHouse = new Point(60, 226);
    Point freeDocking = new Point(73, 138);

    //Top of board
    Point octaviasHouse = new Point(181, 120);
    Point chance2 = new Point(257, 120);
    Point fangsHouse = new Point(336, 120);
    Point kabukisHouse = new Point(413, 120);
    Point boRailroad = new Point(493, 120);
    Point stitchesHouse = new Point(574, 120);
    Point shinosHouse = new Point(651, 120);
    Point waterWorks = new Point(728, 120);
    Point bobsHouse = new Point(808, 120);

    //Right side of board
    Point goToJail = new Point(945, 143);
    Point judysHouse = new Point(945, 233);
    Point dianasHouse = new Point(945, 287);
    Point cc3 = new Point(945, 340);
    Point francinesHouse = new Point(945, 394);
    Point shortLine = new Point(945, 451);
    Point chance3 = new Point(945, 506);
    Point marshallsHouse = new Point(945, 559);
    Point luxuryTax = new Point(945, 611);
    Point raymondsHouse = new Point(945, 663);

    //array of spaces' locations
    Point spacesArray[] = {passGo1,rodneysHouse,cc1,rocketsHouse,incomeTax,readingRailroad,melbasHouse,
        chance1,marinasHouse,mitzisHouse,jailSpace,chrissysHouse,electricCompany,rosiesHouse,florasHouse,
        pennsylvaniaRailroad,cephalobotsHouse,cc2,hopkinsHouse,bonesHouse,freeDocking,octaviasHouse,chance2,
        fangsHouse,kabukisHouse,boRailroad,stitchesHouse,shinosHouse,waterWorks,bobsHouse,goToJail,judysHouse,
        dianasHouse,cc3,francinesHouse,shortLine,chance3,marshallsHouse,luxuryTax,raymondsHouse};


    
}