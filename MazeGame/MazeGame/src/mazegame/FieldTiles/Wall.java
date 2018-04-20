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
    
    //Create an emptywall array 
    public static List<Wall> walls = new ArrayList<Wall>();

    /**
     *
     * Sets the tool tip text.
     *
     * @param g use the Graphics g to draw the squares on the field
     */
    
    @Override
    public void paintField(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(this.getCoordX(), this.getCoordY(), 30, 30);
        g.drawRect(this.getCoordX(), this.getCoordY(), 30, 30);
        
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
