package mazegame;

import mazegame.FieldTiles.Door;
import mazegame.FieldTiles.Key;
import mazegame.FieldTiles.End;
import mazegame.FieldTiles.Wall;
import mazegame.FieldTiles.Field;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;

/**
 * MazeGame is used for loading the JFrame and Paint the components
 * <h1>Maze game</h1>
 * An Application that load a maze that we created. In this game you can
 * <ul>
 * <li>Move
 * <li>Collect keys
 * <li>Open doors
 * <li>Complete levels
 * <li>Restart the level
 * </ul>
 *
 * This game is made by :
 * <ul>
 * <li>Tim Wapenaar (17030439)
 * <li>Jordi verbakel (16057155)
 * <li>Noah Telussa (17068193)
 * </ul>
 *
 */
public class MazeGame extends JComponent {

    //Set the variables, the x coords, y coords
    private int dimX;
    private int dimY;

    //Create a grid to get the map that you load in
    static Grid grid = new Grid();

    //Create the player
    static Player player = new Player();
    boolean startPosition = false;

    public static JLabel label1 = new JLabel("Total Moves: " + Player.totalMoves);

    static int secondsPassed = 0;
    private static boolean timerChecker = false;

    public static JLabel label2 = new JLabel("Time: " + secondsPassed);

    Timer timer = new Timer();
    boolean timerStarted = false;
    TimerTask task = new TimerTask() {
        public void run() {
            secondsPassed++;
            label2.setText("Time: " + secondsPassed);
        }

    };

    public void start() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    /**
     * With the paint classes we can draw the rectangles on the JFrame that we
     * create in the main We assign the basic values of the grid, Set the player
     * x coordinates and y coordinates And load the level in with the method
     * LoadLevel();
     *
     * After we used the LoadLevel() Function we fill it in the arrayList what
     * includes the layout of the level. We loop trough the map with the 2 for
     * loop that we have. For each value we got in the map (Like a 0 - 9) we
     * print a different type of field
     * <ul>
     * <li>0 = Empty field </li>
     * <li>1 = Wall </li>
     * <li>2 = Player </li>
     * <li>3 = Door 1 | 100 </li>
     * <li>4 = Key 1 | 100 </li>
     * <li>5 = Door 2 | 200 </li>
     * <li>6 = Key 2 | 200 </li>
     * <li>7 = Door 3 | 300 </li>
     * <li>8 = Key 3 | 300 </li>
     * </ul>
     *
     * @param g Graphics is used for painting the square objects in the JFrame
     */
    public void paint(Graphics g) {
        super.paint(g);

        if (!timerStarted) {
            start();
            timerStarted = true;
        }
        //First we assign how big the big the board needs to be
        dimX = 30;
        dimY = 30;

        //Because the board is 60 * every time you need to multiple the position
        //Need to look in more why this is happening
        int playerXPosition = player.getXPosition() * 30;
        int playerYPosition = player.getYPosition() * 30;

        player.setPosition(playerXPosition, playerYPosition);

        //Load the level and put it in the array map
        ArrayList<int[]> map = Level.loadLevel(Level.currentLevel);

        int i = 0;
        int j = 0;
        //Print the grid out with the spider and the fly
        //Draw all the rectangles in the screen
        for (int x = dimX; x <= 315; x += 30) {
            for (int y = dimY; y <= 315; y += 30) {
                //If the bord got max;
                if (i == 10) {
                    //Reset it to the first tile
                    i = 0;
                    //And goest to the next tile
                    j++;
                }
                switch (map.get(i)[j]) {
                    case 0:
                        Field.setField(g, x, y);
                        break;
                    case 1:
                        //If there is a 1, spawn a wall
                        Wall.setWall(g, x, y);
                        break;
                    case 2:
                        if (!startPosition) {
                            g.setColor(Color.RED);
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                            startPosition = true;
                        } else {
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 3:
                        //Create a door that add the pin to the door
                        Door.setDoor(g, x, y, 100, 4);
                        if (Door.isClosed(100) != true && Bag.getBag() == 100) {
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 4:
                        //Create a door that add the pin to the door
                        if (!Bag.collected(100)) {
                            Key.setKey(g, x, y, 100, 4);
                        }

                        // when the key is picked up the color changes to white
                        if (Key.isCollected() && Bag.getBag() == 100) {
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 5:
                        Door.setDoor(g, x, y, 200, 7);
                        if (Door.isClosed(200) != true && Bag.getBag() == 200) {
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 6:
                        if (!Bag.collected(200)) {
                            Key.setKey(g, x, y, 200, 6);
                        }

                        if (Key.isCollected() && Bag.getBag() == 200) {
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 7:
                        Door.setDoor(g, x, y, 300, 8);

                        if (Door.isClosed(300) != true && Bag.getBag() == 300) {
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 8:
                        if (!Bag.collected(300)) {
                            Key.setKey(g, x, y, 300, 8);
                        }
                        if (Key.isCollected() && Bag.getBag() == 300) {
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 9:
                        End.setEnd(g, x, y);
                        break;
                    default:
                        Wall.setWall(g, x, y);
                        System.out.print("3");
                        break;
                }

                if (x == playerXPosition && y == playerYPosition) {
                    g.setColor(Color.RED);
                    g.fillRect(playerXPosition, playerYPosition, 30, 30);
                    g.drawRect(playerXPosition, playerYPosition, 30, 30);
                }

                g.setColor(Color.BLACK);
                g.drawRect(x, y, 30, 30);
                i++;
            }
        }
    }

    /**
     * Create a JFrame with buttons and a KeyListiner that listen to the arrows
     * Also the functionality of ending a level is implemented in the main
     *
     * @param a Java need String[] a to run
     */
    public static void main(String[] a) {
        //Create the GUI and set the Title "Maze game"
        JFrame window = new JFrame();
        window.setTitle("Maze game");

        //Because you want to play with the arrows you need to focus it
        window.setFocusable(true);
        window.requestFocusInWindow();

        //If you want to close the program, close it
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Now the key part!
        window.addKeyListener(new KeyAdapter() {
            //If a key is pressed
            public void keyPressed(KeyEvent e) {
                //Get the keycode of the key (like the left arrow)
                int keyCode = e.getKeyCode();
                //If the user press one of the arrow keys
                boolean checkObstacle = false;
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        for (Wall wall : Field.walls) { //Cycle through each and every wall
                            //check if the player input is going to be a wall or not
                            if (player.getXPosition() == wall.coordX && (player.getYPosition() - 1) == wall.coordY) {
                                System.out.println("You cant move");
                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                break; //break the forloop and continue on
                            } else {
                                for (Door doors : Field.doors) { //Cycle through each and every wall
                                    //check if the player input is going to be a wall or not
                                    if (player.getXPosition() == doors.coordX && (player.getYPosition() - 1) == doors.coordY) {
                                        if (Bag.getBag() == doors.getPin()) {
                                            checkObstacle = true;
                                            doors.changeLocation(doors);
                                            doors.setClosed(false);
                                            break;
                                        } else {
                                            checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                        }
                                        break; //break the forloop and continue on
                                    } else {
                                        checkObstacle = true; // set
                                    }
                                }
                            }
                        }
                        if (checkObstacle)//check if there is no obstacle
                        {
                            player.move('n'); // move the player
                        } else {
                            System.out.println("You can't move"); //you weren't able to move
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        for (Wall wall : Field.walls) {
                            if ((player.getXPosition() + 1) == wall.coordX && player.getYPosition() == wall.coordY) {
                                System.out.println("You cant move"); // plz work
                                checkObstacle = false;
                                break;
                            } else {
                                for (Door doors : Field.doors) { //Cycle through each and every wall
                                    //check if the player input is going to be a wall or not
                                    if ((player.getXPosition() + 1) == doors.coordX && player.getYPosition() == doors.coordY) {
                                        if (Bag.getBag() == doors.getPin()) {
                                            checkObstacle = true;
                                            doors.changeLocation(doors);
                                            doors.setClosed(false);
                                            break;
                                        } else {
                                            checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                        }
                                        break; //break the forloop and continue on
                                    } else {
                                        checkObstacle = true; // set
                                    }
                                }
                            }
                        }
                        if (checkObstacle) {
                            player.move('e');
                        } else {
                            System.out.println("You can't move");
                        }

                        break;
                    case KeyEvent.VK_DOWN:
                        for (Wall wall : Field.walls) {
                            if (player.getXPosition() == wall.coordX && (player.getYPosition() + 1) == wall.coordY) {
                                System.out.println("You cant move"); // plz work
                                checkObstacle = false;
                                break;
                            } else {
                                for (Door doors : Field.doors) { //Cycle through each and every wall
                                    //check if the player input is going to be a wall or not

                                    if (player.getXPosition() == doors.coordX && (player.getYPosition() + 1) == doors.coordY) {
                                        if (Bag.getBag() == doors.getPin()) {
                                            checkObstacle = true;
                                            doors.changeLocation(doors);
                                            doors.setClosed(false);
                                            break;
                                        } else {
                                            checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                        }
                                        break; //break the forloop and continue on
                                    } else {
                                        checkObstacle = true; // set
                                    }
                                }
                            }
                        }

                        if (checkObstacle) {
                            player.move('s');
                        } else {
                            System.out.println("You can't move");
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        for (Wall wall : Field.walls) {
                            if ((player.getXPosition() - 1) == wall.coordX && player.getYPosition() == wall.coordY) {
                                System.out.println("You cant move"); // plz work
                                checkObstacle = false;
                                break;
                            } else {
                                for (Door doors : Field.doors) { //Cycle through each and every wall
                                    //check if the player input is going to be a wall or not
                                    if ((player.getXPosition() - 1) == doors.coordX && player.getYPosition() == doors.coordY) {
                                        if (Bag.getBag() == doors.getPin()) {
                                            checkObstacle = true;
                                            doors.changeLocation(doors);
                                            doors.setClosed(false);
                                            break;
                                        } else {
                                            checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                        }
                                        break; //break the forloop and continue on
                                    } else {
                                        checkObstacle = true; // set
                                    }
                                }
                            }
                        }

                        if (checkObstacle) {
                            player.move('w');
                        } else {
                            System.out.println("You can't move");
                        }
                        break;
                }
                //Check if the player is at the end location
                if (player.getXPosition() == Field.endLocation[0] && player.getYPosition() == Field.endLocation[1]) {
                    //If the player beats 3 levels, close the game
                    if (Level.currentLevel == 3) {
                        JOptionPane.showMessageDialog(null, "You complete the game!");
                        window.setVisible(false);
                        window.dispose();
                    } else {
                        //Level finished +1
                        Level.currentLevel++;
                        Player.totalMoves = 0; // set the total moves back to 0
                        label1.setText("Total Moves: " + Player.totalMoves); //rewrite the text to the total moves
                        label2.setHorizontalTextPosition(0);
                        label2.setVerticalTextPosition(0);
                        Bag.alreadyCollected.clear();
                        Bag.bag = 0;

                        for (Key key : Field.keys) {
                            key.setCollected(false);
                        }
                        for (Door door : Field.doors) {
                            door.setClosed(true);
                        }
                    }

                    Level.loadLevel(Level.currentLevel);

                    //Set the player to x = 0 and y = 0 coords
                    Player.setPositionOneTime = 0;
                    Player.setPosition(0, 0);
                }

                for (Key key : Field.keys) {
                    if (player.getXPosition() == key.coordX && player.getYPosition() == key.coordY) {
                        Bag.addKey(key);
                        key.setCollected(true);
                        Key.movePosition(key);
                    }
                }
                //Repaint the frame
                window.repaint();
            }

        });
        //Menu to restart the game
        //Create the button
        JButton button = new JButton("Restart");
        button.addActionListener(new ActionListener() {
            //Override the button click function
            @Override
            public void actionPerformed(ActionEvent e) {
                Level.restart(window);
                label1.setText("Total Moves: " + Player.totalMoves); //rewrite the total moves to the screen

                window.setFocusable(true);
                window.requestFocusInWindow();
            }
        });

        window.add(button, BorderLayout.SOUTH);
        //Set how big the program needs to be
        //For looks i got a width of 360 and 390
        window.setBounds(0, 0, 360, 390);

        //After we set the width and height
        //Center it to the middle of your screen
        //Searched it on stackoverflow how to do this
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        //Add the MazeGame() and set the window to visible to show it
        window.getContentPane().add(new MazeGame());
        window.setVisible(true);

        JPanel panel = new JPanel();
        label1.setHorizontalTextPosition(0);
        label1.setVerticalTextPosition(0);
        panel.add(label1);
        panel.add(label2);
        window.add(panel);
    }

}
