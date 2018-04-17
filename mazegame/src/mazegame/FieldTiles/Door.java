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
import mazegame.Player;

/**
 *
 * @author Jordie
 */
public class Door extends Field {

    public int pin;
    public boolean closed;
    public static final int DOOR1 = 100;
    public static final int DOOR2 = 200;
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
     *
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
     * @param pinCode each door got a specific pin that is connected to a key
     * @param type of a field
     */
    @Override
    public void paintField(Graphics g, int x, int y) {

        //geeft de kleur de positie en de groote aan van het blok
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);

        //geeft attributes aan strings waardoor je de kleur kan veranderen 
        AttributedString as = new AttributedString(Integer.toString(this.pin));
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), x + 5, y + 20);
    }

    /**
     * If the key is wrong it doesn't open the door
     *
     * @param pinCode Each door got a specific pin that is connected to a key
     * @return if the door is opened or closed
     */
    public boolean openDoor(int pinCode) {
        if (pin == pinCode) {
            closed = false;
            Key.setCollected(false);
            return false;
        }

        return true;
    }

    /**
     * See if the door is closed or open (True / false)
     *
     * @param pinCode code of the key
     * @return closed Check if the door is open or closed
     */
    public static boolean isClosed(int pinCode) {
//        for (Door doors : Field.doors) {
//            if (doors.pin == pinCode) {
//                doors.closed = false;
//
//                return doors.closed;
//            }
//
//        }
        return false;
    }

    /**
     * Set the door closed
     *
     * @param closed Check if the door is open or closed
     */
    public void setClosed(boolean closed) {
        closed = closed;
    }

    public int getPin() {
        return pin;
    }

    public void changeLocation(Door doors) {
        doors.coordX = Field.NEW_COORDS;
        doors.coordY = Field.NEW_COORDS;

    }

    public void openDoor(Graphics g) {
        Player player = new Player();
        
     if (Door.isClosed(this.pin) != true && player.checkKey() == this.pin) {
                            g.setColor(new Color(255, 255, 255));
                            g.fillRect(this.coordX, this.coordY, 30, 30);
                            g.drawRect(this.coordX, this.coordY, 30, 30);
     }
    }

}
