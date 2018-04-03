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
public class Door extends Veld{
   int closed; 
   public Door(int coordX, int coordY, int type, int closed){
           super(coordX, coordY, type);
           this.closed = closed;
    }
}
