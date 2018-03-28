/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

/**
 *
 * @author Jordie
 */
public class Player {
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

    public void move() {
        switch (direction) {
            case NORTH: //North
                coordY++;
                break;
            case EAST: //East
                coordX++;
                break;
            case SOUTH: //South
                coordY--;
                break;
            case WEST: //West
                coordX--;
                break;
        }
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
        startCoordsX = x;
        startCoordsY = y;
    }
    public int getStartCoordsX(){
        return startCoordsX * 30;
    }
    public int getStartCoordsY(){
        return startCoordsY * 30;
    }

}
