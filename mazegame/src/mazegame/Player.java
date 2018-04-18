/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Color;
import java.awt.Graphics;
import mazegame.FieldTiles.Field;
import mazegame.FieldTiles.Key;

/**
 *
 * @author Jordie
 */
public class Player {

    private int coordX = 0;
    private int coordY = 0;
    public boolean startPosition = false;
    private int setPositionOneTime;

    public int totalMoves;
    public Key bag;

    public Player() {
    }

    public String toString() {
        return "Coord x :" + coordX + " Coord y :" + coordY;
    }

    public void setPosition(int x, int y) {
        if (setPositionOneTime == 0) {
            this.coordX = x - 1;
            this.coordY = y - 1;
            setPositionOneTime = 1;
        }
    }
    public void resetSetPosition(){
        setPositionOneTime = 0;
    }

    public int getYPosition() {
        return coordY;
    }

    public int getXPosition() {
        return coordX;
    }

    public void resetPlayer() {
        this.coordX = 1;
        this.coordY = 1;
        setPositionOneTime = 0;
    }

    public void move(char getDirection) {
        switch (getDirection) {
            case 'n': //North
                Field[][] maze = Grid.getMaze();
                System.out.println("type: " + maze[this.coordY][this.coordX].returnType() + " | CoordX: " + maze[this.coordY][this.coordX].getCoordX() + " | CoordY: " + maze[this.coordY][this.coordX].getCoordY() + " | Player X: " + this.coordX + " | Player Y: " + this.coordY);
                //check if the player want's to go out of bounds
                if (this.coordY > 0) {
                    this.coordY--;
                    totalMoves++;
                } else {
                }
                
                
                break;
            case 'e': //East

                if (this.coordX < 9) {
                    this.coordX++;
                    totalMoves++;
                } else {
                }
                break;
            case 's': //South
                if (this.coordY < 9) {
                    this.coordY++;
                    totalMoves++;
                } else {
                    //continue
                }
                break;
            case 'w': //West
                if (this.coordX > 0) {
                    this.coordX--;
                    totalMoves++;
                } else {
                }

                break;
        }
        MazeGame.label1.setText("Total Moves: " + totalMoves);
    }

    int getTotalMoves() {
        return totalMoves;
    }

    public void setKey(Key key) {
        this.bag = key;
    }

    public int checkKey() {
        return this.bag.pin;
    }


    public void paintPlayer(Graphics g) {
        if (!startPosition) {
            g.setColor(Color.RED);
            g.fillRect(this.coordX, this.coordY, 30, 30);
            g.drawRect(this.coordX, this.coordY, 30, 30);
            startPosition = true;
        } else {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(this.coordX, this.coordY, 30, 30);
            g.drawRect(this.coordX, this.coordY, 30, 30);
        }
    }
    

}
