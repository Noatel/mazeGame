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

    //player.setPosition(playerXPosition, playerYPosition);
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

        //Load the level and put it in the array map
        Level.loadLevel(Level.currentLevel);

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
                        player.move('n');
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.move('e');
                        break;
                    case KeyEvent.VK_DOWN:
                        player.move('s');
                        break;
                    case KeyEvent.VK_LEFT:
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

    public static void exitWindow() {
        JFrame window = new JFrame();
        window.setTitle("Maze game");
        window.setFocusable(true);
        window.requestFocusInWindow();
        window.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);
        window.setBounds(0, 0, 300, 100);
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("You made it");

        label1.setHorizontalTextPosition(0);
        label1.setVerticalTextPosition(0);
        panel.add(label);
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
        int playerXPosition = (player.getXPosition() + 1) * 30;
        int playerYPosition = (player.getYPosition() + 1) * 30;

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
                        Door door = (Door) maze[i][j];
                        if (maze[i][j] instanceof Door) {
                            if (!door.getHidden()) {
                                door.paintField(g);
                            }
                        }
                        break;
                    case 4:
                        Key firstKey = (Key) maze[i][j];
                        if (maze[i][j] instanceof Key) {
                            if (player.bag == null) {
                                firstKey.paintField(g);
                            } else {
                                //player collects key
                                if (firstKey.getCoordX() == player.bag.getCoordX() && firstKey.getCoordY() == player.bag.getCoordY()) {
                                } else if (!firstKey.getHidden()) {
                                    firstKey.paintField(g);
                                }
                            }
                        }
                        break;
                    case 5:
                        Door secondDoor = (Door) maze[i][j];
                        if (maze[i][j] instanceof Door) {
                            if (!secondDoor.getHidden()) {
                                secondDoor.paintField(g);
                            }
                        }
                        break;
                    case 6:
                        Key secondKey = (Key) maze[i][j];
                        if (maze[i][j] instanceof Key) {
                            if (player.bag == null) {
                                secondKey.paintField(g);
                            } else {
                                //player collects key
                                if (secondKey.getCoordX() == player.bag.getCoordX() && secondKey.getCoordY() == player.bag.getCoordY()) {
                                } else if (!secondKey.getHidden()) {
                                    secondKey.paintField(g);
                                }
                            }
                        }
                        break;
                    case 7:
                        Door thirdDoor = (Door) maze[i][j];
                        if (maze[i][j] instanceof Door) {
                            if (!thirdDoor.getHidden()) {
                                thirdDoor.paintField(g);
                            }
                        }
                        break;
                    case 8:
                        Key thirdKey = (Key) maze[i][j];
                        if (maze[i][j] instanceof Key) {
                            if (player.bag == null) {
                                thirdKey.paintField(g);
                            } else {
                                //player collects key
                                if (thirdKey.getCoordX() == player.bag.getCoordX() && thirdKey.getCoordY() == player.bag.getCoordY()) {
                                } else if (!thirdKey.getHidden()) {
                                    thirdKey.paintField(g);
                                }
                            }
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

    }
}
