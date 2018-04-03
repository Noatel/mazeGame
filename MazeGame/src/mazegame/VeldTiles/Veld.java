/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame.VeldTiles;

/**
 *
 * @author Jordie
 */
abstract public class Veld {
    public int coordX;
    public int coordY;
    
    public Veld(int coordX, int coordY){
        this.coordX = coordX;
        this.coordY = coordY;
    }
    
}
