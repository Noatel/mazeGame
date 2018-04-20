/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.FieldTiles;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author NoahTelussa
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({mazegame.FieldTiles.FieldTest.class, mazegame.FieldTiles.DoorTest.class, mazegame.FieldTiles.WallTest.class, mazegame.FieldTiles.EndTest.class, mazegame.FieldTiles.KeyTest.class})
public class FieldTilesSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
