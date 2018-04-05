/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.FieldTiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Jordie
 */
abstract public class Field {
    //Create the variables coord x, coord y and the type of the field
    public int coordX;
    public int coordY;
    public int type;
    
    //Create 2 arrays with the location of all the walls and the keys
    public static ArrayList<Wall> walls = new ArrayList<Wall>();
    public static ArrayList<Key> keys = new ArrayList<Key>();
    
    //Create a int array of length of 2 where the x and y coords are being saved
    public static int[] endLocation = new int[2];

    //Construct Field with the coord x, coord y and the type
    public Field(int coordX, int coordY, int type){
        this.coordX = coordX;
        this.coordY = coordY;
        this.type = type;
    }
    
    /**
     * Sets the x,y values and draw the square default color white
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
    */
    public static void setField(Graphics g,int x, int y){
            g.setColor(Color.WHITE);
            g.fillRect(x, y, 30, 30);
            g.drawRect(x, y, 30, 30);
    }
    
    /**
    * @return type of the field
    */
    public int returnType(){
        return type;
    }
    
    
    
}
