/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.VeldTiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.ArrayList;

/**
 *
 * @author Jordie voor uitleg over hoe de dingen werken zie Door.java
 */
public class Key extends Veld {

    static int id;
    static boolean collected; // dit kijkt of de key is opgepakt of niet
    static int pin;

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
    
    public static void setKey(Graphics g, int x, int y,int pin, int id) {
        Veld.keys.add(new Key((x / 30), (y / 30), 1, id, pin));

        g.setColor(Color.magenta);
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);
        
        AttributedString as = new AttributedString(Integer.toString(pin));
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), x + 5, y + 20);
    }

    public static ArrayList<Key> getKey() {
        return Veld.keys;
    }

    public static boolean isCollected() {
        return collected;
    }

    public static void setCollected(boolean collected) {
        Key.collected = collected;
    }

    public static int getPin() {
        return pin;
    }

    public static void setPin(int pin) {
        Key.pin = pin;
    }
    
    public int getNonStaticPin(){
        return Key.pin;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Key.id = id;
    }
    
    public static void isPickedUp(){
        
    }
}
