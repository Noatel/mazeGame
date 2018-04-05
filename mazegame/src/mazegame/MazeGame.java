/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Random;
import mazegame.VeldTiles.*;

/**
 *
 * @author NoahTelussa
 */
public class MazeGame extends JComponent {

    //Set the variables, the x coords, y coords
    private int dimX;
    private int dimY;
    private JButton buttonMessage;
    private JPanel panelMain;
    private int clearStartPosition;

    //Because you want to spawn the "fly" random you need to declare the random function
    static Random rand = new Random();
    static Grid grid = new Grid();

    //Create the Spider with a standard postion of x = 2 and y 2
    static Player player = new Player();
    boolean startPosition = false;

    public MazeGame() {

    }

    //With the paint classes we can draw the rectangles on the GUI
    public void paint(Graphics g) {
        super.paint(g);

        //First we assign how big the big the board needs to be
        //For some reason its a 10x10 now (it divdes with 3)
        //Need to look in more why this is happening
        dimX = 30; // this is not the best solution
        dimY = 30; // for defining the size of the game!

//        grid.calculateCorners(dimX, dimY);
        //Because the board is 60 * every time you need to multiple the position
        //Need to look in more why this is happening
        int playerXPosition = player.getXPosition() * 30;
        int playerYPosition = player.getYPosition() * 30;

        System.out.println("Positions are" + playerXPosition);
        System.out.println("Positions are" + playerXPosition);

        player.setPosition(playerXPosition, playerYPosition);

        ArrayList<int[]> map = Level.loadLevel(Level.currentLevel);

        int i = 0;
        int j = 0;
        //Print the grid out with the spider and the fly
        //Draw all the rectangles in the screen
        for (int x = dimX; x <= 315; x += 30) {
//          System.out.println(x);
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
                        Veld.setVeld(g, x, y);
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
                            g.setColor(Color.WHITE);
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 3:
                        // dit maakt een nieuw deur object waardoor ik de pin aan het object kan toevoegen
                        Door.setDoor(g, x, y, 100);

//                        if (!Bag.getBag().isEmpty()) {
//                            if (Door.openDoor(Bag.getBag().get(0).getNonStaticPin())) {
//                                g.setColor(Color.WHITE);
//                                g.fillRect(x, y, 30, 30);
//                                g.drawRect(x, y, 30, 30);
//                            }
//                        }
                        break;
                    case 4:
                        // dit maakt een nieuw sleutel object waardoor ik de pin aan het object kan toevoegen
                        Key.setKey(g, x, y, 100, 4);

                        // when the key is picked up the color changes to white
                        if (Key.isCollected() && Key.getId() == 4) {
                            g.setColor(Color.WHITE);
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 5:
                        Door.setDoor(g, x, y, 200);
                        break;
                    case 6:
                        Key.setKey(g, x, y, 200, 6);
                        if (Key.isCollected() && Key.getId() == 6) {
                            g.setColor(Color.WHITE);
                            g.fillRect(x, y, 30, 30);
                            g.drawRect(x, y, 30, 30);
                        }
                        break;
                    case 7:
                        Door.setDoor(g, x, y, 300);
                        break;
                    case 8:
                        Key.setKey(g, x, y, 300, 8);
                        if (Key.isCollected() && Key.getId() == 8) {
                            g.setColor(Color.WHITE);
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

                //check if the player is in the chosen square.
                //if so paint the player
            }

        }

    }

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

                        for (Wall wall : Veld.walls) { //Cycle through each and every wall
                            //check if the player input is going to be a wall or not
                            if (player.getXPosition() == wall.coordX && (player.getYPosition() - 1) == wall.coordY) {
                                System.out.println("You cant move");
                                checkObstacle = false; //set checkobstacle to false to stop the player from moving
                                break; //break the forloop and continue on
                            } else {
                                checkObstacle = true; // set
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
                        for (Wall wall : Veld.walls) {
                            if ((player.getXPosition() + 1) == wall.coordX && player.getYPosition() == wall.coordY) {
                                System.out.println("You cant move"); // plz work
                                checkObstacle = false;
                                break;
                            } else {
                                checkObstacle = true;
                            }
                        }

                        if (checkObstacle) {
                            player.move('e');
                        } else {
                            System.out.println("You can't move");
                        }

                        break;
                    case KeyEvent.VK_DOWN:
                        for (Wall wall : Veld.walls) {
                            if (player.getXPosition() == wall.coordX && (player.getYPosition() + 1) == wall.coordY) {
                                System.out.println("You cant move"); // plz work
                                checkObstacle = false;
                                break;
                            } else {
                                checkObstacle = true;
                            }
                        }

                        if (checkObstacle) {
                            player.move('s');
                        } else {
                            System.out.println("You can't move");
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        for (Wall wall : Veld.walls) {
                            if ((player.getXPosition() - 1) == wall.coordX && player.getYPosition() == wall.coordY) {
                                System.out.println("You cant move"); // plz work
                                checkObstacle = false;
                                break;
                            } else {
                                checkObstacle = true;
                            }
                        }

                        if (checkObstacle) {
                            player.move('w');
                        } else {
                            System.out.println("You can't move");
                        }
                        break;
                }
                //After we assign the new position and turn to the "Spider"
                //repaint all the rectangle (Maybe not the best way to do it)

                //Check if the player is at the end location
                if (player.getXPosition() == Veld.endLocation[0] && player.getYPosition() == Veld.endLocation[1]) {
                    if (Level.currentLevel == 3) {
                        JOptionPane.showMessageDialog(null, "You complete the game!");

                        Level.currentLevel = 1;
                    } else {
                        //Level finished +1
                        Level.currentLevel++;
                    }
                    //Load in next level
                    Level.loadLevel(Level.currentLevel);
                    Player.setPositionOneTime = 0;
                    Player.setPosition(0, 0);

                }

                for (Key key : Veld.keys) {
                    if (player.getXPosition() == key.coordX && player.getYPosition() == key.coordY && key.getId() == Veld.keys.get(0).getId()) {
                        Bag.addKey(key);
                        key.setCollected(true);
                        System.out.println("Key collected");
                    }
                }

                window.repaint();

            }
        });
        //Menu to restart the game
        JButton button = new JButton("Restart");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Level.loadLevel(Level.currentLevel);
                Player.setPositionOneTime = 0;
                Player.setPosition(0, 0);
                window.repaint();
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

        window.getContentPane().add(new MazeGame());
        window.setVisible(true);
    }

}
