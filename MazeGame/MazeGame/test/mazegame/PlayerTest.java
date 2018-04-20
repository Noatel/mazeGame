/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NoahTelussa
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Player instance = new Player();
        String expResult = "Coord x :1 Coord y :1";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPosition method, of class Player.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int x = 0;
        int y = 0;
        Player.setPosition(x, y);
    }

    /**
     * Test of getYPosition method, of class Player.
     */
    @Test
    public void testGetYPosition() {
        System.out.println("getYPosition");
        Player instance = new Player();
        instance.setPosition(1,1);
        int expResult = 2;
        int result = instance.getYPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getXPosition method, of class Player.
     */
    @Test
    public void testGetXPosition() {
        System.out.println("getXPosition");
        Player instance = new Player();
        instance.setPosition(1,1);
        int expResult = 2;
        int result = instance.getXPosition();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of resetPlayer method, of class Player.
     */
    @Test
    public void testResetPlayer() {
        System.out.println("resetPlayer");
        Player.resetPlayer();
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        char getDirection = ' ';
        Player instance = new Player();
        instance.move(getDirection);
    }

}
