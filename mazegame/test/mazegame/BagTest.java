/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import static mazegame.Bag.bag;
import mazegame.FieldTiles.Key;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NoahTelussa
 */
public class BagTest {

    public BagTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addKey method, of class Bag.
     */
    @Test
    public void testAddKey() {
        System.out.println("addKey");
        Key key = new Key(1, 1, 3, 100);
        Bag.addKey(key);
        // TODO review the generated test code and remove the default call to fail.
        int expResult = bag;
        int result = key.pin;
        assertEquals(expResult, result);
    }

    /**
     * Test of getBag method, of class Bag.
     */
    @Test
    public void testGetBag() {
        System.out.println("getBag");
        int expResult = bag;
        int result = Bag.getBag();
        assertEquals(expResult, result);
    }

    /**
     * Test of collected method, of class Bag.
     */
    @Test
    public void testCollected() {
        System.out.println("collected");
        int pin = 100;
        boolean expResult = false;
        boolean result = Bag.collected(pin);
        assertEquals(expResult, result);
    }

}
