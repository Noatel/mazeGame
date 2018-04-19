/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import mazegame.FieldTiles.*;

/**
 *
 * @author Jordie
 */
public class Level {

    /**
     * Current level keeps track of what level you are playing
     */
    public static int currentLevel = 1;
    private int newRow;

    public Level() {

    }

    /**
     * Load the level that you have want to play
     *
     * @param level
     * @return Grid.map
     */
    public static void loadLevel(int level) {
        Level newLevel = new Level();

        //Get the path of the level
        String readLevel = ".";
        String map = new File("src/mazegame/Levels").getAbsolutePath();
        
        //select which level you want to load
        switch (level) {
            case 1:
                //Level 1
                readLevel = map + "/level1.txt";
                break;
            case 2:
                //Level 2
                readLevel = map + "/level2.txt";
                break;
            case 3:
                //Level 3
                readLevel = map + "/level3.txt";
                break;
        }

        //Try to find the file, in case of a catch, throw exception
        try {

            //read the level
            File file = new File(readLevel);

            //initialize scanner and load it on file
            Scanner scanner = new Scanner(file);

            //set the standard width of the field to 10 
            int width = 10;

            //check each line in scanner
            while (scanner.hasNextLine()) {
                // create a new row with the length of width
                int[] row = new int[width];
                // enter a number into the row 1 throught 10 each row
                for (int i = 0; i < width; i++) {
                    // Read the number and add it to the current row
                    row[i] = scanner.nextInt();
                   
                    //get the current tile
                    switch (row[i]) {
                        case 0: // create new floor object
                            Grid.maze[newLevel.getNewRow()][i] = new Floor(i, newLevel.getNewRow(), row[i]);
                            break;
                        case 1://create new wall object
                            Grid.maze[newLevel.getNewRow()][i] = new Wall(i, newLevel.getNewRow(), row[i]);
                            break;
                        case 2:
                            //create new player object
                            Grid.maze[newLevel.getNewRow()][i] = new Floor(i, newLevel.getNewRow(), row[i]);
                            break;
                        case 3:
                            //create new door object with pin 100
                            Grid.maze[newLevel.getNewRow()][i] = new Door(i, newLevel.getNewRow(), Door.DOOR1, row[i]);
                            break;
                        case 4:
                            //create new key object with pin 100
                            Grid.maze[newLevel.getNewRow()][i] = new Key(i, newLevel.getNewRow(), row[i], Door.DOOR1);

                            break;
                        case 5:
                            //create new door object with pin 200
                            Grid.maze[newLevel.getNewRow()][i] = new Door(i, newLevel.getNewRow(), Door.DOOR2, row[i]);

                            break;
                        case 6:
                            //create new key object with pin 200
                            Grid.maze[newLevel.getNewRow()][i] = new Key(i, newLevel.getNewRow(), row[i], Door.DOOR2);

                            break;
                        case 7:
                            //create new door object with pin 300
                            Grid.maze[newLevel.getNewRow()][i] = new Door(i, newLevel.getNewRow(), Door.DOOR3, row[i]);

                            break;
                        case 8:
                            //create new key object with pin 300
                            Grid.maze[newLevel.getNewRow()][i] = new Key(i, newLevel.getNewRow(), row[i], Door.DOOR3);

                            break;
                        case 9://create new end object
                            Grid.maze[newLevel.getNewRow()][i] = new End(i, newLevel.getNewRow(), row[i]);

                            break;
                        default://create new default wall
                            Grid.maze[newLevel.getNewRow()][i] = new Wall(i, newLevel.getNewRow(), row[i]);

                            break;
                    }
                }
                //set the next row
                newLevel.setNewRow();
                // Add the row to the results:

                //if the scanner has a next line, go to the next line
                if (scanner.hasNextLine()) {
                    // Go to the next line:
                    scanner.nextLine();

                }
            }
            //Close the scanner 
            scanner.close();
        } catch (FileNotFoundException e) {
            //Gives a error, file not found
            e.printStackTrace();
        }

        //Return the array that you filled
    }
    //return the new row
    private int getNewRow() {
        return newRow;
    }
    //set a new row
    private void setNewRow() {
        newRow++;
    }

    /**
     * Restart the game, repaint the JFrame also set the JFrame on focusable
     * again and set the player position on 0x0
     *
     * @param window
     */
    public static void restart(JFrame window, Player player) {
        player.resetSetPosition(); //reset the player position
        player.setPosition(1, 1); //reset the player position back to the beginning
        player.totalMoves = 0; // reset the total moves
        //reload the new level
        Level.loadLevel(currentLevel);
        
        window.repaint(); //repaint the failed
        window.setFocusable(true); //set the game focusable
        window.requestFocusInWindow(); //set the game focused
    }
}
