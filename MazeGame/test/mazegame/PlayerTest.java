/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author timwa
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

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Player instance = new Player();
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPosition method, of class Player.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        Player instance = new Player();
        int x = 0;
        int y = 0;
        instance.setPosition(x, y);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getYPosition method, of class Player.
     */
    @Test
    public void testGetYPosition() {
        System.out.println("getYPosition");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getYPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getXPosition method, of class Player.
     */
    @Test
    public void testGetXPosition() {
        System.out.println("getXPosition");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getXPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of resetPlayer method, of class Player.
     */
    @Test
    public void testResetPlayer() {
        System.out.println("resetPlayer");
        Player instance = new Player();

        instance.resetPlayer();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        char getDirection = 's';
        Player instance = new Player();
        instance.move(getDirection);
        int expResult = 1;
        int result = instance.getYPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
