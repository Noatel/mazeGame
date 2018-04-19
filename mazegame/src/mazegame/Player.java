/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Color;
import java.awt.Graphics;
import mazegame.FieldTiles.Door;
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
    Field[][] maze = Grid.getMaze();

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

    public void clearBag() {
        this.bag = null;
    }

    public int getYPosition() {
        return coordY;
    }

    public int getXPosition() {
        return coordX;
    }

    public void resetPlayer() {
        this.coordX = 0;
        this.coordY = 0;
        setPositionOneTime = 0;
    }

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

        if (maze[this.coordY][this.coordX].returnType() == 9) {
            if (Level.currentLevel < 3) {
                Level.currentLevel++;
                System.out.println("you made it!");
                //Clear the level before if there is one
                this.clearBag();

                Level.loadLevel(Level.currentLevel);
                resetPlayer();
            } else {
                System.exit(0);
            }

        }
        MazeGame.label1.setText("Total Moves: " + totalMoves);
    }

    public boolean canWalk(String coord, String sign) {
        boolean checkObstacle = false;
        int coordY = this.coordY;
        int coordX = this.coordX;

        //If its equals the y coord
        System.out.println("coord =" + coord);
        System.out.println("sign =" + sign);
        
        System.out.println("check" + coord.equals("y"));
        System.out.println("check" + sign.equals("+"));
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

        System.out.println("old " + maze[this.coordY][this.coordX + 1].returnType());
        System.out.println("(" + this.coordY + "," + this.coordX + ")");
        System.out.println("new " + maze[coordY][coordX].returnType());
        System.out.println("(" + coordY + "," + coordX + ")");

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
                        if (this.bag != null && this.bag.pin == door.pin) {
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
        System.out.println("Done" + checkObstacle);
        return checkObstacle;

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
