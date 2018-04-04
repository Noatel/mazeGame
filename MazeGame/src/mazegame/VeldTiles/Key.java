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
 * voor uitleg over hoe de dingen werken zie Door.java
 */
public class Key extends Veld {

    boolean collected; // dit kijkt of de key is opgepakt of niet
    int pin;

    public Key(int coordX, int coordY, int type) {
        super(coordX, coordY, type);
    }

    public void setKey(Graphics g, int x, int y, int pin) {
        this.pin = pin;
        g.setColor(Color.magenta);
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);

        AttributedString as = new AttributedString(Integer.toString(pin));
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), x + 5, y + 20);
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public void oppakken() {
        this.collected = true;
    }
}
