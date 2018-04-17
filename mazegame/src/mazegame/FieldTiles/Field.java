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

    /**
     * Create a CoordX
     */
    public int coordX;

    /**
     * Create the coordY
     *
     */
    public int coordY;

    /*
     * A field exist out of a {@type}
     */
    public int type;
    
    /*
    * Create a int array of length of 2 where the x and y coords are being saved in {@endLocation}
     */
    public static int[] endLocation = new int[2];
    static final int NEW_COORDS = 100;

    //Construct Field with the coord x, coord y and the type
    /**
     * Constructs a field that needs the position of the x coordinate, y
     * coordinate and the type
     *
     * @param coordX coordinate of a field
     * @param coordY coordinate of a field
     * @param type type of the field
     */
    public Field(int coordX, int coordY, int type) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.type = type;
    }
    
    public Field() {
    }

    
     abstract void paintField(Graphics g, int x, int y);

    /**
     * @return type of the field
     */
    public int returnType() {
        return type;
    }

}
