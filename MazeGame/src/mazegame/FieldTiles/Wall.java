/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.FieldTiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jordie
 */
public class Wall extends Field {

   
    
    public Wall(int coordX, int coordY, int type) {
        super(coordX, coordY, type);
    }
    
    public Wall() {
    }


    /**
     *
     * Sets the tool tip text.
     *
     * @param g use the Graphics g to draw the squares on the field
     */
    
    @Override
    public void paintField(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(((this.getCoordX() + 1) * 30), ((this.getCoordY() + 1) * 30), 30, 30);
        g.drawRect(((this.getCoordX() + 1) * 30), ((this.getCoordY() + 1) * 30), 30, 30);

    }
}
