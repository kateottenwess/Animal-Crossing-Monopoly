import javax.swing.*;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.JButton;

public class GameState implements MouseListener {
    private int numPlayers;
    private static ArrayList<Player> players;
    private Board board;
    private static Dice dice;
    private Jail jail;
    private boolean stateChanged;
    private boolean gameOver;
    private JFrame returnFrame;
    private int x;
    private int y;
    private Player currentPlayer;
    private int newBoardPos;
    private Point newCoords;

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
    Point octaviansHouse = new Point(181, 120);
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

    // misc buttons
    Point rollDice = new Point(770, 245);
    Point properties = new Point(450, 20);
    Point cards = new Point(900, 20);
    Point trade = new Point(770, 287);

    Point[] spacesArray = { passGo1, rodneysHouse, cc1, rocketsHouse, incomeTax, readingRailroad, melbasHouse,
        chance1,marinasHouse,mitzisHouse,jailSpace,chrissysHouse,electricCompany,rosiesHouse,florasHouse,
        pennsylvaniaRailroad,cephalobotsHouse,cc2,hopkinsHouse,bonesHouse,freeDocking,octaviansHouse,chance2,
        fangsHouse,kabukisHouse,boRailroad,stitchesHouse,shinosHouse,waterWorks,bobsHouse,goToJail,judysHouse,
        dianasHouse,cc3,francinesHouse,shortLine,chance3,marshallsHouse,luxuryTax,raymondsHouse};


    public GameState(int numPlayers) {

        this.numPlayers = numPlayers;
        players = new ArrayList<>();

        for (int i = 1; i <= numPlayers; i++) {
            // String name = JOptionPane.showInputDialog("Enter name for Player " + i);
            // Player player = new Player(i, name);
            // players.add(player);
        }

        // board = new Board(); is throwing null pointer
        // TODO: figure out what to do w these bad b0is
        this.x = 0;
        this.y = 0;
        dice = new Dice();

        Player player = new Player(1, "player1");
        
        currentPlayer = player;

    }

    public JFrame getReturnFrame() {
        return returnFrame;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean gameOver() {
        return gameOver;
    }

    public boolean stateChanged() {
        return stateChanged;
    }

    public void clearChange() {
        stateChanged = false;

    }

    public int getNewBoardPos() {
        return newBoardPos;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Point getNewCoords() {
        return newCoords;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Point code = e.getPoint();

        //roll dice
        if (code.getY() >= 240 && code.getY() <= 278 && code.getX() >= 692 && code.getX() <= 830) {

            returnFrame = null;
            
            // TODO: roll them dice

            int dice1 = dice.rollDice();
            int dice2 = dice.rollDice();
            int totalMove = dice1 + dice2;

            //check for doubles and rolling again

            dice.doubleRoll(dice1, dice2);

            if (dice.doubleJail()) {
                newBoardPos = 10;
                newCoords = jailSpace;
            } else {
                if (totalMove + currentPlayer.getBoardPos() > 39) {
                    newBoardPos = totalMove - (39 - currentPlayer.getBoardPos()) - 1;
                    newCoords = spacesArray[newBoardPos];
                }
                else {
                    newBoardPos = currentPlayer.getBoardPos() + totalMove;
                    newCoords = spacesArray[newBoardPos];
                }
            }

            // Get piece to move that many spaces
            // int totalMove = dice1Val + dice2Val;
            // Point newSpace = spacesArray[totalMove-1];
            // g.drawImage(p1Label, (int)raymondsHouse.getX(),(int)raymondsHouse.getY(),
            // null);
            // piece1.setLocation(newSpace.getX(), newSpace.getY());

        } 
        //trade
        else if (code.getY() >= 280 && code.getY() <= 310 && code.getX() >= 692 && code.getX() <= 830) {

            returnFrame = null;
            // TODO: trade
            // JFrame tradeBtn = new JFrame();
            // tradeBtn.setSize(500, 200);
            // tradeBtn.setVisible(true);
            // JLabel tradeLabel = new JLabel("Trade Button");
            // tradeLabel.setBounds(200, 10, 100, 10);
            // tradeBtn.add(tradeLabel);
        } else if (code.getY() >= 10 && code.getY() <= 60 && code.getX() >= 803 && code.getX() <= 932) {
            JFrame cardsBtn = new JFrame();
            cardsBtn.setSize(500, 200);
        
            JLabel cardsLabel = new JLabel("If you have a Get Out Of Jail Free card it will show up here:");
            cardsLabel.setBounds(200, 10, 100, 10);
            cardsBtn.add(cardsLabel);

            returnFrame = cardsBtn;
        } else if (code.getY() >= 10 && code.getY() <= 60 && code.getX() >= 365 && code.getX() <= 530) {
            JFrame propertiesBtn = new JFrame();
            propertiesBtn.setSize(500, 200);
        
            JLabel propertiesLabel = new JLabel("Properties you own will show up here:");
            propertiesLabel.setBounds(200, 10, 100, 10);
            propertiesBtn.add(propertiesLabel);

            returnFrame = propertiesBtn;
        } else if (code.getY() > 690 && code.getX() > 769 && code.getX() <= 846) {
            JFrame rodneysHouse = new JFrame();
            rodneysHouse.setSize(500, 200);
        
            JLabel rodneysHouseLabel = new JLabel("Rodney's House");
            rodneysHouseLabel.setBounds(200, 10, 100, 10);
            rodneysHouse.add(rodneysHouseLabel);

            returnFrame = rodneysHouse;
        } else if (code.getY() > 790 && code.getX() > 614 && code.getX() <= 687) {
            JFrame rocketsHouse = new JFrame();
            rocketsHouse.setSize(500, 200);
          
            JLabel rocketsHouseLabel = new JLabel("Rocket's House");
            rocketsHouseLabel.setBounds(200, 10, 100, 10);
            rocketsHouse.add(rocketsHouseLabel);

            returnFrame = rocketsHouse;
        } else if (code.getY() > 690 && code.getX() > 451 && code.getX() <= 534) {
            JFrame rr = new JFrame();
            rr.setSize(500, 200);
        
            JLabel rrLabel = new JLabel("Reading Railroad");
            rrLabel.setBounds(200, 10, 100, 10);
            rr.add(rrLabel);
            
            returnFrame = rr;
        } else if (code.getY() > 690 && code.getX() > 375 && code.getX() <= 451) {
            JFrame melbasHouse = new JFrame();
            melbasHouse.setSize(500, 200);
        
            JLabel melbasHouseLabel = new JLabel("Melba's House");
            melbasHouseLabel.setBounds(200, 10, 100, 10);
            melbasHouse.add(melbasHouseLabel);

            returnFrame = melbasHouse;
        } else if (code.getY() > 690  && code.getX() > 217 && code.getX() <= 296) {
            JFrame marinasHouse = new JFrame();
            marinasHouse.setSize(500, 200);
           
            JLabel marinasHouseLabel = new JLabel("Marina's House");
            marinasHouseLabel.setBounds(200, 10, 100, 10);
            marinasHouse.add(marinasHouseLabel);

            returnFrame = marinasHouse;
        } else if (code.getY() > 690  && code.getX() > 144 && code.getX() <= 217) {
            JFrame mitzisHouse = new JFrame();
            mitzisHouse.setSize(500, 200);
            
            JLabel mitzisHouseLabel = new JLabel("Mitzi's House");
            mitzisHouseLabel.setBounds(200, 10, 100, 10);
            mitzisHouse.add(mitzisHouseLabel);

            returnFrame = mitzisHouse;
        } else if (code.getY() > 622 && code.getY() <= 690 && code.getX() >= 0 && code.getX() <= 144) {
            JFrame chrissysHouse = new JFrame();
            chrissysHouse.setSize(500, 200);
        
            JLabel chrissysHouseLabel = new JLabel("Chrissy's House");
            chrissysHouseLabel.setBounds(200, 10, 100, 10);
            chrissysHouse.add(chrissysHouseLabel);

            returnFrame = chrissysHouse;
        } else if (code.getY() > 570 && code.getY() <= 622 && code.getX() >= 0 && code.getX() <= 144) {
            JFrame electric = new JFrame();
            electric.setSize(500, 200);
            
            JLabel electricLabel = new JLabel("Electric Company");
            electricLabel.setBounds(200, 10, 100, 10);
            electric.add(electricLabel);

            returnFrame = electric;
        } else if (code.getY() > 518 && code.getY() <= 570 && code.getX() >= 0 && code.getX() <= 144) {
            JFrame rosiesHouse = new JFrame();
            rosiesHouse.setSize(500, 200);
            
            JLabel rosiesHouseLabel = new JLabel("Rosie's House");
            rosiesHouseLabel.setBounds(200, 10, 100, 10);
            rosiesHouse.add(rosiesHouseLabel);

            returnFrame = rosiesHouse;
        } else if (code.getY() > 471 && code.getY() <= 518 && code.getX() >= 0 && code.getX() <= 144) {
            JFrame florasHouse = new JFrame();
            florasHouse.setSize(500, 200);
           
            JLabel florasHouseLabel = new JLabel("Flora's House");
            florasHouseLabel.setBounds(200, 10, 100, 10);
            florasHouse.add(florasHouseLabel);

            returnFrame = florasHouse;
        } else if (code.getY() > 417 && code.getY() <= 471 && code.getX() >= 0 && code.getX() <= 144) {
            JFrame pennsylvalnia = new JFrame();
            pennsylvalnia.setSize(500, 200);
            
            JLabel pennsylvaniaLabel = new JLabel("Pennsylvania Railroad");
            pennsylvaniaLabel.setBounds(200, 10, 100, 10);
            pennsylvalnia.add(pennsylvaniaLabel);

            returnFrame = pennsylvalnia;
        } else if (code.getY() > 358 && code.getY() <= 417 && code.getX() >= 0 && code.getX() <= 144) {
            JFrame cephalobotsHouse = new JFrame();
            cephalobotsHouse.setSize(500, 200);
            
            JLabel cephalobotsHouseLabel = new JLabel("Cephalobot's House");
            cephalobotsHouseLabel.setBounds(200, 10, 100, 10);
            cephalobotsHouse.add(cephalobotsHouseLabel);

            returnFrame = cephalobotsHouse;
        } else if (code.getY() > 200 && code.getY() <= 310 && code.getX() >= 0 && code.getX() <= 144) {
            JFrame hopkinsHouse = new JFrame();
            hopkinsHouse.setSize(500, 200);
            
            JLabel hopkinsHouseLabel = new JLabel("Hopkin's House");
            hopkinsHouseLabel.setBounds(200, 10, 100, 10);
            hopkinsHouse.add(hopkinsHouseLabel);

            returnFrame = hopkinsHouse;
        } else if (code.getY() > 200 && code.getY() <= 252 && code.getX() >= 0 && code.getX() <= 144) {
            JFrame bonesHouse = new JFrame();
            bonesHouse.setSize(500, 200);
            
            JLabel bonesHouseLabel = new JLabel("Bones House");
            bonesHouseLabel.setBounds(200, 10, 100, 10);
            bonesHouse.add(bonesHouseLabel);

            returnFrame = bonesHouse;
        } else if (code.getY() >= 75 && code.getY() <= 200 && code.getX() > 144 && code.getX() <= 217) {
            JFrame octaviansHouse = new JFrame();
            octaviansHouse.setSize(500, 200);
            
            JLabel octaviansHouseLabel = new JLabel("Octavian's House");
            octaviansHouseLabel.setBounds(200, 10, 100, 10);
            octaviansHouse.add(octaviansHouseLabel);

            returnFrame = octaviansHouse;
        } else if (code.getY() >= 75 && code.getY() <= 200 && code.getX() > 296 && code.getX() <= 375) {
            JFrame fangsHouse = new JFrame();
            fangsHouse.setSize(500, 200);
            
            JLabel fangsHouseLabel = new JLabel("Fang's House");
            fangsHouseLabel.setBounds(200, 10, 100, 10);
            fangsHouse.add(fangsHouseLabel);

            returnFrame = fangsHouse;
        } else if (code.getY() >= 75 && code.getY() <= 200 && code.getX() > 375 && code.getX() <= 451) {
            JFrame kabukisHouse = new JFrame();
            kabukisHouse.setSize(500, 200);
            
            JLabel kabukisHouseLabel = new JLabel("Kabuki's House");
            kabukisHouseLabel.setBounds(200, 10, 100, 10);
            kabukisHouse.add(kabukisHouseLabel);

            returnFrame = kabukisHouse;
        } else if (code.getY() >= 75 && code.getY() <= 200 && code.getX() > 451 && code.getX() <= 534) {
            JFrame borr = new JFrame();
            borr.setSize(500, 200);
            
            JLabel borrLabel = new JLabel("B. & O. Railroad");
            borrLabel.setBounds(200, 10, 100, 10);
            borr.add(borrLabel);

            returnFrame = borr;
        } else if (code.getY() >= 75 && code.getY() <= 200 && code.getX() > 534 && code.getX() <= 614) {
            JFrame stitchesHouse = new JFrame();
            stitchesHouse.setSize(500, 200);
            
            JLabel stitchesHouseLabel = new JLabel("Stitches' House");
            stitchesHouseLabel.setBounds(200, 10, 100, 10);
            stitchesHouse.add(stitchesHouseLabel);

            returnFrame = stitchesHouse;
        } else if (code.getY() >= 75 && code.getY() <= 200 && code.getX() > 614 && code.getX() <= 687) {
            JFrame shinosHouse = new JFrame();
            shinosHouse.setSize(500, 200);
            
            JLabel shinosHouseLabel = new JLabel("Shino's House");
            shinosHouseLabel.setBounds(200, 10, 100, 10);
            shinosHouse.add(shinosHouseLabel);

            returnFrame = shinosHouse;
        } else if (code.getY() >= 75 && code.getY() <= 200 && code.getX() > 687 && code.getX() <= 769) {
            JFrame ww = new JFrame();
            ww.setSize(500, 200);
            
            JLabel wwLabel = new JLabel("Water Works");
            wwLabel.setBounds(200, 10, 100, 10);
            ww.add(wwLabel);

            returnFrame = ww;
        } else if (code.getY() >= 75 && code.getY() <= 190 && code.getX() > 769 && code.getX() <= 846) {
            JFrame bobsHouse = new JFrame();
            bobsHouse.setSize(500, 200);
            
            JLabel bobsHouseLabel = new JLabel("Bob's House");
            bobsHouseLabel.setBounds(200, 10, 100, 10);
            bobsHouse.add(bobsHouseLabel);

            returnFrame = bobsHouse;
        } else if (code.getY() >= 205 && code.getY() <= 260 && code.getX() > 846) {
            JFrame judysHouse = new JFrame();
            judysHouse.setSize(500, 200);
            
            JLabel judysHouseLabel = new JLabel("Judy's House");
            judysHouseLabel.setBounds(200, 10, 100, 10);
            judysHouse.add(judysHouseLabel);

            returnFrame = judysHouse;
        } else if (code.getY() >= 260 && code.getY() <= 314 && code.getX() > 846) {
            JFrame dianasHouse = new JFrame();
            dianasHouse.setSize(500, 200);
            
            JLabel dianasHouseLabel = new JLabel("Diana's House");
            dianasHouseLabel.setBounds(200, 10, 100, 10);
            dianasHouse.add(dianasHouseLabel);

            returnFrame = dianasHouse;
        } else if (code.getY() > 366 && code.getY() <= 422 && code.getX() > 846) {
            JFrame francinesHouse = new JFrame();
            francinesHouse.setSize(500, 200);
            
            JLabel francinesHouseLabel = new JLabel("Francine's House");
            francinesHouseLabel.setBounds(200, 10, 100, 10);
            francinesHouse.add(francinesHouseLabel);

            returnFrame = francinesHouse;
        } else if (code.getY() > 422 && code.getY() <= 480 && code.getX() > 846) {
            JFrame shortLine = new JFrame();
            shortLine.setSize(500, 200);
            
            JLabel shortLineLabel = new JLabel("Short Line");
            shortLineLabel.setBounds(200, 10, 100, 10);
            shortLine.add(shortLineLabel);

            returnFrame = shortLine;
        } else if (code.getY() > 532 && code.getY() <= 586 && code.getX() > 846) {
            JFrame marshallsHouse = new JFrame();
            marshallsHouse.setSize(500, 200);
            JLabel marshallsHouseLabel = new JLabel("Marshall's House");
            marshallsHouseLabel.setBounds(200, 10, 100, 10);
            marshallsHouse.add(marshallsHouseLabel);

            returnFrame = marshallsHouse;
        } else if (code.getY() > 635 && code.getY() <= 690 && code.getX() > 846) {
            JFrame raymondsHouse = new JFrame();
            raymondsHouse.setSize(500, 200);
            JLabel raymondsHouseLabel = new JLabel("Raymond's House");
            raymondsHouseLabel.setBounds(200, 10, 100, 10);
            raymondsHouse.add(raymondsHouseLabel);

            returnFrame = raymondsHouse;
        } 

        stateChanged = true;
    }

}
