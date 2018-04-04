/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.VeldTiles;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Jordie
 */
public class Wall extends Veld {
    public Wall(int coordX, int coordY,int type){
           super(coordX, coordY, type);
    }
    
    public static void setWall(Graphics g,int x, int y){
            g.setColor(Color.GRAY);
            g.fillRect(x, y, 30, 30);
            g.drawRect(x, y, 30, 30);
    }
}
