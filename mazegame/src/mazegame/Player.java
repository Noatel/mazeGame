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

    private static int coordX;
    private static int coordY;
    public static int setPositionOneTime;
    public static int totalMoves;

    public Player() {
    }

    public String toString() {
        return "Coord x :" + coordX + " Coord y :" + coordY;
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

    public static void resetPlayer() {
        coordX = 1;
        coordY = 1;
        setPositionOneTime = 0;
    }

    public void move(char getDirection) {
        switch (getDirection) {
            case 'n': //North
                if (coordY > 1) {
                    coordY--;
                    totalMoves++;
                } else {
                }
                break;
            case 'e': //East

                if (coordX < 10) {
                    coordX++;
                    totalMoves++;
                } else {
                }
                break;
            case 's': //South
                if (coordY < 10) {
                    coordY++;
                    totalMoves++;
                } else {
                    //continue
                }
                break;
            case 'w': //West
                if (coordX > 1) {
                    coordX--;
                    totalMoves++;
                } else {
                }

                break;
        }
        MazeGame.label1.setText("Total Moves: " + totalMoves);
    }
}
