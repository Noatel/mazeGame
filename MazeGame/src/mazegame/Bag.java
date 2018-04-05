package mazegame;

import java.util.ArrayList;
import java.util.List;
import mazegame.FieldTiles.Key;

/**
 * When a player collect a key it sends the key to the bag. After it the player
 * can open a door with the correct key
 *
 * @author timwa
 */
public class Bag {

    // Create a array that holds all the key
    public static int bag;
    public static List<Integer> alreadyCollected = new ArrayList<Integer>(3);

    /**
     * If a player collect a key add it to the bag
     *
     * @param key collect the key and put it in the bag
     */
    public static void addKey(Key key) {
        bag = key.pin;
        alreadyCollected.add(key.pin);
    }

    /**
     * Return the bag with a key inside of it.
     *
     * @return bag return the bag with the key inside of it
     */
    public static int getBag() {
        return bag;
    }

    public static boolean collected(int pin) {
        return alreadyCollected.contains(pin);
    }
}
