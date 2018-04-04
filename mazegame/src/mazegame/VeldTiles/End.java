package mazegame.VeldTiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

/**
 *
 * @author timwa
 */
public class End extends Veld{
    
    public End(int coordX, int coordY, int type) {
        super(coordX, coordY, type);
    }
    
    public static void setEnd(Graphics g, int x, int y) {
        
        /*
        geeft de kleur de positie en de groote aan van het blok
        */
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 30, 30);
        g.drawRect(x, y, 30, 30);
        
        /*
        geeft attributes aan strings waardoor je de kleur kan veranderen
        */
        AttributedString as = new AttributedString("End");
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), x + 5, y + 20);
    }
}