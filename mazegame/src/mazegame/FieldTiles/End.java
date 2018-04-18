package mazegame.FieldTiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

/**
 *
 * @author timwa
 */
public class End extends Field{
    
    public static int[] endLocation = new int[2];

    /**
     * Constructs a end point that needs the position of the x coordinate, y coordinate and the type
     * @param coordX coordinate of a field
     * @param coordY coordinate of a field
     * @param type type of the end point 
     */
    public End(int coordX, int coordY, int type) {
        super(coordX, coordY, type);
    }
    
     /**
     * Set the endPoint and draw it on the JFrame
     * @param g use the Graphics g to draw the squares on the field
     * @param x coordinate of a field
     * @param y coordinate of a field
    */
    @Override
    public void paintField(Graphics g) {
        /*
        Sla de eindlocatie op
        */
        endLocation[0] = (this.getCoordX() / 30);
        endLocation[1] = (this.getCoordY() / 30);
        
        /*
        geeft de kleur de positie en de groote aan van het blok
        */
        g.setColor(Color.GREEN);
        g.fillRect(this.getCoordX(), this.getCoordY(), 30, 30);
        g.drawRect(this.getCoordX(), this.getCoordY(), 30, 30);
        
        /*
        geeft attributes aan strings waardoor je de kleur kan veranderen
        */
        AttributedString as = new AttributedString("End");
        as.addAttribute(TextAttribute.FOREGROUND, Color.BLACK);
        g.drawString(as.getIterator(), this.getCoordX() + 5, this.getCoordY() + 20);
    }
}
