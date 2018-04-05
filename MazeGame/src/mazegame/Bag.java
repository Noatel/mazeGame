package mazegame;

import java.util.ArrayList;
import mazegame.FieldTiles.Key;

/**
 * When a player collect a key it sends the key to the bag. 
 * After it the player can open a door with the correct key
 * @author timwa
 */
public class Bag {
    // Create a array that holds all the key
    static ArrayList<Key> bag = new ArrayList<Key>();
    
    /**
    * If a player collect a key add it to the bag
    * @param key collect the key and put it in the bag
    */
    public static void addKey(Key key){
        bag.add(key);
    }

     /**
    * Return the bag with a key inside of it.
    * @return bag return the bag with the key inside of it
    */
    public static ArrayList<Key> getBag() {
        return bag;
    }
}
