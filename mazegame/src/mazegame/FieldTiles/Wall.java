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
    
    public static List<Wall> walls = new ArrayList<Wall>();

    /**
     *
     * Sets the tool tip text.
     *
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
     */
    
    @Override
    public void paintField(Graphics g, int x, int y) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);
        
        this.addWall(this);
    }
    
    public static List<Wall> returnWalls(){
        return walls;
    }
    public void clearWalls(){
        walls.clear();
    }

    public void addWall(Wall wall) {
        walls.add(wall);
    }
}
