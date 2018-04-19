/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NoahTelussa
 */
public class LevelTest {

    public LevelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of loadLevel method, of class Level.
     */
    @Test
    public void testLoadLevel() {
        System.out.println("loadLevel");
        int level = 1;
        ArrayList expResult = Grid.map;
        ArrayList result = Level.loadLevel(level);
        assertEquals(expResult, result);
    }

    /**
     * Test of restart method, of class Level.
     */
    @Test
    public void testRestart() {
        System.out.println("restart");
        JFrame window = new JFrame();
        Level.restart(window);
    }

}
