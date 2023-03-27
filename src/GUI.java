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
 
 public class GUI implements MouseListener { 
 
     BufferedImage piece1;
     BufferedImage board;
     BufferedImage dice1Buffer;
     BufferedImage dice2Buffer;
     Image p1Label;
     Image newBoard;
     Image dice1Img;
     Image dice2Img;
     GameState gameState;
     Player player;
     JFrame frame;
 
     public GUI() throws IOException, URISyntaxException {
         player = new Player(1, "Player1");
         frame = buildFrame();
         frame.setVisible(true);
         
         //Upload image of Monopoly board and resize to fit size of window
         board = ImageIO.read(new File(getClass().getResource("/resources/ACBoard.jpg").toURI()));
         newBoard = board.getScaledInstance(1000, 778, Image.SCALE_SMOOTH);
 
         //Upload immage of piece 1
         piece1 = ImageIO.read(new File(getClass().getResource("/resources/Piece1ACMon.png").toURI()));
         p1Label = piece1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
 
         //upload image of dice 1
         dice1Buffer = ImageIO.read(new File(getClass().getResource("/resources/Dice1.png").toURI()));
         dice1Img = dice1Buffer.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
 
          //upload image of dice 2
          dice2Buffer = ImageIO.read(new File(getClass().getResource("/resources/Dice2.png").toURI()));
          dice2Img = dice2Buffer.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        JPanel panel = new JPanel();

        //Make spaces clickable
        frame.addMouseListener(this);

        frame.add(panel);
        frame.repaint();
        //frame.add(p1Label);

        //Make the image show up on the window
        Graphics g = frame.getGraphics();
        g.drawImage(newBoard, 0, 30, null);
        g.drawImage(p1Label, 930, 740, null);
        
        
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
    public final void mouseClicked(final MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        // System.out.println("mouseClicked: (" + x + ", " + y + ")");

        // Left side of board
        if ((x >= 0) && (x <= 144)) {
            // System.out.println("Sort of working"); //it is not
            if ((y >= 75) && (y <= 200)) {
                JFrame freeDocking = new JFrame();
                freeDocking.setSize(500, 200);
                freeDocking.setVisible(true);
                JLabel freeDockingLabel = new JLabel("Free Docking");
                freeDockingLabel.setBounds(200, 10, 100, 10);
                freeDocking.add(freeDockingLabel);
            } else if ((y > 200) && (y <= 252)) {
                JFrame bonesHouse = new JFrame();
                bonesHouse.setSize(500, 200);
                bonesHouse.setVisible(true);
                JLabel bonesHouseLabel = new JLabel("Bones House");
                bonesHouseLabel.setBounds(200, 10, 100, 10);
                bonesHouse.add(bonesHouseLabel);
            } else if ((y > 252) && (y <= 310)) {
                JFrame hopkinsHouse = new JFrame();
                hopkinsHouse.setSize(500, 200);
                hopkinsHouse.setVisible(true);
                JLabel hopkinsHouseLabel = new JLabel("Hopkin's House");
                hopkinsHouseLabel.setBounds(200, 10, 100, 10);
                hopkinsHouse.add(hopkinsHouseLabel);
            } else if ((y > 310) && (y <= 358)) {
                JFrame cc2 = new JFrame();
                cc2.setSize(500, 200);
                cc2.setVisible(true);
                JLabel cc2Label = new JLabel("Community Chest");
                cc2Label.setBounds(200, 10, 100, 10);
                cc2.add(cc2Label);
            } else if ((y > 358) && (y <= 417)) {
                JFrame cephalobotsHouse = new JFrame();
                cephalobotsHouse.setSize(500, 200);
                cephalobotsHouse.setVisible(true);
                JLabel cephalobotsHouseLabel = new JLabel("Cephalobot's House");
                cephalobotsHouseLabel.setBounds(200, 10, 100, 10);
                cephalobotsHouse.add(cephalobotsHouseLabel);
            } else if ((y > 417) && (y <= 471)) {
                JFrame pennsylvalnia = new JFrame();
                pennsylvalnia.setSize(500, 200);
                pennsylvalnia.setVisible(true);
                JLabel pennsylvaniaLabel = new JLabel("Pennsylvania Railroad");
                pennsylvaniaLabel.setBounds(200, 10, 100, 10);
                pennsylvalnia.add(pennsylvaniaLabel);
            } else if ((y > 471) && (y <= 518)) {
                JFrame florasHouse = new JFrame();
                florasHouse.setSize(500, 200);
                florasHouse.setVisible(true);
                JLabel florasHouseLabel = new JLabel("Flora's House");
                florasHouseLabel.setBounds(200, 10, 100, 10);
                florasHouse.add(florasHouseLabel);
            } else if ((y > 518) && (y <= 570)) {
                JFrame rosiesHouse = new JFrame();
                rosiesHouse.setSize(500, 200);
                rosiesHouse.setVisible(true);
                JLabel rosiesHouseLabel = new JLabel("Rosie's House");
                rosiesHouseLabel.setBounds(200, 10, 100, 10);
                rosiesHouse.add(rosiesHouseLabel);
            } else if ((y > 570) && (y <= 622)) {
                JFrame electric = new JFrame();
                electric.setSize(500, 200);
                electric.setVisible(true);
                JLabel electricLabel = new JLabel("Electric Company");
                electricLabel.setBounds(200, 10, 100, 10);
                electric.add(electricLabel);
            } else if ((y > 622) && (y <= 690)) {
                JFrame chrissysHouse = new JFrame();
                chrissysHouse.setSize(500, 200);
                chrissysHouse.setVisible(true);
                JLabel chrissysHouseLabel = new JLabel("Chrissy's House");
                chrissysHouseLabel.setBounds(200, 10, 100, 10);
                chrissysHouse.add(chrissysHouseLabel);
            } else if (y > 690) {
                JFrame jail = new JFrame();
                jail.setSize(500, 200);
                jail.setVisible(true);
                JLabel jailLabel = new JLabel("Jail");
                jailLabel.setBounds(200, 10, 100, 10);
                jail.add(jailLabel);
            }
        }

        // Middle of Board
        if ((x > 144) && (x <= 217)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame octaviasHouse = new JFrame();
                octaviasHouse.setSize(500, 200);
                octaviasHouse.setVisible(true);
                JLabel octaviasHouseLabel = new JLabel("Octavia's House");
                octaviasHouseLabel.setBounds(200, 10, 100, 10);
                octaviasHouse.add(octaviasHouseLabel);
            }
            if (y > 690) {
                JFrame mitzisHouse = new JFrame();
                mitzisHouse.setSize(500, 200);
                mitzisHouse.setVisible(true);
                JLabel mitzisHouseLabel = new JLabel("Mitzi's House");
                mitzisHouseLabel.setBounds(200, 10, 100, 10);
                mitzisHouse.add(mitzisHouseLabel);
            }
        }
        if ((x > 217) && (x <= 296)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame chance2 = new JFrame();
                chance2.setSize(500, 200);
                chance2.setVisible(true);
                JLabel chance2Label = new JLabel("Chance");
                chance2Label.setBounds(200, 10, 100, 10);
                chance2.add(chance2Label);
            }
            if (y > 690) {
                JFrame marinasHouse = new JFrame();
                marinasHouse.setSize(500, 200);
                marinasHouse.setVisible(true);
                JLabel marinasHouseLabel = new JLabel("Marina's House");
                marinasHouseLabel.setBounds(200, 10, 100, 10);
                marinasHouse.add(marinasHouseLabel);
            }
        }
        if ((x > 296) && (x <= 375)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame fangsHouse = new JFrame();
                fangsHouse.setSize(500, 200);
                fangsHouse.setVisible(true);
                JLabel fangsHouseLabel = new JLabel("Fang's House");
                fangsHouseLabel.setBounds(200, 10, 100, 10);
                fangsHouse.add(fangsHouseLabel);
            }
            if (y > 690) {
                JFrame chance1 = new JFrame();
                chance1.setSize(500, 200);
                chance1.setVisible(true);
                JLabel chance1Label = new JLabel("Chance");
                chance1Label.setBounds(200, 10, 100, 10);
                chance1.add(chance1Label);
            }
        }
        if ((x > 375) && (x <= 451)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame kabukisHouse = new JFrame();
                kabukisHouse.setSize(500, 200);
                kabukisHouse.setVisible(true);
                JLabel kabukisHouseLabel = new JLabel("Kabuki's House");
                kabukisHouseLabel.setBounds(200, 10, 100, 10);
                kabukisHouse.add(kabukisHouseLabel);
            }
            if (y > 690) {
                JFrame melbasHouse = new JFrame();
                melbasHouse.setSize(500, 200);
                melbasHouse.setVisible(true);
                JLabel melbasHouseLabel = new JLabel("Melba's House");
                melbasHouseLabel.setBounds(200, 10, 100, 10);
                melbasHouse.add(melbasHouseLabel);
            }
        }
        if ((x > 451) && (x <= 534)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame borr = new JFrame();
                borr.setSize(500, 200);
                borr.setVisible(true);
                JLabel borrLabel = new JLabel("B. & O. Railroad");
                borrLabel.setBounds(200, 10, 100, 10);
                borr.add(borrLabel);
            }
            if (y > 690) {
                JFrame rr = new JFrame();
                rr.setSize(500, 200);
                rr.setVisible(true);
                JLabel rrLabel = new JLabel("Reading Railroad");
                rrLabel.setBounds(200, 10, 100, 10);
                rr.add(rrLabel);
            }
        }
        if ((x > 534) && (x <= 614)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame stitchesHouse = new JFrame();
                stitchesHouse.setSize(500, 200);
                stitchesHouse.setVisible(true);
                JLabel stitchesHouseLabel = new JLabel("Stitches' House");
                stitchesHouseLabel.setBounds(200, 10, 100, 10);
                stitchesHouse.add(stitchesHouseLabel);
            }
            if (y > 690) {
                JFrame incomeTax = new JFrame();
                incomeTax.setSize(500, 200);
                incomeTax.setVisible(true);
                JLabel incomeTaxLabel = new JLabel("Income Tax");
                incomeTaxLabel.setBounds(200, 10, 100, 10);
                incomeTax.add(incomeTaxLabel);
            }
        }
        if ((x > 614) && (x <= 687)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame shinosHouse = new JFrame();
                shinosHouse.setSize(500, 200);
                shinosHouse.setVisible(true);
                JLabel shinosHouseLabel = new JLabel("Shino's House");
                shinosHouseLabel.setBounds(200, 10, 100, 10);
                shinosHouse.add(shinosHouseLabel);
            }
            if (y > 690) {
                JFrame rocketsHouse = new JFrame();
                rocketsHouse.setSize(500, 200);
                rocketsHouse.setVisible(true);
                JLabel rocketsHouseLabel = new JLabel("Rocket's House");
                rocketsHouseLabel.setBounds(200, 10, 100, 10);
                rocketsHouse.add(rocketsHouseLabel);
            }
        }
        if ((x > 687) && (x <= 769)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame ww = new JFrame();
                ww.setSize(500, 200);
                ww.setVisible(true);
                JLabel wwLabel = new JLabel("Water Works");
                wwLabel.setBounds(200, 10, 100, 10);
                ww.add(wwLabel);
            }
            if (y > 690) {
                JFrame cc1 = new JFrame();
                cc1.setSize(500, 200);
                cc1.setVisible(true);
                JLabel cc1Label = new JLabel("Community Chest");
                cc1Label.setBounds(200, 10, 100, 10);
                cc1.add(cc1Label);
            }
        }
        if ((x > 769) && (x <= 846)) {
            if ((y >= 75) && (y <= 200)) {
                JFrame bobsHouse = new JFrame();
                bobsHouse.setSize(500, 200);
                bobsHouse.setVisible(true);
                JLabel bobsHouseLabel = new JLabel("Bob's House");
                bobsHouseLabel.setBounds(200, 10, 100, 10);
                bobsHouse.add(bobsHouseLabel);
            }
            if (y > 690) {
                JFrame rodneysHouse = new JFrame();
                rodneysHouse.setSize(500, 200);
                rodneysHouse.setVisible(true);
                JLabel rodneysHouseLabel = new JLabel("Rodney's House");
                rodneysHouseLabel.setBounds(200, 10, 100, 10);
                rodneysHouse.add(rodneysHouseLabel);
            }
        }

        // Right Side of Board
        if (x > 846) {
            if ((y >= 80) && (y <= 205)) {
                JFrame goToJail = new JFrame();
                goToJail.setSize(500, 200);
                goToJail.setVisible(true);
                JLabel goToJailLabel = new JLabel("Go To Jail");
                goToJailLabel.setBounds(200, 10, 100, 10);
                goToJail.add(goToJailLabel);
            } else if ((y > 205) && (y <= 260)) {
                JFrame judysHouse = new JFrame();
                judysHouse.setSize(500, 200);
                judysHouse.setVisible(true);
                JLabel judysHouseLabel = new JLabel("Judy's House");
                judysHouseLabel.setBounds(200, 10, 100, 10);
                judysHouse.add(judysHouseLabel);
            } else if ((y > 260) && (y <= 314)) {
                JFrame dianasHouse = new JFrame();
                dianasHouse.setSize(500, 200);
                dianasHouse.setVisible(true);
                JLabel dianasHouseLabel = new JLabel("Diana's House");
                dianasHouseLabel.setBounds(200, 10, 100, 10);
                dianasHouse.add(dianasHouseLabel);
            } else if ((y > 314) && (y <= 366)) {
                JFrame cc3 = new JFrame();
                cc3.setSize(500, 200);
                cc3.setVisible(true);
                JLabel cc3Label = new JLabel("Community Chest");
                cc3Label.setBounds(200, 10, 100, 10);
                cc3.add(cc3Label);
            } else if ((y > 366) && (y <= 422)) {
                JFrame francinesHouse = new JFrame();
                francinesHouse.setSize(500, 200);
                francinesHouse.setVisible(true);
                JLabel francinesHouseLabel = new JLabel("Francine's House");
                francinesHouseLabel.setBounds(200, 10, 100, 10);
                francinesHouse.add(francinesHouseLabel);
            } else if ((y > 422) && (y <= 480)) {
                JFrame shortLine = new JFrame();
                shortLine.setSize(500, 200);
                shortLine.setVisible(true);
                JLabel shortLineLabel = new JLabel("Short Line");
                shortLineLabel.setBounds(200, 10, 100, 10);
                shortLine.add(shortLineLabel);
            } else if ((y > 480) && (y <= 532)) {
                JFrame chance3 = new JFrame();
                chance3.setSize(500, 200);
                chance3.setVisible(true);
                JLabel chance3Label = new JLabel("Chance");
                chance3Label.setBounds(200, 10, 100, 10);
                chance3.add(chance3Label);
            } else if ((y > 532) && (y <= 586)) {
                JFrame marshallsHouse = new JFrame();
                marshallsHouse.setSize(500, 200);
                marshallsHouse.setVisible(true);
                JLabel marshallsHouseLabel = new JLabel("Marshall's House");
                marshallsHouseLabel.setBounds(200, 10, 100, 10);
                marshallsHouse.add(marshallsHouseLabel);
            } else if ((y > 586) && (y <= 635)) {
                JFrame luxury = new JFrame();
                luxury.setSize(500, 200);
                luxury.setVisible(true);
                JLabel luxuryLabel = new JLabel("Luxury Tax");
                luxuryLabel.setBounds(200, 10, 100, 10);
                luxury.add(luxuryLabel);
            } else if ((y > 635) && (y <= 690)) {
                JFrame raymondsHouse = new JFrame();
                raymondsHouse.setSize(500, 200);
                raymondsHouse.setVisible(true);
                JLabel raymondsHouseLabel = new JLabel("Raymond's House");
                raymondsHouseLabel.setBounds(200, 10, 100, 10);
                raymondsHouse.add(raymondsHouseLabel);
            } else if (y > 690) {
                JFrame passGo = new JFrame();
                passGo.setSize(500, 200);
                passGo.setVisible(true);
                JLabel passGoLabel = new JLabel("Pass Go");
                passGoLabel.setBounds(200, 10, 100, 10);
                passGo.add(passGoLabel);
            }
        }

        // Bar up top
        // Properties Button
        if ((x >= 365) && (x <= 530)) {
            if ((y >= 10) && (y <= 60)) {
                JFrame propertiesBtn = new JFrame();
                propertiesBtn.setSize(500, 200);
                propertiesBtn.setVisible(true);
                JLabel propertiesLabel = new JLabel("Properties you own will show up here:");
                propertiesLabel.setBounds(200, 10, 100, 10);
                propertiesBtn.add(propertiesLabel);
            }
        }
        // Cards Button
        if ((x >= 803) && (x <= 932)) {
            if ((y >= 10) && (y <= 60)) {
                JFrame cardsBtn = new JFrame();
                cardsBtn.setSize(500, 200);
                cardsBtn.setVisible(true);
                JLabel cardsLabel = new JLabel("If you have a Get Out Of Jail Free card it will show up here:");
                cardsLabel.setBounds(200, 10, 100, 10);
                cardsBtn.add(cardsLabel);
            }
        }

        // Roll Dice Button
        if ((x >= 680) && (x <= 830)) {
            if ((y >= 235) && (y <= 265)) {

                // Create new frame to show dice results
                JFrame diceFrame = new JFrame();
                diceFrame.setSize(500, 200);
                diceFrame.setVisible(true);

                JLabel diceLabel = new JLabel("Dice");
                // Dimension size = diceLabel.getPreferredSize();
                diceLabel.setBounds(200, 10, 100, 10);

                diceFrame.add(diceLabel);

                Dice d = new Dice();

                int dice1Val = d.rollDice1();
                int dice2Val = d.rollDice2();

                // Using rollDice() from Dice class and add to frame
                JLabel dice1 = new JLabel("Dice 1: " + dice1Val);
                Dimension size1 = dice1.getPreferredSize();
                dice1.setBounds(200, 30, size1.width, size1.height);
                JLabel dice2 = new JLabel("Dice 2: " + dice2Val);
                Dimension size2 = dice2.getPreferredSize();
                dice2.setBounds(100, 30, size2.width, size2.height);

                diceFrame.add(dice1);
                diceFrame.add(dice2);

                // Get piece to move that many spaces
                // int totalMove = dice1Val + dice2Val;
                // Point newSpace = spacesArray[totalMove-1];
                // g.drawImage(p1Label, (int)raymondsHouse.getX(),(int)raymondsHouse.getY(),
                // null);
                // piece1.setLocation(newSpace.getX(), newSpace.getY());
            }
        }
        // Trade Button
        if ((x >= 692) && (x <= 830)) {
            if ((y >= 280) && (y <= 810)) {
                JFrame tradeBtn = new JFrame();
                tradeBtn.setSize(500, 200);
                tradeBtn.setVisible(true);
                JLabel tradeLabel = new JLabel("Trade Button");
                tradeLabel.setBounds(200, 10, 100, 10);
                tradeBtn.add(tradeLabel);
            }
        }

        // throw new UnsupportedOperationException("Unimplemented method
        // 'mouseClicked'");

    }

    /********************************** NEW*************************************************/
    public void movePiece(int newPosition) {
        // Move the player's piece to the new position
        Graphics g = frame.getGraphics();
        g.clearRect(930, 740, 50, 50);
        g.drawImage(p1Label, newPosition, 740, null);
        frame.repaint();
    }

    @Override
    public void mousePressed(final MouseEvent e) {
    }

    @Override
    public void mouseReleased(final MouseEvent e) {
    }

    @Override
    public void mouseEntered(final MouseEvent e) {
    }

    @Override
    public void mouseExited(final MouseEvent e) {
    }

    // Locations for game pieces

    // Bottom of board
    Point passGo1 = new Point(945, 768);
    Point passGo2 = new Point(945, 778);
    Point passGo3 = new Point(955, 768);
    Point passGo4 = new Point(955, 778);
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

    // Left side of board
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

    // Top of board
    Point octaviasHouse = new Point(181, 120);
    Point chance2 = new Point(257, 120);
    Point fangsHouse = new Point(336, 120);
    Point kabukisHouse = new Point(413, 120);
    Point boRailroad = new Point(493, 120);
    Point stitchesHouse = new Point(574, 120);
    Point shinosHouse = new Point(651, 120);
    Point waterWorks = new Point(728, 120);
    Point bobsHouse = new Point(808, 120);

    // Right side of board
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

    // array of spaces' locations
    Point[] spacesArray = { passGo1, rodneysHouse, cc1, rocketsHouse, incomeTax, readingRailroad, melbasHouse,
        chance1,marinasHouse,mitzisHouse,jailSpace,chrissysHouse,electricCompany,rosiesHouse,florasHouse,
        pennsylvaniaRailroad,cephalobotsHouse,cc2,hopkinsHouse,bonesHouse,freeDocking,octaviasHouse,chance2,
        fangsHouse,kabukisHouse,boRailroad,stitchesHouse,shinosHouse,waterWorks,bobsHouse,goToJail,judysHouse,
        dianasHouse,cc3,francinesHouse,shortLine,chance3,marshallsHouse,luxuryTax,raymondsHouse};

        
    
}