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
public class Wall extends Veld {
    public Wall(int coordX, int coordY,int type){
           super(coordX, coordY, type);
    }
    
    public static void setWall(Graphics g,int x, int y){
        Veld.walls.add(new Wall((x / 30), (y / 30),1));
        
            g.setColor(Color.GRAY);
            g.fillRect(x, y, 30, 30);
            g.drawRect(x, y, 30, 30);
    }
    
    public static ArrayList<Wall> getWall(){
       return Veld.walls;
    }
}
