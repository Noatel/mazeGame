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

    static int pin;
    static boolean closed;

     /**
     * Constructs a door that needs the position of the x coordinate, y coordinate and the type
     * @param coordX coordinate of a field
     * @param coordY coordinate of a field
     * @param type type of the door 
     */
    public Door(int coordX, int coordY, int type) {
        super(coordX, coordY, type);
    }

     /**
     * Set the door and Draw it on the JFrame
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
     * @param pin each door got a specific pin that is connected to a key
    */
    public static void setDoor(Graphics g, int x, int y, int pin) {

        //zet de geven pin als de pin van het object
        Door.pin = pin;

        //geeft de kleur de positie en de groote aan van het blok
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);

        //geeft attributes aan strings waardoor je de kleur kan veranderen 
        AttributedString as = new AttributedString(Integer.toString(pin));
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), x + 5, y + 20);
    }

     /**
     * Open the door and set {@closed} to open. If the key is wrong it doenst open the door
     * @param pin Each door got a specific pin that is connected to a key
     * @return if the door is opend or closed
     */
    public static boolean openDoor(int pin) {
        if (pin == Door.pin) {
            closed = false;
            Key.setCollected(false);
            return false;
        }
        
        return true;
    }

     /**
     * See if the door is closed or open  (True / false)
     * @return closed Check if the door is open or closed
     */
    public static boolean isClosed() {
        return closed;
    }

     /**
     * Set the door closed 
     * @param closed Check if the door is open or closed
     */
    public static void setClosed(boolean closed) {
        Door.closed = closed;
    }
    
    
}
