/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.util.ArrayList;
import mazegame.FieldTiles.Field;

/**
 * After the map is loaded in the Class Level method LoadLevel it fills the
 * array map. The array map includes the layout of the level including walls,
 * doors,keys and a endpoint
 *
 * @author Jordie
 */
public class Grid {

    //create new object array with size 10*10
    public static Field[][] maze = new Field[10][10];
    
    //return maze
    public static Field[][] getMaze() {
        return maze;
    }
}
