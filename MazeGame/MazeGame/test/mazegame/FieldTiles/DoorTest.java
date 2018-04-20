/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.FieldTiles;

import java.awt.Graphics;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NoahTelussa
 */
public class DoorTest {

    public DoorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of openDoor method, of class Door.
     */
    @Test
    public void testOpenDoor() {
        System.out.println("openDoor");
        int pinCode = 0;
        Door instance = new Door(1, 1, 100, 4);
        boolean expResult = true;
        boolean result = instance.openDoor(pinCode);
        assertEquals(expResult, result);

    }

    /**
     * Test of isClosed method, of class Door.
     */
    @Test
    public void testIsClosed() {
        System.out.println("isClosed");
        int pinCode = 100;
        boolean expResult = false;
        boolean result = Door.isClosed(pinCode);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setClosed method, of class Door.
     */
    @Test
    public void testSetClosed() {
        System.out.println("setClosed");
        boolean closed = false;
        Door instance = new Door(1, 1, 100, 4);
        instance.setClosed(closed);
    }

    /**
     * Test of getPin method, of class Door.
     */
    @Test
    public void testGetPin() {
        System.out.println("getPin");
        Door instance = new Door(1, 1, 100, 4);
        int expResult = 100;
        int result = instance.getPin();
        assertEquals(expResult, result);
    }
}
