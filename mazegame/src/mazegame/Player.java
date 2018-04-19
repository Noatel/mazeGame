/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Color;
import java.awt.Graphics;
import mazegame.FieldTiles.Door;
import mazegame.FieldTiles.Key;
import static mazegame.Grid.maze;

/**
 *
 * @author Jordie
 */
public class Player {

    /**
     * Create the coordX of the player ${coordX}.
     */
    private int coordX = 0;
    /**
     * Create the coordY of the player ${coordY}.
     */
    private int coordY = 0;

    /**
     * Create the startPosition ${startPosition}.
     */
    public boolean startPosition = false;
    /**
     * create the setPositionOneTime variable to draw it one time ${collected}.
     */
    private int setPositionOneTime;

    /**
     * keep track of the total moves per level ${totalMoves}.
     */
    public int totalMoves;
    /**
     * Keep track of the key that the player has collected ${bag}.
     */
    public Key bag;

    public Player() {
    }

    /**
     * Set the position of the player
     *
     * @param x Set the x position of the player
     * @param y Set the y position of the player
     */
    public void setPosition(int x, int y) {
        if (setPositionOneTime == 0) {
            this.coordX = x - 1;
            this.coordY = y - 1;
            setPositionOneTime = 1;
        }
    }

    /**
     * Set the bag to null
     *
     */
    public void clearBag() {
        this.bag = null;
    }

    /**
     * @return coordY returns the coordY position of the player
     */
    public int getYPosition() {
        return coordY;
    }

    /**
     * @return coordX returns the coordY position of the player
     */
    public int getXPosition() {
        return coordX;
    }

    /**
     * Reset the player
     */
    public void resetPlayer() {
        this.coordX = 0;
        this.coordY = 0;
        setPositionOneTime = 0;
    }

    /**
     * Move the player
     *
     * @param getDirection Char for the movement of the player
     */
    public void move(char getDirection) {
        boolean checkObstacle = false;
        switch (getDirection) {
            case 'n': //North
                //check if the player want's to go out of bounds
                if (this.coordY > 0) {
                    checkObstacle = this.canWalk("y", "-");
                    if (!checkObstacle) {
                        this.coordY--;
                        totalMoves++;
                    }
                }
                break;
            case 'e': //East
                if (this.coordX < 9) {
                    checkObstacle = this.canWalk("x", "+");
                    if (!checkObstacle) {
                        this.coordX++;
                        totalMoves++;
                    }
                }
                break;
            case 's': //South
                if (this.coordY < 9) {
                    checkObstacle = this.canWalk("y", "+");
                    if (!checkObstacle) {
                        this.coordY++;
                        totalMoves++;
                    }
                }
                break;
            case 'w': //West
                if (this.coordX > 0) {
                    checkObstacle = this.canWalk("x", "-");
                    if (!checkObstacle) {
                        this.coordX--;
                        totalMoves++;
                    }
                }
                break;
        }

        //Check if the player finished the level
        this.checkFinish();

        //Set the text of the moves
        MazeGame.label1.setText("Total Moves: " + totalMoves);
    }

    /**
     * @param coord check if the coordinate is a x or y
     * @param sign check if the sign is a - or +
     */
    private boolean canWalk(String coord, String sign) {
        boolean checkObstacle = false;
        int coordY = this.coordY;
        int coordX = this.coordX;

        if (coord.equals("y")) {
            //See if you need to increase or decrease the y
            if (sign.equals("-")) {
                //Decrease
                coordY = this.coordY - 1;
                coordX = this.coordX;
            } else if (sign.equals("+")) {
                //Increase
                coordY = this.coordY + 1;
                coordX = this.coordX;
            }
        } else if (coord.equals("x")) {
            if (sign.equals("-")) {
                //Decrease
                coordY = this.coordY;
                coordX = this.coordX - 1;
            } else if (sign.equals("+")) {
                //Increase
                coordY = this.coordY;
                coordX = this.coordX + 1;
            }
        }

        //If the type is a wall
        if (maze[coordY][coordX].returnType() == 1) {
            checkObstacle = true;
            return checkObstacle;
        } else {
            //Type 4 = Key 1
            //Type 6 = Key 2
            //Type 8 = Key 3
            if (maze[coordY][coordX].returnType() == 4 || maze[coordY][coordX].returnType() == 6 || maze[coordY][coordX].returnType() == 8) {
                if (maze[coordY][coordX] instanceof Key) {
                    Key key = (Key) maze[coordY][coordX];
                    if (!key.getHidden()) {
                        key.setCollected(true);
                        key.setHidden(true);
                        this.setKey(key);
                    }
                }
                checkObstacle = false;
                return checkObstacle;

            } else {
                //Type 3 = Door 1
                //Type 5 = Door 2
                //Type 7 = Door 3
                if (maze[coordY][coordX].returnType() == 3 || maze[coordY][coordX].returnType() == 5 || maze[coordY][coordX].returnType() == 7) {
                    if (maze[coordY][coordX] instanceof Door) {
                        Door door = (Door) maze[coordY][coordX];
                        if (this.bag != null && this.bag.getPin() == door.pin) {
                            door.setHidden(true);
                            checkObstacle = false;
                            return checkObstacle;

                        } else if (door.getHidden()) {
                            checkObstacle = false;
                            return checkObstacle;

                        } else {
                            checkObstacle = true;
                            return checkObstacle;

                        }
                    }

                } else {
                    checkObstacle = false;
                    return checkObstacle;

                }
            }
        }
        return checkObstacle;
    }

    /**
     * @return totalMoves the moves the player made
     */
    int getTotalMoves() {
        return totalMoves;
    }

    /**
     * @param key set the key into the players bag
     */
    public void setKey(Key key) {
        this.bag = key;
    }

    /**
     * @return this.bag.pin Returns the key pin of the player
     */
    public int checkKey() {
        return this.bag.getPin();
    }

    /**
     * @param g Paint the player
     */
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

    private void checkFinish() {
        if (maze[this.coordY][this.coordX].returnType() == 9) {
            if (Level.currentLevel < 3) {
                Level.currentLevel++;
                //Clear the level before if there is one
                this.clearBag();

                Level.loadLevel(Level.currentLevel);
                resetPlayer();
            } else {
                MazeGame.exitWindow();
            }

        }
    }

}
