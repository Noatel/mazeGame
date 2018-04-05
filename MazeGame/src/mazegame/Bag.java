package mazegame;

import java.util.ArrayList;
import mazegame.FieldTiles.Key;

/**
 *
 * @author timwa
 */
public class Bag {
    // een array waar je de key aan kan toevoegen
    static ArrayList<Key> bag = new ArrayList<Key>();
    
    public static void addKey(Key key){
        bag.add(key);
    }

    public static ArrayList<Key> getBag() {
        return bag;
    }
}
