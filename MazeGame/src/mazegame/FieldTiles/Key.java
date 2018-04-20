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
 * @author Jordie voor uitleg over hoe de dingen werken zie Door.java
 */
public class Key extends Field {

    /**
     * Check if the key is collected ${collected}.
     */
    public static boolean collected;
    /**
     * A key got a pin that fits the door ${pin}.
     */
    private int pin;

    /**
     * Constructs a end point that needs the position of the x coordinate, y
     * coordinate and the type
     *
     * @param coordX coordinate of a field
     * @param coordY coordinate of a field
     * @param type type of the end point
     * @param pin the pin of the key that is connected to a door
     */
    public Key(int coordX, int coordY, int type, int pin) {
        super(coordX, coordY, type);
        this.pin = pin;
    }

    /**
     * Sets the x,y values of the key and draw it with the Graphics g
     * @param g use the Graphics g to draw the squares on the field
     */
    @Override
    public void paintField(Graphics g) {
        
        //Paint the square
        g.setColor(Color.magenta);
        g.fillRect(((this.getCoordX() + 1) * 30), ((this.getCoordY() + 1) * 30), 30, 30);
        g.drawRect(((this.getCoordX() + 1) * 30), ((this.getCoordY() + 1) * 30), 30, 30);

        //Paint the pincode insde the square
        AttributedString as = new AttributedString(Integer.toString(this.pin));
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), (((this.getCoordX() + 1) * 30)) + 5, ((this.getCoordY() + 1) * 30) + 20);

    }

    /**
     * @return collected keys that have been collected
     */
    public boolean isCollected() {
        return collected;
    }

    /**
     * Set the collected key status to collected (True or false)
     * @param collected see if the key is collected or not
     */
    public static void setCollected(boolean collected) {
        Key.collected = collected;
    }

    /**
     * @return pin that a key is assigned to
     */
    public int getPin() {
        return pin;
    }

    /**
     * Set key to a value
     * @param pin define the value of the pin
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

}
