import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**********************************************************************
 * GameState class that carries out game play logic.
 *
 * @author Kate Ottenwess, Kira B, Abby Svec
 * @version Winter 2023
 **********************************************************************/
public class GameState implements MouseListener, ActionListener {

    /* Array of the players in the game */
    private static ArrayList<Player> players;

    /* Dice object used to find dice values */
    private Dice dice;
    
    /* boolean to indicate if the state of the game has changed or not */
    private boolean stateChanged;

    /* boolean to indicate if game is over or not */
    private boolean gameOver;

    /* JFrame that is returned if roll results in a pop up window */
    private JFrame returnFrame;

    /* Button for player to choose option yes */
    private JButton yes;

    /* Button for player to choose option no */
    private JButton no;

    /* int value of x coordinate */
    private int x;

    /* int value of y coordinate */
    private int y;

    /* Player object to hold the current player of turn */
    private static Player currentPlayer;

    /* Player object to hold player 1's data */
    private Player player1;

    /* Player object to hold player 2's data */
    private Player player2;

    /* value that holds value of dice one rolled */
    private int dice1;

    /* value that holds value of dice two rolled */
    private int dice2;

    /* Property object to hold property being used in turn */
    private static Property prop;

    // Bottom of board spaces
    /* Point object that holds coordinates of Pass go 1 */
    Point passGo1 = new Point(945, 768);

    /* Point object that holds coordinates of Pass go 2 */
    Point passGo2 = new Point(945, 778);

    /* Point object that holds coordinates of Pass go 3 */
    Point passGo3 = new Point(955, 768);

    /* Point object that holds coordinates of Pass go 4 */
    Point passGo4 = new Point(955, 778);

    /* Point object that holds coordinates of Rodneys House */
    Point rodneysHouse = new Point(808, 766);

    /* Point object that holds coordinates of community chest space 1 */
    Point cc1 = new Point(728, 766);

    /* Point object that holds coordinates of Rockets House */
    Point rocketsHouse = new Point(652, 766);

    /* Point object that holds coordinates of income tax space */
    Point incomeTax = new Point(573, 766);

    /* Point object that holds coordinates of Reading Railroad */
    Point readingRailroad = new Point(493, 766);

    /* Point object that holds coordinates of Melbas House */
    Point melbasHouse = new Point(259, 766);

    /* Point object that holds coordinates of chance card space 1 */
    Point chance1 = new Point(334, 766);

    /* Point object that holds coordinates of Marinas House */
    Point marinasHouse = new Point(257, 766);

    /* Point object that holds coordinates of Mitzis House */
    Point mitzisHouse = new Point(179, 766);

    /* Point object that holds coordinates of the Jail space */
    Point jailSpace = new Point(20, 766);

    // Left side of board spaces
    /* Point object that holds coordinates of Chrissys House */
    Point chrissysHouse = new Point(60, 652);

    /* Point object that holds coordinates of the Electric Company */
    Point electricCompany = new Point(60, 592);

    /* Point object that holds coordinates of Rosies House */
    Point rosiesHouse = new Point(60, 535);

    /* Point object that holds coordinates of Floras House */
    Point florasHouse = new Point(40, 475);

    /* Point object that holds coordinates of Pennsylvania Railroad */
    Point pennsylvaniaRailroad = new Point(60, 438);

    /* Point object that holds coordinates of Cephalobots House */
    Point cephalobotsHouse = new Point(58, 380);

    /* Point object that holds coordinates of Community Chest space 2 */
    Point cc2 = new Point(60, 278);

    /* Point object that holds coordinates of Hopkins House */
    Point hopkinsHouse = new Point(57, 275);

    /* Point object that holds coordinates of Bones House */
    Point bonesHouse = new Point(56, 218);

    /* Point object that holds coordinates of free docking space */
    Point freeDocking = new Point(73, 138);

    // Top of board spaces
    /* Point object that holds coordinates of Octavins House */
    Point octaviansHouse = new Point(181, 120);

    /* Point object that holds coordinates of chance 2 space */
    Point chance2 = new Point(257, 120);

    /* Point object that holds coordinates of Fangs House */
    Point fangsHouse = new Point(336, 120);

    /* Point object that holds coordinates of Kabukis House */
    Point kabukisHouse = new Point(413, 120);

    /* Point object that holds coordinates of B.O. Railroad */
    Point boRailroad = new Point(493, 120);

    /* Point object that holds coordinates of Stitches House */
    Point stitchesHouse = new Point(574, 120);

    /* Point object that holds coordinates of Shinos House */
    Point shinosHouse = new Point(651, 120);

    /* Point object that holds coordinates of Water Works */
    Point waterWorks = new Point(728, 120);

    /* Point object that holds coordinates of Bobs House */
    Point bobsHouse = new Point(808, 120);

    // Right side of board spaces
    /* Point object that holds coordinates of go to jail space */
    Point goToJail = new Point(945, 143);

    /* Point object that holds coordinates of Judys House */
    Point judysHouse = new Point(945, 215);

    /* Point object that holds coordinates of Dianas House */
    Point dianasHouse = new Point(945, 279);

    /* Point object that holds coordinates of Comunity Chest space 3 */
    Point cc3 = new Point(945, 330);

    /* Point object that holds coordinates of Francines House */
    Point francinesHouse = new Point(945, 380);

    /* Point object that holds coordinates of Short Line Railroad */
    Point shortLine = new Point(945, 435);

    /* Point object that holds coordinates of chance space 3 */
    Point chance3 = new Point(945, 490);

    /* Point object that holds coordinates of Marshalls House */
    Point marshallsHouse = new Point(945, 540);

    /* Point object that holds coordinates of luxury tax space */
    Point luxuryTax = new Point(945, 590);

    /* Point object that holds coordinates of Raymonds House */
    Point raymondsHouse = new Point(945, 640);

    // misc buttons
    /* Point object that holds coordinates of roll dice button */
    Point rollDice = new Point(770, 245);

    /* Point object that holds coordinates of the properties button */
    Point properties = new Point(450, 20);

    /* Point object that holds coordinates of the cards button */
    Point cards = new Point(900, 20);

    /* Point array that holds the point values of all of the buttons */
    Point[] spacesArray = { passGo1, rodneysHouse, cc1, rocketsHouse, incomeTax, readingRailroad, melbasHouse,
            chance1, marinasHouse, mitzisHouse, jailSpace, chrissysHouse, electricCompany, rosiesHouse, florasHouse,
            pennsylvaniaRailroad, cephalobotsHouse, cc2, hopkinsHouse, bonesHouse, freeDocking, octaviansHouse, chance2,
            fangsHouse, kabukisHouse, boRailroad, stitchesHouse, shinosHouse, waterWorks, bobsHouse, goToJail,
            judysHouse,
            dianasHouse, cc3, francinesHouse, shortLine, chance3, marshallsHouse, luxuryTax, raymondsHouse 
    };

    /* Property array that holds all of the properties */
    public static ArrayList<Property> props = new ArrayList<Property>();

    /* Property object for Rodney */
    Property rodney = new Property("Rodney's House", 1, 60, 2, 30, "brown", 10);

    /* Property object for Rocket */
    Property rocket = new Property("Rocket's House", 3, 60, 4, 30, "brown", 20);

    /* Property object for Melba */
    Property melba = new Property("Melba's House", 6, 100, 6, 50, "light blue", 30);

    /* Property object for Marina */
    Property marina = new Property("Marina's House", 8, 100, 6, 50, "light blue", 30);

    /* Property object for Mitzi */
    Property mitzi = new Property("Mitzi's House", 9, 120, 8, 60, "light blue", 40);
    
    /* Property object for Flora */
    Property flora = new Property("Flora's House", 11, 140, 10, 70, "pink", 50);
    
    /* Property object for Rosie */
    Property rosie = new Property("Rosie's House", 13, 140, 10, 70, "pink", 50);
   
    /* Property object for Chrissy */
    Property chrissy = new Property("Chrissy's House", 14, 160, 12, 80, "pink", 60);
    
    /* Property object for Bones */
    Property bones = new Property("Bones House", 16, 180, 14, 90, "orange", 70);
    
    /* Property object for Cephalobot */
    Property cephalobot = new Property("Cephalobot's House", 18, 180, 14, 90, "orange", 70);
    
    /* Property object for Hopkins */
    Property hopkins = new Property("Hopkin's House", 19, 200, 16, 100, "orange", 80);
    
    /* Property object for Octavin */
    Property octavin = new Property("Octavin's House", 21, 220, 18, 110, "red", 90);
    
    /* Property object for Fang */
    Property fang = new Property("Fang's House", 23, 220, 18, 110, "red", 90);
    
    /* Property object for Kabuki */
    Property kabuki = new Property("Kabuki's House", 24, 240, 20, 120, "red", 100);
    
    /* Property object for Stitches */
    Property stitches = new Property("Stiches's House", 26, 260, 22, 130, "yellow", 110);
    
    /* Property object for Shino */
    Property shino = new Property("Shino's House", 27, 260, 22, 130, "yellow", 110);
    
    /* Property object for Bob */
    Property bob = new Property("Bob's House", 29, 280, 24, 140, "yellow", 120);
    
    /* Property object for Francine */
    Property francine = new Property("Francine's House", 31, 300, 26, 150, "green", 130);
    
    /* Property object for Judy */
    Property judy = new Property("Judy's House", 32, 300, 26, 150, "green", 130);

    /* Property object for Diana */
    Property diana = new Property("Diana's House", 34, 320, 28, 160, "green", 150);

    /* Property object for Marshall */
    Property marshall = new Property("Marshall's House", 37, 350, 35, 175, "dark blue", 175);

    /* Property object for Raymond */
    Property raymond = new Property("Raymond's House", 39, 400, 50, 200, "dark blue", 200);

    // -1 or NA means it is not applicible for this specific property type
    /* Property object for AbleSisters (water works) */
    Property ableSis = new Property("Able Sisters", 28, 150, -1, 75, "NA", -1);

    /* Property object for Nooks Cranny (electrical) */
    Property nooksCranny = new Property("Nooks Cranny", 12, 150, -1, 75, "NA", -1);

    // railroads
    /* Property object for Reading Railroad*/
    Property rr1 = new Property("Reading Railroad", 5, 200, 25, 100, "NA", -1);

    /* Property object for Pennslyvania Railroad */
    Property rr2 = new Property("Pennsylvania Railroad", 15, 200, 25, 100, "NA", -1);

    /* Property object for B. & O. Railroad */
    Property rr3 = new Property("B. & O. Railroad", 25, 200, 25, 100, "NA", -1);

    /* Property object for Short Line Railroad*/
    Property rr4 = new Property("Short Line", 35, 200, 35, 100, "NA", -1);

    /*******************************************************************
    * Constructor that sets the initial Game State
    ******************************************************************/
    public GameState() {

        // create dice
        dice = new Dice();

        // create buttons for buying properties
        yes = new JButton();
        no = new JButton();

        // set up players
        players = new ArrayList<>();
        player1 = new Player(1, "player1");
        player2 = new Player(2, "player2");

        player1.setCoordinates(passGo1);
        player2.setCoordinates(passGo2);

        players.add(player1);
        players.add(player2);

        player1.setBells(1500);
        player2.setBells(1500);

        currentPlayer = player1;

        // add all properties to props arrayList
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


    /******************************************************************
     * Getter to return the return frame
     * @return JFrame of pop up window
     ******************************************************************/
    public JFrame getReturnFrame() {
        return returnFrame;
    }


    /******************************************************************
     * Getter to return int value of dice 1
     * @return int value of dice 1
     ******************************************************************/
    public int getDice1() {
        return dice1;
    }


    /******************************************************************
     * Getter to return int value of dice 2
     * @return int value of dice 2
     ******************************************************************/
    public int getDice2() {
        return dice2;
    }


    /******************************************************************
     * Getter to return x coordinate of point
     * @return int value of x-coordinate
     ******************************************************************/
    public int getX() {
        return x;
    }


    /******************************************************************
     * Getter to return y coordinate of point
     * @return int value of y-coordinate
     ******************************************************************/
    public int getY() {
        return y;
    }


    /******************************************************************
     * Getter to return if game is over or not
     * @return boolean true if over false if not
     ******************************************************************/
    public boolean gameOver() {
        return gameOver;
    }


    /******************************************************************
     * Getter to return if state of game has changed or not
     * @return boolean true if state has changed false if not
     ******************************************************************/
    public boolean stateChanged() {
        return stateChanged;
    }


    /******************************************************************
     * Setter to set state changed to false
     ******************************************************************/
    public void clearChange() {
        stateChanged = false;

    }


    /******************************************************************
     * Getter to return the current player
     * @return Player current player
     ******************************************************************/
    public Player getCurrentPlayer() {
        return currentPlayer;
    }


    /******************************************************************
     * Getter to return player 1
     * @return Player player1
     ******************************************************************/
    public Player getPlayer1() {
        return player1;
    }


    /******************************************************************
     * Getter to return player 2
     * @return Player player2
     ******************************************************************/
    public Player getPlayer2() {
        return player2;
    }


    /******************************************************************
     * Getter to return the current players bells
     * @return int bells of current player
     ******************************************************************/
    public int getPlayerBells(){
        return currentPlayer.getBells();
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


    /******************************************************************
     * Method to handle a mouse event of mouse clicked
     * @param MouseEvent e
     ******************************************************************/
    @Override
    public void mouseClicked(MouseEvent e) {

        //get coordinates of mouse event
        Point code = e.getPoint();

        // if mouse events coordinates were the roll dice button
        if (code.getY() >= 240 && code.getY() <= 278 && code.getX() >= 692 && code.getX() <= 830) {

            //initialize return frame to null
            returnFrame = null;

            //roll dice and get total move
            dice1 = dice.rollDice();
            dice2 = dice.rollDice();
            int totalMove = dice1 + dice2;

            // set to boolean- true if player rolled double, stay same player
            boolean samePlayer = dice.doubleRoll(dice1, dice2);

            //if 3 doubles are rolled in a row go to jail
            if (dice.doubleJail()) {
                currentPlayer.setBoardPos(10);
                currentPlayer.setCoordinates(jailSpace);
            }
            //if 3 doubles are not rolled in a row
            else {

                //if passing go, get new position
                if (totalMove + currentPlayer.getBoardPos() > 39) {

                    // pass go add 200 bells
                    currentPlayer.setBells(currentPlayer.getBells() + 200);

                    //set board position of player
                    currentPlayer.setBoardPos(totalMove - (39 - currentPlayer.getBoardPos()) - 1);


                    currentPlayer.setCoordinates(spacesArray[currentPlayer.getBoardPos()]);

                }

                //if not passing go, get new position
                else {
                    currentPlayer.setBoardPos(currentPlayer.getBoardPos() + totalMove);

                    currentPlayer.setCoordinates(spacesArray[currentPlayer.getBoardPos()]);
                }

                // land on Go To Jail
                if (currentPlayer.getBoardPos() == 29) {
                    currentPlayer.setBoardPos(10);
                    currentPlayer.setCoordinates(jailSpace);
                    samePlayer = false;

                    // Jail.jailPlayer(currentPlayer);
                }

                // if we arent going to jail
                else {

                    for (int i = 0; i < props.size(); i++) {
                        Property tempProp = props.get(i);
                        if (currentPlayer.getBoardPos() == tempProp.getSpaceIdentifier()) {
                            prop = props.get(i);
                            break;
                        }
                    }

                    // if the player can buy
                    //TODO: this is currently say if not owned- need to fix
                    if (currentPlayer.tryBuy(currentPlayer.getBoardPos(), prop) == 1) {

                        // property already owned
                        if (prop.isOwned()) {
                            JFrame isOwnedFrame = new JFrame();
                            isOwnedFrame.setSize(200, 100);
                            JLabel owned = new JLabel("Sorry, this property is already in ownership- you owe rent!");
                            owned.setBounds(200, 10, 100, 10);
                            isOwnedFrame.add(owned);
                            returnFrame = isOwnedFrame;
                        } 
                        else {
                            
                            JPanel p = new JPanel();
                            JFrame propDisplay = new JFrame();

                            propDisplay.setSize(600, 500);
                            JLabel propLabel = new JLabel(prop.getPropertyName() /*+ "\n" + prop.getPurchaseCost()
                                    + "\nRent:" + prop.getRentCost()
                                    + "\nWith One House: " + prop.getOneHouse() + "\nRent Increase: "
                                    + prop.getRentIncreaseRate() + "\nMortgage: " + prop.getMortgage()*/);
                            JLabel propPrice = new JLabel("Cost:" + String.valueOf(prop.getPurchaseCost()) + " bells");
                            JLabel propRent = new JLabel("Rent: " + String.valueOf(prop.getRentCost()) + " bells");
                            JLabel propHouse = new JLabel("With one house: " + String.valueOf(prop.getOneHouse()) + " bells");
                            JLabel propRentInc = new JLabel("Rent Increase: " + String.valueOf(prop.getRentIncreaseRate()) + " bells");
                            JLabel propMort = new JLabel("Mortgage Price: " + String.valueOf(prop.getMortgage()) + " bells");
                            
                            propLabel.setBounds(200, 50, 100, 10);
                            propPrice.setBounds(200, 70, 100, 10);
                            propRent.setBounds(200, 90, 100, 10);
                            propHouse.setBounds(200, 110, 300, 10);
                            propRentInc.setBounds(200, 130, 300, 10);
                            propMort.setBounds(200, 150, 300, 20);
                            propDisplay.add(propLabel);
                            propDisplay.add(propPrice);
                            propDisplay.add(propRent);
                            propDisplay.add(propHouse);
                            propDisplay.add(propRentInc);
                            propDisplay.add(propMort);

                            // Ask player on frame if they wanna buy
                            JButton yes = new JButton("yes");
                            yes.setBounds(60, 400, 95, 30);
                            //JLabel yesLabel = new JLabel("yes");
                            //yesLabel.setBounds(100, 200, 50, 20);
                            //yes.add(yesLabel);
                            yes.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    currentPlayer.setBells(currentPlayer.getBells() - prop.getPurchaseCost());
                                    //TODO : set ownership
                                    propDisplay.dispose();
                                }
                            } );

                            JButton no = new JButton("no");
                            no.setBounds(80,400,95,30);
                            //JLabel noLabel = new JLabel("No");
                            //noLabel.setBounds(300, 200, 50, 20);
                            //no.add(noLabel);
                            no.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    propDisplay.dispose();
                                }
                            });


                            //add buttons
                            p.add(yes);
                            p.add(no);

                            propDisplay.add(p);
                            
                            propDisplay.invalidate();
                            propDisplay.repaint();
                            
                            returnFrame = propDisplay;

                            

                        }
                    }
                }
            }

            // if the player did not roll a double, it is no longer their turn after this
            if (!samePlayer) {
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                } else {
                    currentPlayer = player1;
                }
            }
            stateChanged = true;
        }

        // CARD BUTTON
        else if (code.getY() >= 10 && code.getY() <= 60 && code.getX() >= 803 && code.getX() <= 932) {
            JFrame cardsBtn = new JFrame();
            cardsBtn.setSize(500, 200);

            JLabel cardsLabel = new JLabel("If you have a Get Out Of Jail Free card it will show up here:");
            cardsLabel.setBounds(200, 10, 100, 10);
            cardsBtn.add(cardsLabel);

            returnFrame = cardsBtn;
            stateChanged = true;
        }

        // PROPERTIES BUTTON
        else if (code.getY() >= 10 && code.getY() <= 60 && code.getX() >= 365 && code.getX() <= 530) {
            JFrame propertiesBtn = new JFrame();
            propertiesBtn.setSize(500, 200);

            JLabel propertiesLabel = new JLabel("Properties you own will show up here:");
            // Jlabel propertiesList = new JLabel(currentPlayer.getProperties());
            propertiesLabel.setBounds(200, 10, 100, 10);
            propertiesBtn.add(propertiesLabel);

            returnFrame = propertiesBtn;
            stateChanged = true;
        }
        else {
            stateChanged = false;
        }
    }


    /******************************************************************
     * Method to handle if there is an action performed
     * @param ActionEvent e
     ******************************************************************/
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton chosen = (JButton) e.getSource();
        try {
            if (chosen == yes) {
                if (currentPlayer.equals(player2)) {
                    player2.setBells(player2.getBells() - prop.getPurchaseCost());
                    prop.setOwned(true, 2);
                } else {
                    player1.setBells(player1.getBells() - prop.getPurchaseCost());
                    prop.setOwned(true, 1);
                }
            } 
            stateChanged = true;
        }
        catch (Exception no) {
            //close the window
            SwingUtilities.getWindowAncestor((JFrame)e.getSource()).dispose();
        }
    }
}
