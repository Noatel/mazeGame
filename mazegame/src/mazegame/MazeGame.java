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

    //Set the dimensionalX and dimensionalY values for the grid
    private int dimX;
    private int dimY;

    //load a new Grid
    static Grid grid = new Grid();

    //Create the player and set new boolean startPosition false
    static Player player = new Player();
    public boolean startPosition = true;

    //create a JLabel for totalMoves
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

        //Load the level and put it in the array map
        Level.loadLevel(Level.currentLevel);

        //focus the window for automatic keyboard control
        window.setFocusable(true);
        window.requestFocusInWindow();

        //Make sure you can close the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add an eventlistener to the window
        window.addKeyListener(new KeyAdapter() {
            //check if the player has pressed a key
            public void keyPressed(KeyEvent e) {
                //get the keyCode from the pressed key
                int keyCode = e.getKeyCode();
                //check if the player has pressed any of the arrow keys
                switch (keyCode) {
                    case KeyEvent.VK_UP: //up arrow key
                        player.move('n'); //go to move function in player class with the parameter 'n'
                        break;
                    case KeyEvent.VK_RIGHT: //right arrow key
                        player.move('e'); //go to move function in player class with the parameter 'e'
                        break;
                    case KeyEvent.VK_DOWN: //down arrow key
                        player.move('s'); //go to move function in player class with the parameter 's'
                        break;
                    case KeyEvent.VK_LEFT: //left arrow key
                        player.move('w'); //go to move function in player class with the parameter 'w'
                        break;
                }
                //Repaint the window
                window.repaint();
            }
        });

        //Menu to restart the game
        //create a new button to restart the game
        JButton button = new JButton("Restart");
        //add an actionListener to the button
        button.addActionListener(new ActionListener() {
            //Override actionPerformed with our code
            @Override
            public void actionPerformed(ActionEvent e) {
                Level.restart(window, player); //go to the restart method in Level
                label1.setText("Total Moves: " + player.totalMoves); //rewrite the total moves to the screen
                window.setFocusable(true); //set the window focusable
                window.requestFocusInWindow(); //focus the window
            }
        });
        
        //place the restart button on the bottom of the window
        window.add(button, BorderLayout.SOUTH);
        //set the starting bounds for the window
        window.setBounds(0, 0, 360, 390);
        
        //after we have set the window and it's bounds
        //get the correct screen size and store it in dim
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //place the window in the middle of your screen
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        //Add the MazeGame() and set the window to visible to show it
        window.getContentPane().add(new MazeGame());
        window.setVisible(true);
        //create a new panel
        JPanel panel = new JPanel();
        //set panel location and add label1 to the panel and add that label to the window
        label1.setHorizontalTextPosition(0);
        label1.setVerticalTextPosition(0);
        panel.add(label1);
        window.add(panel);

    }

    /**
     * With the paint classes we can draw the rectangles on the JFrame that we
     * create in the main. We assign the basic values of the grid, Set the player
     * x coordinates and y coordinates And load the level in with the method
     * LoadLevel();
     *
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

        //set the size of each and every fieldTile
        dimX = 30;
        dimY = 30;

        //store the player X and Y position 
        //first we increase the value of player with 1 because the first tile in the game
        //is placed at 0 and 0 * 30 = 0, if we didn't do this you wouldn't see the player
        int playerXPosition = (player.getXPosition() + 1) * 30;
        int playerYPosition = (player.getYPosition() + 1) * 30;
        
        //load the maze
        Field[][] maze = Grid.getMaze();

        int i = 0; //I == X on the grid
        int j = 0; //J == Y on the grid
        
        //get X and loop through it untill it is done
        //the for loop uses x <= 300 ; x += 30 with the following reason
        //the 300 is the width of the field and 30 is the width of each field
        //let's say we used x <= 100; x += 10 the game would be too small for the field
        for (int x = dimX; x <= 300; x += 30) {
            for (int y = dimY; y <= 300; y += 30) {
                //if i has reached the last in the row set i to 0 and load the next row
                if (i == 10) {
                    //Reset it to the first tile
                    i = 0;
                    //go to the next row
                    j++;
                }
                //paint each tile with the corresponding fieldType
                switch (maze[i][j].returnType()) {
                    case 0: //case == (walkable) floor
                        //paint a floor
                        Floor floor = (Floor) maze[i][j];
                        floor.paintField(g);
                        break;
                    case 1: // case == (impassable) wall
                        //paint a wall
                        Wall currentWall = (Wall) maze[i][j];
                        currentWall.paintField(g);
                        break;
                    case 2: // case == player starting position
                        Floor playerFloor = (Floor) maze[i][j];
                        //check if the player hasn't moved yet
                        if(startPosition){
                            g.setColor(Color.RED);
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                            startPosition = false;
                        } else {
                            playerFloor.paintField(g); //player has moved, therefor reset position to floor
                        }
                        break;
                    case 3: // case == door with pin 100
                        //paint new door
                        Door door = (Door) maze[i][j];
                        //check if this specific tile is an instace of a door
                        if (maze[i][j] instanceof Door) {
                            //check if the door should be hidden
                            if (!door.getHidden()) {
                                //paint door
                                door.paintField(g);
                            }
                        }
                        break;
                    case 4: // case == key with pin 100
                        //get new Key
                        Key firstKey = (Key) maze[i][j];
                        //check if this specific tile is an instance of a key
                        if (maze[i][j] instanceof Key) {
                            //check if bag in player is empty
                            if (player.bag == null) {
                                    //paint the key to the game
                                    firstKey.paintField(g);
                            } else {
                                //check if the player collects a key
                               if (firstKey.getCoordX() == player.bag.getCoordX() && firstKey.getCoordY() == player.bag.getCoordY()) {
                                } else if (!firstKey.getHidden()) {
                                    firstKey.paintField(g);
                                }
                            }
                        }
                        break;
                    case 5: // case == door with 200 pin
                        Door secondDoor = (Door) maze[i][j];
                        //check if the specific tile is an instance of door
                        if (maze[i][j] instanceof Door) {
                            //should the door be hidden?
                            if (!secondDoor.getHidden()) {
                                secondDoor.paintField(g);
                            }
                        }
                        break;
                    case 6: // case == key with pin 200
                        Key secondKey = (Key) maze[i][j];
                        //check if the specific tile is an instance of Key
                        if (maze[i][j] instanceof Key) {
                            //check if the bag in player is empty
                            if (player.bag == null) {
                                //paint the key into the game
                                secondKey.paintField(g);
                            } else {
                                //check if the player collects a Key
                               if (secondKey.getCoordX() == player.bag.getCoordX() && secondKey.getCoordY() == player.bag.getCoordY()) {
                                } else if (!secondKey.getHidden()) {
                                    secondKey.paintField(g);
                                }
                            }
                        }
                        break;
                    case 7:// case == door with pin 300
                        Door thirdDoor = (Door) maze[i][j];
                        //check if this specific tile is an instance of Door
                        if (maze[i][j] instanceof Door) {
                            //check if the door should be hidden
                            if (!thirdDoor.getHidden()) {
                                thirdDoor.paintField(g);
                            }
                        }
                        break;
                    case 8:// case == key with pin 300
                        Key thirdKey = (Key) maze[i][j];
                        //check if this specific tile is an instance of Key
                        if (maze[i][j] instanceof Key) {
                            //check if the bag in player is empty
                            if (player.bag == null) {
                                //paint the key to the game
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

                    case 9:// case == end tile
                        End end = (End) maze[i][j];
                        end.paintField(g);
                        break;
                    default:// default (there wasn't an recognizable int found therefor place a wall) wall
                        Wall defaultWall = (Wall) maze[i][j];
                        defaultWall.paintField(g);
                        break;
                }
                //paint the player to the corresponding location
                if (x == playerXPosition && y == playerYPosition) {
                    player.paintPlayer(g);
                }
                //create a black border to each tile
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 30, 30);
                //increase i
                i++;
            }
        }

    }
}
