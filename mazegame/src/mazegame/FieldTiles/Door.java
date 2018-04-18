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
import java.util.ArrayList;
import java.util.List;
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
    public static int countDoors;

    //Create an empty door array for all door 
    public static List<Door> doors = new ArrayList<Door>();

    //Create an empty door array for open doors
    public static List<Door> openDoors = new ArrayList<Door>();

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
    public void paintField(Graphics g) {

        if (!this.closed) {
            //geeft de kleur de positie en de groote aan van het blok
            g.setColor(Color.ORANGE);
            g.fillRect(this.coordX, this.coordY, 30, 30);
            g.drawRect(this.coordX, this.coordY, 30, 30);

            //geeft attributes aan strings waardoor je de kleur kan veranderen 
            AttributedString as = new AttributedString(Integer.toString(this.pin));
            as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
            g.drawString(as.getIterator(), this.coordX + 5, this.coordY + 20);
        } else {
            System.out.println("OVERRIDE");
            g.setColor(new Color(255, 255, 255));
            g.fillRect(this.coordX, this.coordY, 30, 30);
            g.drawRect(this.coordX, this.coordY, 30, 30);
            g.drawString("", this.coordX + 5, this.coordY + 20);
        }
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
     * Set the door closed When its false, the door isnt closed so you can walk
     * through it When its true, the door is closed so you cant walk though it
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

    public static List<Door> returnDoor() {
        return doors;
    }

    public void clearDoor() {
        doors.clear();
    }

    public void addDoor(Door door) {
        if (Door.doors.size() <= Door.countDoors) {
            doors.add(door);
        }
    }

    public void addOpenDoor() {

        if (!Door.openDoors.isEmpty()) {
            for (Door openDoor : Door.openDoors) {
                System.out.println(!openDoor.equals(this));
                System.out.println("added door = " + openDoor.coordX + " - " + openDoor.coordY);
                if (!openDoor.equals(this)) {
                    System.out.println("not equal");
                    Door.openDoors.add(this);
                    break;
                }
            }
        } else {
            System.out.println("none");
            Door.openDoors.add(this);
        }

    }

    public void repaintDoor(Graphics g, Player player, Door door) {
        if (player.getXPosition() == door.coordX && player.getYPosition() == door.coordY) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(door.coordX, door.coordY, 30, 30);
            g.drawRect(door.coordX, door.coordY, 30, 30);

        }
    }
}
