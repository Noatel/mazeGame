/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.FieldTiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

/**
 *
 * @author Jordie
 */
public class Door extends Field {

    /**
     * A key got a pin that fits the door ${pin}.
     */
    public int pin;

    /**
     * Keeps track of the door if its closed or open ${closed}.
     */
    public boolean closed;

    /**
     * Create a constant to check the door pin ${DOOR1}
     */
    public static final int DOOR1 = 100;
     /**
     * Create a constant to check the door pin ${DOOR2}
     */
    public static final int DOOR2 = 200;
     /**
     * Create a constant to check the door pin ${DOOR3}
     */
    public static final int DOOR3 = 300;

    /**
     * Constructs a door that needs the position of the x coordinate, y
     * coordinate and the type
     *
     * @param coordX coordinate of a field
     * @param coordY coordinate of a field
     * @param pinCode code of the key
     * @param type type of the door
     */
    public Door(int coordX, int coordY, int pinCode, int type) {
        super(coordX, coordY, type);

        //zet de geven pin als de pin van het object
        pin = pinCode;
    }

    /**
     * Set the door and Draw it on the JFrame
     * @param g use the Graphics g to draw the squares on the field
     */
    @Override
    public void paintField(Graphics g) {

        //Paint the square
        g.setColor(Color.ORANGE);
        g.fillRect(((this.getCoordX() + 1) * 30), ((this.getCoordY() + 1) * 30), 30, 30);
        g.drawRect(((this.getCoordX() + 1) * 30), ((this.getCoordY() + 1) * 30), 30, 30);

        //Paint the pincode insde the square
        AttributedString as = new AttributedString(Integer.toString(this.pin));
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), (((this.getCoordX() + 1) * 30)) + 5, ((this.getCoordY() + 1) * 30) + 20);

    }

    /**
     * Set the door closed When its false, the door isn't closed so you can walk
     * through it When its true, the door is closed so you cant walk though it
     *
     * @param closed Check if the door is open or closed
     */
    public void setClosed(boolean closed) {
        closed = closed;
    }

     /**
     * @return returns the pin of the door
     */
    public int getPin() {
        return pin;
    }
}
