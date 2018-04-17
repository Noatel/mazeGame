/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.FieldTiles;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author NoahTelussa
 */
public class Floor extends Field {
     public Floor(int coordX, int coordY, int type) {
        super(coordX, coordY, type);
    }
   
    /**
     * Sets the x,y values and draw the square default color white
     *
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
     */
     
    @Override
    public void paintField(Graphics g, int x, int y) {
        g.setColor(new Color(255,255,255));
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);
    }
}
