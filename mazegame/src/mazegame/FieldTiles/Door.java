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

    public Door(int coordX, int coordY, int type) {
        super(coordX, coordY, type);
    }

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

    //dit kijkt eerst of de key pin klopt met deze pin daarna zet hij de deur op false
    public static boolean openDoor(int pin) {
        if (pin == Door.pin) {
            closed = false;
            Key.setCollected(false);
            return false;
        }
        
        return true;
    }

    public static boolean isClosed() {
        return closed;
    }

    public static void setClosed(boolean closed) {
        Door.closed = closed;
    }
    
    
}
