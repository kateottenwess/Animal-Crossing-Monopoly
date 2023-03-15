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
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Graphics;
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
        BufferedImage board = ImageIO.read(new File(getClass().getResource("/resources/ACMonopolyBoard.jpg").toURI()));
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
            else if ((y > 422) && (y <= 4)){
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


    //Set up grid
    //private void setUpGrid(){}

    //ACTION EVENT
    /*@Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }*/

    
}