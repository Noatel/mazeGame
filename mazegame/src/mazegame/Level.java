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
     * Current level keeps track of what level you are in the variable
     */
    public static int currentLevel = 1;
    private int newRow;

    public Level() {

    }

    /**
     * Load the file that you at assign level to and fill the Grid.map array
     *
     * @param level Level is the current level you at
     */
    public static void loadLevel(int level) {
        Level newLevel = new Level();

        //Get the path of the level
        String readLevel = ".";
        String map = new File("src/mazegame/Levels").getAbsolutePath();

        //Because we got multiple levels
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

        //In this try and catch we going to find the file
        try {

            //We use the string that we loaded in the switch
            File file = new File(readLevel);

            //After that we are going to use that file and scan it
            Scanner scanner = new Scanner(file);

            //Standard 20x20 field
            int width = 10;
            int countRows = 0;

            //While it got a next line one the file
            while (scanner.hasNextLine()) {
                // create a new current row:
                int[] row = new int[width];
                // enter a number into the row 1 throught 10 each row
                for (int i = 0; i < width; i++) {
                    // Read the number and add it to the current row:
                    row[i] = scanner.nextInt();
                    //System.out.println(row[i] + "("+countRows+","+i+")");
                   
                    switch (row[i]) {
                        case 0:
                            Grid.maze[newLevel.getNewRow()][i] = new Floor(i, newLevel.getNewRow(), row[i]);
                            break;
                        case 1:
                            Grid.maze[newLevel.getNewRow()][i] = new Wall(i, newLevel.getNewRow(), row[i]);
                            break;
                        case 2:
                            //player
                            Grid.maze[newLevel.getNewRow()][i] = new Floor(i, newLevel.getNewRow(), row[i]);
                            break;
                        case 3:
                            Grid.maze[newLevel.getNewRow()][i] = new Door(i, newLevel.getNewRow(), Door.DOOR1, row[i]);
                            break;
                        case 4:
                            //Create a key
                            Grid.maze[newLevel.getNewRow()][i] = new Key(i, newLevel.getNewRow(), row[i], Door.DOOR1);

                            break;
                        case 5:
                            //Create a door that add the pin to the door
                            Grid.maze[newLevel.getNewRow()][i] = new Door(i, newLevel.getNewRow(), Door.DOOR2, row[i]);

                            break;
                        case 6:
                            //Create a key
                            Grid.maze[newLevel.getNewRow()][i] = new Key(i, newLevel.getNewRow(), row[i], Door.DOOR2);

                            break;
                        case 7:
                            //Create a door that add the pin to the door
                            Grid.maze[newLevel.getNewRow()][i] = new Door(i, newLevel.getNewRow(), Door.DOOR3, row[i]);

                            break;
                        case 8:
                            //Create a key
                            Grid.maze[newLevel.getNewRow()][i] = new Key(i, newLevel.getNewRow(), row[i], Door.DOOR3);

                            break;
                        case 9:
                            Grid.maze[newLevel.getNewRow()][i] = new End(i, newLevel.getNewRow(), row[i]);

                            break;
                        default:
                            Grid.maze[newLevel.getNewRow()][i] = new Wall(i, newLevel.getNewRow(), row[i]);

                            break;
                    }
                }
                newLevel.setNewRow();
                countRows++;
                // Add the row to the results:

                // Go to the next line (optional, but helps deal with erroneous input files):
                if (scanner.hasNextLine()) {
                    // Go to the next line:
                    scanner.nextLine();

                }
            }
            //Close the scanner and 
            scanner.close();
        } catch (FileNotFoundException e) {
            //Gives a error, file not found
            e.printStackTrace();
        }

        //Return the array that you filled
    }

    private int getNewRow() {
        return newRow;
    }

    private void setNewRow() {
        newRow++;
    }

    /**
     * Restart the game, repaint the JFrame also set the JFrame on focusable
     * again and set the player position on 0x0
     *
     * @param window reset the JFrame
     * @param player reset the player totalmoves, set the player and clear the bag
     */
    public static void restart(JFrame window, Player player) {
        player.setPosition(1, 1);
        player.totalMoves = 0; // reset the total moves
        player.clearBag();
        Level.loadLevel(currentLevel);

        window.repaint();
        window.setFocusable(true);
        window.requestFocusInWindow();
    }
}
