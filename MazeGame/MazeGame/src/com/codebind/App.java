package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Random;


/**
 * Bug game GUI
 *
 * @author NoahTelussa
 * Klas : H-1-SE-3.4
 * Versie : 1.0.0
 * <p>
 * <p>
 * This Game is made in IntelliJ IDEA, not netbeans
 * I prefer this IDEA because i only have PHP experience
 * and this editor looks like PHPSTORM
 */

public class App extends JComponent {
    //Set the variables, the x coords, y coords
    private int dimX;
    private int dimY;
    private JButton buttonMessage;
    private JPanel panelMain;


    //Because you want to spawn the "fly" random you need to declare the random function
    static Random rand = new Random();
    static Grid grid = new Grid();

    //After loading in the random function, declare 2
    //variables and assign a random number to the "fly"
    private static int randomNumberX = rand.nextInt(10) + 1;
    private static int randomNumberY = rand.nextInt(10) + 1;

    //Create the Spider with a standard postion of x = 2 and y 2
    static Bug spider = new Bug("S", 2, 2);

    //Create the fly with the random x and y coords that we just assigned
    static Bug fly = new Bug("F", randomNumberX, randomNumberY);


    public App() {

    }

    //With the paint classes we can draw the rectangles on the GUI
    public void paint(Graphics g) {
        super.paint(g);

        //First we assign how big the big the board needs to be
        //For some reason its a 10x10 now (it divdes with 3)
        //Need to look in more why this is happening
        dimX = 60; // this is not the best solution
        dimY = 60; // for defining the size of the game!

        grid.calculateCorners(dimX, dimY);

        //Because the board is 60 * every time you need to multiple the position
        //Need to look in more why this is happening
        int spiderXPosition = spider.getXPosition() * 30;
        int spiderYPosition = spider.getYPosition() * 30;

        //Because the board is 60 * every time you need to multiple the position
        //Need to look in more why this is happening
        int flyXPosition = fly.getXPosition() * 30;
        int flyYPosition = fly.getYPosition() * 30;

        //Print the grid out with the spider and the fly
        //Draw all the rectangles in the screen
        for (int x = dimX; x <= 600; x += 30) {
//            System.out.println(x);
            for (int y = dimY; y <= 600; y += 30) {
                //If the rectangles is the same position as the spider x and y

                if (x == spiderXPosition && y == spiderYPosition) {
                    //Set the spider color (Red)
                    g.setColor(Color.RED);
                    //Draw a rectangle filling the square
                    g.fillRect(x, y, 30, 30);
                    g.drawRect(x, y, 30, 30);
                    //Set the color agian to black because else every thing else is Red
                    g.setColor(Color.BLACK);

                    //fill the grid where the fly is
                } else if (x == flyXPosition && y == flyYPosition) {
                    //Set the fly color (Green)
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, 30, 30);
                    g.drawRect(x, y, 30, 30);

                    //Set the color agian to black because else every thing else is Green
                    g.setColor(Color.BLACK);
                } else {
                    //If the position is not the same as the fly or spider, draw a simple rectangle
                    g.drawRect(x, y, 30, 30);
                }
            }
        }
    }

    public static void main(String[] a) {
        //Create the GUI and set the Title "Bug game"
        JFrame window = new JFrame();
        window.setTitle("Bug game");

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
//                System.out.println(spider.getYPosition() + " AND " + spider.getXPosition());

                int[][] corners = grid.getCorners();

                System.out.println(spider.getYPosition() + "-" + corners[0][0]);

                if (keyCode == KeyEvent.VK_LEFT) {          //Left arrow key
                    if (spider.getXPosition() > corners[0][0]) {       //If the position is on the left border
                        spider.turn(3);
                        spider.move();
                    }
                } else if (keyCode == KeyEvent.VK_RIGHT) {   //right arrow key
                    if (spider.getXPosition() < corners[1][0]) {        //If the position is on the right border
                        spider.turn(1);
                        spider.move();
                    }
                } else if (keyCode == KeyEvent.VK_UP) {      //Up arrow key
                    if (corners[0][0] < spider.getYPosition()) {        //If the position is on the up border
                        spider.turn(2);
                        spider.move();
                    }
                } else if (keyCode == KeyEvent.VK_DOWN) {    //Down arrow key
                    if ( spider.getYPosition() < corners[2][1] ) {        //If the position is on the down border
                        spider.turn(0);
                        spider.move();
                    }
                }

                //After we assign the new position and turn to the "Spider"
                //repaint all the rectangle (Maybe not the best way to do it)
                window.repaint();

                //If the position of the "Spider" is the same as the position of the "Fly"
                if (spider.getXPosition() == fly.getXPosition() && spider.getYPosition() == fly.getYPosition()) {
                    //Takes first time long to load for some reaason
                    //Show the you won message as a alert and in the terminal with system out println
                    System.out.println("won");
                    JOptionPane.showMessageDialog(null, "WON");
                }
            }
        });

        //Set how big the program needs to be
        //For looks i got a width of 360 and 390
        window.setBounds(0, 0, 720, 780);

        //After we set the width and height
        //Center it to the middle of your screen
        //Searched it on stackoverflow how to do this
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        window.getContentPane().add(new App());
        window.setVisible(true);
    }


}
