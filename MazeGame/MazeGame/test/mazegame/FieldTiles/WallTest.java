/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.FieldTiles;

import java.awt.Graphics;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NoahTelussa
 */
public class WallTest {
    
    public WallTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of getWall method, of class Wall.
     */
    @Test
    public void testGetWall() {
        System.out.println("getWall");
        ArrayList<Wall> expResult = Field.walls;
        ArrayList<Wall> result = Wall.getWall();
        assertEquals(expResult, result);
    }
    
}
