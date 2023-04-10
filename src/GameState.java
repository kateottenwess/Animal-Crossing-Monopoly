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
    private int money;
    private Board board;
    private Dice dice;
    private Jail jail;
    private boolean stateChanged;
    private boolean gameOver;
    private JFrame returnFrame;
    private int x;
    private int y;
    private Player currentPlayer;
    private int newBoardPos;
    private Point newCoords;
    private int dice1;
    private int dice2;
    private Property prop;

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

    public static ArrayList<Property> props = new ArrayList<Property>();

    Property rodney = new Property("Rodney's House", 1, 60, 2, 30, "brown", 10);
    

    Property rocket = new Property("Rocket's House", 3, 60, 4, 30, "brown", 20);
    
    
    Property melba = new Property("Melba's House", 6, 100, 6, 50, "light blue", 30);
    

    Property marina = new Property("Marina's House", 8, 100, 6, 50, "light blue", 30);
    //properties[3] = marina;

    Property mitzi = new Property("Mitzi's House", 9, 120, 8, 60, "light blue", 40);
    //properties[4] = mitzi;
    
    Property flora = new Property("Flora's House", 11, 140, 10, 70, "pink", 50);
    //properties[5] = flora;

    Property rosie = new Property("Rosie's House", 13, 140, 10, 70, "pink", 50);
    //properties[6] = rosie;

    Property chrissy = new Property("Chrissy's House", 14, 160, 12, 80, "pink", 60);
    //properties[7] = chrissy;
    
    Property bones = new Property("Bones House", 16, 180, 14, 90, "orange", 70);
    //properties[8] = bones;

    Property cephalobot = new Property("Cephalobot's House", 18, 180, 14, 90, "orange", 70);
    //properties[9] = cephalobot;

    Property hopkins = new Property("Hopkin's House", 19, 200, 16, 100, "orange", 80);
    //properties[10] = hopkins;
    
    Property octavin = new Property("Octavin's House", 21, 220, 18, 110, "red", 90);
    //properties[11] = octavin;

    Property fang = new Property("Fang's House", 23, 220, 18, 110, "red", 90);
    //properties[12] = fang;

    Property kabuki = new Property("Kabuki's House", 24, 240, 20, 120, "red", 100);
    //properties[13] = kabuki;
    
    Property stitches = new Property("Stiches's House", 26, 260, 22, 130, "yellow", 110);
    //properties[14] = stitches;

    Property shino = new Property("Shino's House", 27, 260, 22, 130, "yellow", 110);
    //properties[15] = shino;

    Property bob = new Property("Bob's House", 29, 280, 24, 140, "yellow", 120);
    //properties[16] = bob;
    
    Property francine = new Property("Francine's House", 31, 300, 26, 150, "green", 130);
    //properties[17] = francine;

    Property judy = new Property("Judy's House", 32, 300, 26, 150, "green", 130);


    Property diana = new Property("Diana's House", 34, 320, 28, 160, "green", 150);

    
    Property marshall = new Property("Marshall's House", 37, 350, 35, 175, "dark blue", 175);


    Property raymond = new Property("Raymond's House", 39, 400, 50, 200, "dark blue", 200);
    
    // -1 or NA means it is not applicible for this specific property type
    // waterworks
    Property ableSis = new Property("Able Sisters", 28, 150, -1, 75, "NA", -1);


    // electrical
    Property nooksCranny = new Property("Nooks Cranny", 12, 150, -1, 75, "NA", -1);


    // railroads
    Property rr1 = new Property("Railroad", 5, 200, 25, 100, "NA", -1);

    
    Property rr2 = new Property("Railroad", 15, 200, 25, 100, "NA", -1);

    
    Property rr3 = new Property("Railroad", 25, 200, 25, 100, "NA", -1);

    
    Property rr4 = new Property("Railroad", 35, 200, 35, 100, "NA", -1);

    
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
        player.setBells(1500);
        
        currentPlayer = player;

        //add all properties to props arrayList
        props.add(rodney);
        props.add(rocket);
        props.add(melba);
        props.add(marina);
        props.add(mitzi);
        props.add(flora);
        props.add(rosie);
        props.add(chrissy);
        props.add(bones);
        props.add(cephalobot);
        props.add(hopkins);
        props.add(octavin);
        props.add(fang);
        props.add(kabuki);
        props.add(stitches);
        props.add(shino);
        props.add(bob);
        props.add(francine);
        props.add(judy);
        props.add(diana);
        props.add(marshall);
        props.add(raymond);
        props.add(ableSis);
        props.add(nooksCranny);
        props.add(rr1);
        props.add(rr2);
        props.add(rr3);
        props.add(rr4);


    }

    public JFrame getReturnFrame() {
        return returnFrame;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
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
            
            dice1 = dice.rollDice();
            dice2 = dice.rollDice();
            int totalMove = dice1 + dice2;

            //check for doubles and rolling again

            dice.doubleRoll(dice1, dice2);

            if (dice.doubleJail()) {
                newBoardPos = 10;
                newCoords = jailSpace;
            } 
            
            //not going to jail slay girlie
            else {
                if (totalMove + currentPlayer.getBoardPos() > 39) {
                    newBoardPos = totalMove - (39 - currentPlayer.getBoardPos()) - 1;
                    for ( int i = 0; i < props.size(); i++){
                        Property tempProp = props.get(i);
                        if ( newBoardPos == tempProp.getSpaceIdentifier()){
                            prop = props.get(i);
                        }
                    }
                    newCoords = spacesArray[newBoardPos];
                    currentPlayer.setBoardPos(newBoardPos);
                    
                    //if the player can buy
                    //just need to figure out how to match to Property in property class
                     if (currentPlayer.tryBuy(newBoardPos) == 1) {
                        //property already owned
                        if(prop.isOwned() == true){
                            JFrame isOwnedFrame = new JFrame();
                            isOwnedFrame.setSize(200,100);
                            JLabel owned = new JLabel("Sorry, this property is already in ownership");
                            owned.setBounds(200,10,100,10);
                            isOwnedFrame.add(owned);
                            returnFrame = isOwnedFrame;
                        } else{

                            JFrame propDisplay = new JFrame();

                            propDisplay.setSize(700, 900);
                            JLabel propLabel = new JLabel(prop.getPropertyName() + "\n" + prop.getPurchaseCost() + "\nRent:" + prop.getRentCost()
                            + "\nWith One House: " + prop.getOneHouse() + "\nRent Increase: " + prop.getRentIncreaseRate() + "\nMortgage: " + prop.getMortgage());
                            propLabel.setBounds(200, 10, 100, 10);
                            propDisplay.add(propLabel);

                            //Ask player on frame if they wanna buy
                            JButton yes = new JButton();
                            yes.setSize(50, 15);
                            JLabel yesLabel = new JLabel("Yes");
                            yesLabel.setBounds(10, 10, 10, 10);
                            yes.add(yesLabel);

                            JButton no = new JButton();
                            no.setSize(50, 15);
                            JLabel noLabel = new JLabel("No");
                            noLabel.setBounds(10, 10, 10, 10);
                            no.add(noLabel);

                            propDisplay.add(yes);
                            propDisplay.add(no);
                            returnFrame = propDisplay;
                            
                            /*if(yes.isClicked()){
                                prop.setOwned(true, 1);
                                currentplayer.setBells(currentPlayer.getBells()-prop.getPurchaseCost());
                            } else {
                                //force close window
                            }*/
                            
                        }
                    //     //TODO: allow player to choose to buy or nah- display property^^
                     } else {
                    //     //cant buy lmao loser either pay rent OR its not a property and its community chest/chance/misc
                     }
                }
                else {
                    newBoardPos = currentPlayer.getBoardPos() + totalMove;
                    newCoords = spacesArray[newBoardPos];
                    currentPlayer.setBoardPos(newBoardPos);

                    // //if the player can buy
                    // if (currentPlayer.tryBuy(newBoardPos) == 1) {
                    //     //TODO: allow player to choose to buy or nah- display property (will put same stuff from above)
                    // } else {
                    //     //cant buy lmao loser either pay rent OR its not a property and its community chest/chance/misc
                    // }
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
        } 

        stateChanged = true;
    }


}
