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
public class Key extends Veld{
   int type; 
   int collected;
   public Key(int coordX, int coordY,int collected, int type){
           super(coordX, coordY, type);
           this.type = type;
           this.collected = collected;
    }
}
