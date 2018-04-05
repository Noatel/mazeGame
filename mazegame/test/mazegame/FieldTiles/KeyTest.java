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
public class KeyTest {

    public KeyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of movePosition method, of class Key.
     */
    @Test
    public void testMovePosition() {
        System.out.println("movePosition");
        Key key = new Key(1, 1, 3, 100);
        Key.movePosition(key);
    }

    /**
     * Test of getKey method, of class Key.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        ArrayList<Key> expResult = Field.keys;
        ArrayList<Key> result = Key.getKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCollected method, of class Key.
     */
    @Test
    public void testIsCollected() {
        System.out.println("isCollected");
        boolean expResult = false;
        boolean result = Key.isCollected();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCollected method, of class Key.
     */
    @Test
    public void testSetCollected() {
        System.out.println("setCollected");
        boolean collected = false;
        Key.setCollected(collected);
    }

    /**
     * Test of getPin method, of class Key.
     */
    @Test
    public void testGetPin() {
        System.out.println("getPin");
        Key instance = new Key(1, 1, 3, 100);
        int expResult = 100;
        int result = instance.getPin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPin method, of class Key.
     */
    @Test
    public void testSetPin() {
        System.out.println("setPin");
        int pin = 100;
        Key instance = new Key(1, 1, 3, 100);
        instance.setPin(pin);
    }

   

    /**
     * Test of getId method, of class Key.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Key instance =  new Key(1, 1, 3, 100);
        int expResult = 3;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Key.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 3;
        Key instance = new Key(1, 1, 3, 100);
        instance.setId(id);
    }


}
