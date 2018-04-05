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
public class Player{
    private static int coordX;
    private static int coordY;
    private int direction;
    private String SYMBOL;
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    public static int setPositionOneTime;
    private int startCoordsX;
    private int startCoordsY;
    public static int totalMoves;
    
    public Player(){
        direction = NORTH;
}
    
    public String toString() {
        return "Coord x :" + coordX + " Coord y :" + coordY + " direction :" + direction;
    }

    public static void setPosition(int x, int y) {
        if (setPositionOneTime == 0) {
            coordX = x + 1;
            coordY = y + 1;
            setPositionOneTime = 1;
        }
    }

    public int getYPosition() {
        return coordY;
    }

    public int getXPosition() {
        return coordX;
    }
    
    public static void resetPlayer(){
        coordX = 1;
        coordY = 1;
        setPositionOneTime = 0;
    }

    public String getSymbol() {
        return SYMBOL;
    }   

    public void move(char getDirection) {
        
        
        
        switch (getDirection) {
            case 'n': //North
                if(coordY > 1){
                    coordY--;
                    totalMoves++;
                }else{
                    System.out.println("You reached the border");
                }
                System.out.println("Up");
                break;
            case 'e': //East
                if(coordX < 10){
                coordX++;
                totalMoves++;
                }else{
                    System.out.println("You reached the border");
                }
                System.out.println("Right");
                break;
            case 's': //South
                if(coordY < 10){
                    coordY++;
                    totalMoves++;
                }else{
                    System.out.println("You reached the border");
                    //continue
                }
                System.out.println("Down");
                break;
            case 'w': //West
                if(coordX > 1){
                    coordX--;
                    totalMoves++;
                }else{
                    System.out.println("You reached the border");
                }
                
                System.out.println("Left");
                break;
        }
        MazeGame.label1.setText("Total Moves: " + totalMoves);
    }

    //get the direction of the bug
    public int getDirection() {
        return direction;
    }

    //Turn the bug
    public void turn(int turns) {
        direction = turns;
    }

    public int getStartCoordsX(){
        return startCoordsX * 15;
    }
    public int getStartCoordsY(){
        return startCoordsY * 15;
    }

}
