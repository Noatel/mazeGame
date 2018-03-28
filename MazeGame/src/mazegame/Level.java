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
    
    public static ArrayList<int[]> loadLevel(int level) throws FileNotFoundException {
       
        String readLevel = ".";
        String map = new File("src/mazegame/Levels").getAbsolutePath();
        
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
       
            File file = new File(readLevel);
            Scanner scanner = new Scanner(file);

            //Standard 20x20 field
            int width = 20;
            while (scanner.hasNextLine()) {
                // Setup current row:
                int[] row = new int[width];
                // For each number..
                for (int i = 0; i < width; i++) {
                    // Read the number and add it to the current row:
                    System.out.println(scanner.nextInt());
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
        

        return Grid.map;
}
}
    
