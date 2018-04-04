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

/**
 *
 * @author Jordie
 */
public class Door extends Veld {

    private int pin;
    private boolean closed;

    public Door(int coordX, int coordY, int type) {
        super(coordX, coordY, type);
    }

    public void setDoor(Graphics g, int x, int y, int pin) {

        //zet de geven pin als de pin van het object
        this.pin = pin;

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
    public void openDoor(Key key) {
        if (key.pin == pin) {
            closed = false;
            key.setCollected(false);
        }
    }
    
    // voor jordie cause he fucked up
}
