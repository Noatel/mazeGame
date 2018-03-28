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

/**
 *
 * @author Jordie
 */
public class Level {
    
    public static ArrayList<int[]> loadLevel(int level){
       
        String readLevel = ".";
        String map = new File("src/mazegame/Levels").getAbsolutePath();
        
        //Clear the level before if there is one
        Grid.map.clear();
        
        switch(level){
            case 1:
                readLevel = map + "/level1.txt";
                break;
            case 2:
                readLevel =  map + "/level2.txt";
                break;
            case 3:
                readLevel = map + "/level3.txt";
                break;
        }
       
        try {
            File file = new File(readLevel);
            Scanner scanner = new Scanner(file);

            //Standard 20x20 field
            int width = 20 ;
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
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

        return Grid.map;
}
}
    
