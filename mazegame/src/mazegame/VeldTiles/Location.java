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
public class Location extends Veld {
    //Location can be a start or end locaiton
     int type;
     public Location(int coordX, int coordY,int type){
           super(coordX, coordY, type);
    }
}
