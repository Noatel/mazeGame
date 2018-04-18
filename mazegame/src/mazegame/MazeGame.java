package mazegame;

import mazegame.FieldTiles.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;

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
 * <li>Jordie verbakel (16057155)
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
    public boolean startPosition = false;

    public static JLabel label1 = new JLabel("Total Moves: " + player.getTotalMoves());

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
        Field[][] maze = Grid.getMaze();

        //Because you want to play with the arrows you need to focus it
        window.setFocusable(true);
        window.requestFocusInWindow();

        //If you want to close the program, close it
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Load the walls
        List<Wall> arrayWalls = Wall.returnWalls();

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
                        Field[][] maze = Grid.getMaze();
                        //System.out.println(maze[9][9]);
                        
                        player.move('n');
                        
                        /*for (Wall walls : arrayWalls) { //Cycle through each and every wall
                            //check if the player input is going to be a wall or not
                            if (player.getXPosition() == (walls.getCoordX() / 30) && (player.getYPosition() - 1) == (walls.getCoordY() / 30)) {
                                System.out.println("You cant move");
                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                break; //break the forloop and continue on
                            } else {
                                for (Door doors : Door.doors) { //Cycle through each and every wall
                                    //check if the player input is going to be a wall or not
                                    if (player.getXPosition() == (doors.getCoordX() / 30) && (player.getYPosition() - 1) == (doors.getCoordY() / 30)) {
                                        if (player.bag != null) {
                                            if (player.bag.pin == doors.getPin()) {
                                                checkObstacle = true;
                                                doors.setClosed(false);
//                                                doors.addOpenDoor();
                                                break;
                                            } else {
                                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                            }
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
                        }*/
                        break;
                    case KeyEvent.VK_RIGHT:
                        /*for (Wall walls : arrayWalls) { //Cycle through each and every wall
                            //check if the player input is going to be a wall or not
                            if ((player.getXPosition() + 1) == (walls.getCoordX() / 30) && (player.getYPosition()) == (walls.getCoordY() / 30)) {
                                System.out.println("You cant move");
                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                break; //break the forloop and continue on
                            } else {
                                for (Door doors : Door.doors) { //Cycle through each and every wall
//                                    //check if the player input is going to be a wall or not
                                    if ((player.getXPosition() + 1) == (doors.getCoordX() / 30) && player.getYPosition() == (doors.getCoordY() / 30)) {;
                                        if (player.bag != null) {
                                            if (player.bag.pin == doors.getPin()) {
                                                checkObstacle = true;
                                                doors.setClosed(false);
//                                                doors.addOpenDoor();

                                                break;
                                            } else {
                                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                            }
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
                        }*/
                        player.move('e');
                        break;
                    case KeyEvent.VK_DOWN:
                        /*for (Wall walls : arrayWalls) { //Cycle through each and every wall
                            //check if the player input is going to be a wall or not
                            if (player.getXPosition() == (walls.getCoordX() / 30) && (player.getYPosition() + 1) == (walls.getCoordY() / 30)) {
                                System.out.println("You cant move");
                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                break; //break the forloop and continue on
                            } else {
                                for (Door doors : Door.doors) { //Cycle through each and every wall
//                                    //check if the player input is going to be a wall or not
                                    if (player.getXPosition() == (doors.getCoordX() / 30) && (player.getYPosition() + 1) == (doors.getCoordY() / 30)) {
                                        if (player.bag != null) {
                                            if (player.bag.pin == doors.getPin()) {
                                                checkObstacle = true;
                                                doors.setClosed(false);
//                                                doors.addOpenDoor();
                                                break;
                                            } else {
                                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                            }
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
                        }*/
                        player.move('s');
                        break;
                    case KeyEvent.VK_LEFT:
                        /*for (Wall walls : arrayWalls) { //Cycle through each and every wall
                            //check if the player input is going to be a wall or not
                            if ((player.getXPosition() - 1) == (walls.getCoordX() / 30) && player.getYPosition() == (walls.getCoordY() / 30)) {
                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                break; //break the forloop and continue on
                            } else {
                                for (Door doors : Door.doors) { //Cycle through each and every wall
                                    //check if the player input is going to be a wall or not
                                    if ((player.getXPosition() - 1) == (doors.getCoordX() / 30) && player.getYPosition() == (doors.getCoordY() / 30)) {
                                        if (player.bag != null) {
                                            if (player.bag.pin == doors.getPin()) {
                                                checkObstacle = true;
                                                doors.setClosed(false);
//                                                doors.addOpenDoor();
                                                break;
                                            } else {
                                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                            }
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
                        }*/
                        player.move('w');
                        break;
                }
                //Repaint the frame
                window.repaint();
            }
            //Check if the player is at the end location
//                if (player.getXPosition() == Field.endLocation[0] && player.getYPosition() == Field.endLocation[1]) {
//                    //If the player beats 3 levels, close the game
//                    if (Level.currentLevel == 3) {
//                        JOptionPane.showMessageDialog(null, "You completed the game!");
//                        window.setVisible(false);
//                        window.dispose();
//                    } else {
//                        //Level finished +1
//                        Level.currentLevel++;
//                        Player.totalMoves = 0; // set the total moves back to 0
//                        label1.setText("Total Moves: " + Player.totalMoves); //rewrite the text to the total moves
//                        player.bag = null;
//
////                        for (Key key : Field.keys) {
////                            key.setCollected(false);
////                        }
////                        for (Door door : Field.doors) {
////                            door.setClosed(true);
////                        }
//                    }
//
//                    Level.loadLevel(Level.currentLevel);
//
//                    //Set the player to x = 0 and y = 0 coords
//                    Player.setPositionOneTime = 0;
////                    Player.setPosition(0, 0);

        });

        //Menu to restart the game
        //Create the button
        JButton button = new JButton("Restart");

        button.addActionListener(new ActionListener() {
            //Override the button click function
            @Override
            public void actionPerformed(ActionEvent e) {
                Level.restart(window, player);
                label1.setText("Total Moves: " + player.totalMoves); //rewrite the total moves to the screen

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
        window.add(panel);

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

        //First we assign how big the big the board needs to be
        dimX = 30;
        dimY = 30;

        //Because the board is 60 * every time you need to multiple the position
        //Need to look in more why this is happening
        int playerXPosition = player.getXPosition()* 30;
        int playerYPosition = player.getYPosition()* 30;

        //player.setPosition(playerXPosition, playerYPosition);

        
        //Load the level and put it in the array map
        Level.loadLevel();

        Field[][] maze = Grid.getMaze();

        int i = 0;
        int j = 0;
        //Print the grid out with the player on it
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

                switch (maze[i][j].returnType()) {
                    case 0:
                        Floor floor = new Floor(x, y, 0);
                        floor.paintField(g);
                        break;
                    case 1:
                        Wall currentWall = new Wall(x, y, 1);
                        currentWall.addWall(currentWall);
                        currentWall.paintField(g);
                        break;
                    case 2:
                        //DELETE  THIS ---
                        //When you put this in the player class, position of the player is weird DELETE THIS 
                        //DELETE THIS --- 
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
                        Door firstDoor = new Door(x, y, Door.DOOR1, 4);
                        firstDoor.addDoor(firstDoor);

                        //System.out.println("open doors = " + Door.openDoors);
                        if (!Door.openDoors.isEmpty()) {
                            for (Door openDoors : Door.openDoors) {
//                                System.out.println("x = "+ openDoors.closed);
//                                System.out.println("y = "+ openDoors.closed);
//                                System.out.println("door status = "+ openDoors.closed);
                                if (openDoors.getCoordX() != x && openDoors.getCoordY() != y || !openDoors.closed) {
//                                    System.out.println("count");
                                    firstDoor.paintField(g);
                                }
                            }
                        } else {
                            firstDoor.paintField(g);
                        }
//                      door.openDoor(g);
                        break;

                    case 4:
                        //Create a key
                        Key firstKey = new Key(x, y, 4, Door.DOOR1);
                        firstKey.addKey(firstKey);

                        if (player.bag == null || player.bag.getCoordX() != x && player.bag.getCoordY() != y) {
                            firstKey.paintField(g);
                        }

//                        player.collectKey(g);
                        // when the key is picked up the color changes to white
                        break;
                    case 5:
                        //Create a door that add the pin to the door
                        Door secondDoor = new Door(x, y, Door.DOOR2, 4);
                        secondDoor.addDoor(secondDoor);

                        secondDoor.paintField(g);
//                      door.openDoor(g);
                        break;
                    case 6:
                        //Create a key
                        Key secondKey = new Key(x, y, 4, Door.DOOR2);
                        secondKey.addKey(secondKey);

                        if (player.bag == null || player.bag.getCoordX() != x && player.bag.getCoordY() != y) {
                            secondKey.paintField(g);
                        }

                        break;
                    case 7:
                        //Create a door that add the pin to the door
                        Door thirdDoor = new Door(x, y, Door.DOOR3, 4);
                        thirdDoor.addDoor(thirdDoor);

                        thirdDoor.paintField(g);

                        break;
                    case 8:
                        //Create a key
                        Key thirdKey = new Key(x, y, 4, Door.DOOR3);
                        thirdKey.addKey(thirdKey);

                        if (player.bag != null) {
                            System.out.println(player.bag.getCoordX());

                        }
                        if (player.bag == null || player.bag.getCoordX() != x && player.bag.getCoordY() != y) {
                            thirdKey.paintField(g);
                        }

                        break;
                    case 9:
                        End end = new End(x, y, 9);
                        end.paintField(g);

                        break;
                    default:
                        Wall defaultWall = new Wall(x, y, 1);
                        defaultWall.paintField(g);
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

        MazeGame.checkKeys(g);
        MazeGame.checkDoors(g);
    }

    public static void checkKeys(Graphics g) {
        for (Key currentKey : Key.keys) {
            if (player.getXPosition() == (currentKey.getCoordX() / 30) && player.getYPosition() == (currentKey.getCoordY() / 30) && !currentKey.isCollected()) {
                player.setKey(currentKey);
                currentKey.setCollected(true);
                currentKey.repaintKey(g, player);
                break;
            }
        }
    }
    
    public static void checkDoors(Graphics g) {
        for (Door openDoor : Door.doors) {
            if (player.getXPosition() == (openDoor.getCoordX() / 30) && player.getYPosition() == (openDoor.getCoordY() / 30)) {
//                System.out.println(openDoor.getCoordX());
//                System.out.println(openDoor.getCoordX());
                openDoor.addOpenDoor();
            }
        }

    }
}
