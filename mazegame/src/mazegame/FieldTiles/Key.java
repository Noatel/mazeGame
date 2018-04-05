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

/**
 *
 * @author Jordie voor uitleg over hoe de dingen werken zie Door.java
 */
public class Key extends Field {

   public static int id;
   public static boolean collected; // dit kijkt of de key is opgepakt of niet
   public static int pin;
    /**
     * Constructs a end point that needs the position of the x coordinate, y coordinate and the type
     * @param coordX coordinate of a field
     * @param coordY coordinate of a field
     * @param type type of the end point 
     * @param id id of the key 
     * @param pin the pin of the key that is connected to a door 
     */
    public Key(int coordX, int coordY, int type, int id, int pin) {
        super(coordX, coordY, type);
        
        Key.id = id;
        Key.pin = pin;
    }

//    public void setKey(Graphics g, int x, int y, int pin) {
//        this.pin = pin;
//        g.setColor(Color.magenta);
//        g.fillRect(x, y, 30, 30);
//        g.drawRect(x, y, 30, 30);
//
//        AttributedString as = new AttributedString(Integer.toString(pin));
//        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
//        g.drawString(as.getIterator(), x + 5, y + 20);
//    }
    
    /**
     * Sets the x,y values of the key and draw it with the Graphics g
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
    */
    public static void setKey(Graphics g, int x, int y,int pin, int id) {
//        System.out.println("create id : ");
//        System.out.println(id);
//        System.out.println("create pin : ");
//        System.out.println(pin);
        
            if(!Field.keys.contains(id)){
                    Field.keys.add(new Key((x / 30), (y / 30), 1, id, pin));
                    System.out.println(id);
        }
        g.setColor(Color.magenta);
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);
        
        AttributedString as = new AttributedString(Integer.toString(pin));
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), x + 5, y + 20);
    }

    /**
    * @return Field.Keys that got all the locations of the keys inside
    */
    public static ArrayList<Key> getKey() {
        return Field.keys;
    }
    
    /**
    * @return collected keys that have been collected
    */
    public static boolean isCollected() {
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
    public static int getPin() {
        return pin;
    }
    
    /**
    * Set key to a value
    * @param pin define the value of the pin
    */
    public static void setPin(int pin) {
        Key.pin = pin;
    }
    
    /**
     * 
    * @return Key.pin
    */
    public int getNonStaticPin(){
        return Key.pin;
    }
    
    /** Return the id of the key
    * @return id return the id of the key 
    */
    public static int getId() {
        return id;
    }

     /** Set the id of the key
    * @param id Set the id 
    */
    public static void setId(int id) {
        Key.id = id;
    }
    
    public static void isPickedUp(){
        
    }
    

}
