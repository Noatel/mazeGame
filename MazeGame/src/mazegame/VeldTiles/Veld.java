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
    public int type;
    
    public Veld(int coordX, int coordY, int type){
        this.coordX = coordX;
        this.coordY = coordY;
        this.type = type;
    }
   
    public int returnType(){
        return type;
    }
    
}
