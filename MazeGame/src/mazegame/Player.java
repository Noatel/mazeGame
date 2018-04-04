/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import static java.awt.SystemColor.window;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jordie
 */
public class Player{
    private int coordX;
    private int coordY;
    private int direction;
    private String SYMBOL;
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private int setPositionOneTime;
    private int startCoordsX;
    private int startCoordsY;
    
    public Player(){
        direction = NORTH;
}
    
    public String toString() {
        return "Coord x :" + coordX + " Coord y :" + coordY + " direction :" + direction;
    }

    public void setPosition(int x, int y) {
        if (setPositionOneTime == 0) {
            coordX = x;
            coordY = y;
            setPositionOneTime = 1;
        }
    }

    public int getYPosition() {
        return coordY;
    }

    public int getXPosition() {
        return coordX;
    }

    public String getSymbol() {
        return SYMBOL;
    }   

    public void move(char getDirection) {
        switch (getDirection) {
            case 'n': //North
                if(coordY > 0){
                    coordY--;
                }else{
                    System.out.println("You reached the border");
                }
                System.out.println("Up");
                break;
            case 'e': //East
                if(coordX < 10){
                coordX++;
                }else{
                    System.out.println("You reached the border");
                }
                System.out.println("Right");
                break;
            case 's': //South
                if(coordY < 10){
                    coordY++;
                }else{
                    System.out.println("You reached the border");
                    //continue
                }
                System.out.println("Down");
                break;
            case 'w': //West
                if(coordX > 0){
                    coordX--;
                }else{
                    System.out.println("You reached the border");
                }
                
                System.out.println("Left");
                break;
        }
        
        System.out.println("coordX: " + coordX + " coordY: " + coordY);
        
    }

    //get the direction of the bug
    public int getDirection() {
        return direction;
    }

    //Turn the bug
    public void turn(int turns) {
        direction = turns;
    }

    public void saveStartCoords(int x , int y){
        startCoordsX = x + 1;
        startCoordsY = y + 1;
    }
    public int getStartCoordsX(){
        return startCoordsX * 15;
    }
    public int getStartCoordsY(){
        return startCoordsY * 15;
    }

}
