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
public class Wall extends Field {
    public Wall(int coordX, int coordY,int type){
           super(coordX, coordY, type);
    }
    
    /**
     * Sets the tool tip text.
     *
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
     */
    public static void setWall(Graphics g,int x, int y){
        Field.walls.add(new Wall((x / 30), (y / 30),1));
        
            g.setColor(Color.GRAY);
            g.fillRect(x, y, 30, 30);
            g.drawRect(x, y, 30, 30);
    }
    
  
     /**
     * Return a arrayList with all the x and y of a wall
     *
     * @return Field.walls Array with all the wall locations
     */
     
    public static ArrayList<Wall> getWall(){
       return Field.walls;
    }
}
