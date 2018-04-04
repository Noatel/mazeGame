/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.VeldTiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Jordie
 */
abstract public class Veld {
    public int coordX;
    public int coordY;
    public int type;
    public static ArrayList<Wall> walls = new ArrayList<Wall>();
    public static ArrayList<Key> keys = new ArrayList<Key>();
    public static int[] endLocation = new int[2];

    public Veld(int coordX, int coordY, int type){
        this.coordX = coordX;
        this.coordY = coordY;
        this.type = type;
    }
    
    public static void setVeld(Graphics g,int x, int y){
            g.setColor(Color.WHITE);
            g.fillRect(x, y, 30, 30);
            g.drawRect(x, y, 30, 30);
    }
   
    public int returnType(){
        return type;
    }
    
    
    
}
