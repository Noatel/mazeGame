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
    private int coordX;

    /**
     * Create the getCoordY
     *
     */
    private int getCoordY;

    /*
     * A field exist out of a {@type}
     */
    private int type;

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
        this.getCoordY = coordY;
        this.type = type;
    }

    public Field() {
    }

    public int getCoordX() {
        return coordX;
    }
     public int getCoordY() {
        return getCoordY;
    }

    abstract void paintField(Graphics g);

    /**
     * @return type of the field
     */
    public int returnType() {
        return type;
    }

}
