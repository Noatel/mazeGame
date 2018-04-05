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
import static mazegame.Bag.alreadyCollected;
import mazegame.FieldTiles.Door;
import mazegame.FieldTiles.Field;
import mazegame.FieldTiles.Key;
import mazegame.FieldTiles.Wall;

/**
 *
 * @author Jordie
 */
public class Level {

    /**
     * Current level keeps track of what level you are in the variable {
     *
     * @currentLevel}
     */
    public static int currentLevel = 1;

    /**
     * Load the file that you at assign level to and fill the Grid.map array
     *
     * @param level
     * @return Grid.map
     */
    public static ArrayList<int[]> loadLevel(int level) {

        //Get the path of the level
        String readLevel = ".";
        String map = new File("src/mazegame/Levels").getAbsolutePath();

        //Clear the level before if there is one
        Grid.map.clear();
        Wall.walls.clear();
        Field.walls.clear();
        Field.doors.clear();
        Field.keys.clear();

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

            //While it got a next line on the file
            while (scanner.hasNextLine()) {
                // create a new current row:
                int[] row = new int[width];
                // enter a number into the row 1 throught 20 each row
                for (int i = 0; i < width; i++) {
                    // Read the number and add it to the current row:
                    row[i] = scanner.nextInt();
                }
                // Add the row to the results:
                Grid.map.add(row);

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
        return Grid.map;
    }

    /**
     * Restart the game, repaint the JFrame also set the JFrame on focusable
     * again and set the player position on 0x0
     *
     * @param window
     */
    public static void restart(JFrame window) {
        Player.setPositionOneTime = 0;
        Player.setPosition(0, 0);
        Bag.alreadyCollected.clear();
        Bag.bag = 0;
        Player.totalMoves = 0; // reset the total moves

        for (Door door : Field.doors) {
            door.setClosed(true);
        }

        Level.loadLevel(Level.currentLevel);

        window.repaint();
        window.setFocusable(true);
        window.requestFocusInWindow();
    }
}
