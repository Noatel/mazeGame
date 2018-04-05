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
     * Create a {@coordX}
     */
    public int coordX;

    /**
     * Create a {@coordY}
     *
     */
    public int coordY;

    /*
     * A field exist out of a {@type}
     */
    public int type;
    /*
     * Create a array with the location of all the walls in {@walls}
     */
    public static ArrayList<Wall> walls = new ArrayList<Wall>();
     /*
     * Create a array with the location of all the Door in {@door}
     */
    public static ArrayList<Door> doors = new ArrayList<Door>();

    /*
     * Create a array with the location of all the keys in {@keys}
     */
    public static ArrayList<Key> keys = new ArrayList<Key>(3);

    /*
    * Create a int array of length of 2 where the x and y coords are being saved in {@endLocation}
     */
    public static int[] endLocation = new int[2];

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

    /**
     * Sets the x,y values and draw the square default color white
     *
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
     */
    public static void setField(Graphics g, int x, int y) {
        g.setColor(new Color(255,255,255));
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);
    }

    /**
     * @return type of the field
     */
    public int returnType() {
        return type;
    }

}
