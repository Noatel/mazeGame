/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComponent;

/**
 *
 * @author Jordie
 */
public class MazeGame extends JComponent{
    static Grid grid = new Grid();

    //Create the Spider with a standard postion of x = 2 and y 2
    static public Player player = new Player();
    
    /**
     * @param args the command line arguments
     */
    
    private int dimX;
    private int dimY;
    
    static Grid grid = new Grid();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
//        System.exit(0);
        //Create the GUI and set the Title "Maze game"
        JFrame window = new JFrame();
        window.setTitle("Maze game");

        //Because you want to play with the arrows you need to focus it
        window.setFocusable(true);
        window.requestFocusInWindow();

        //Add buttons


        //If you want to close the program, close it
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        window.addKeyListener(new KeyAdapter() {
            //If a key is pressed
            @Override
            public void keyPressed(KeyEvent e) {
                //Get the keycode of the key (like the left arrow)
                int keyCode = e.getKeyCode();
                //If the user press one of the arrow keys

//                int[][] corners = grid.getCorners();

//                System.out.println(spider.getXPosition() + "-" + spider.getYPosition());
                if (keyCode == KeyEvent.VK_LEFT) {                     //Left arrow key
//                    if (spider.getXPosition() >= corners[0][0]) {       //If the position is on the left border
                    player.turn(3);
                    player.move();
//                    }
                } else if (keyCode == KeyEvent.VK_RIGHT) {              //right arrow key
//                    if (spider.getXPosition() <= corners[1][0]) {        //If the position is on the right border
                    player.turn(1);
                    player.move();
//                    }
                } else if (keyCode == KeyEvent.VK_UP) {                 //Up arrow key
//                    if (corners[0][0] <= spider.getYPosition()) {        //If the position is on the up border
                    player.turn(2);
                    player.move();
//                    }
                } else if (keyCode == KeyEvent.VK_DOWN) {                //Down arrow key
//                    if (spider.getYPosition() <= corners[2][1]) {       //If the position is on the down border
                    player.turn(0);
                    player.move();
//                    }
                }

                System.out.println(player.toString());


                //After we assign the new position and turn to the "Spider"
                //repaint all the rectangle (Maybe not the best way to do it)
                window.repaint();

           
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

//        window.getContentPane().add(new MazeGame());
        window.setVisible(true);
    }
    
    public void paint(Graphics g){
        
        dimX = 60; // this is not the best solution
        dimY = 60; // for defining the size of the game!

        grid.calculateCorners(dimX, dimY);
        
        //for(int i = dimX; i < ) needs editing
    }
    
}