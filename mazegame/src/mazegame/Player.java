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

    public void resetSetPosition() {
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
        boolean checkObstacle = false;
        switch (getDirection) {
            case 'n': //North
                //check if the player want's to go out of bounds
                if (this.coordY > 0) {
                    if (maze[this.coordY - 1][this.coordX].returnType() == 1) {
                        checkObstacle = true;
                    } else {
                        //Type 4 = Key 1
                        //Type 6 = Key 2
                        //Type 8 = Key 3
                        if (maze[this.coordY - 1][this.coordX].returnType() == 4 || maze[this.coordY - 1][this.coordX].returnType() == 6 || maze[this.coordY - 1][this.coordX].returnType() == 8) {
                            if (maze[this.coordY - 1][this.coordX] instanceof Key) {
                                Key key = (Key) maze[this.coordY - 1][this.coordX];
                                key.setCollected(true);
                                key.setHidden(true);
                                this.setKey(key);
                            }
                            checkObstacle = false;
                        } else {
                            //Type 3 = Door 1
                            //Type 5 = Door 2
                            //Type 7 = Door 3
                            if (maze[this.coordY - 1][this.coordX].returnType() == 3 || maze[this.coordY - 1][this.coordX].returnType() == 5 || maze[this.coordY - 1][this.coordX].returnType() == 7) {
                                if (maze[this.coordY - 1][this.coordX] instanceof Door) {
                                    Door door = (Door) maze[this.coordY - 1][this.coordX];
                                    if (this.bag != null && this.bag.pin == door.pin) {
                                        door.setHidden(true);
                                        checkObstacle = false;
                                    }else if (door.getHidden()) {
                                      checkObstacle = false;
                                    } else {
                                        checkObstacle = true;
                                    }
                                }

                            } else {
                                checkObstacle = false;
                            }
                        }
                    }

                    if (!checkObstacle) {
                        this.coordY--;
                        totalMoves++;
                    }
                }

                break;

            case 'e': //East
                if (this.coordX < 9) {
                    if (maze[this.coordY][this.coordX + 1].returnType() == 1) {
                        checkObstacle = true;
                    } else {
                        //Type 4 = Key 1
                        //Type 6 = Key 2
                        //Type 8 = Key 3
                        if (maze[this.coordY][this.coordX + 1].returnType() == 4 || maze[this.coordY][this.coordX + 1].returnType() == 6 || maze[this.coordY][this.coordX + 1].returnType() == 8) {
                            if (maze[this.coordY][this.coordX + 1] instanceof Key) {
                                Key key = (Key) maze[this.coordY][this.coordX + 1];
                                key.setCollected(true);
                                key.setHidden(true);
                                this.setKey(key);
                            }
                            checkObstacle = false;
                        } else {
                            //Type 3 = Door 1
                            //Type 5 = Door 2
                            //Type 7 = Door 3

                            if (maze[this.coordY][this.coordX + 1].returnType() == 3 || maze[this.coordY][this.coordX + 1].returnType() == 5 || maze[this.coordY][this.coordX + 1].returnType() == 7) {

                                if (maze[this.coordY][this.coordX + 1] instanceof Door) {
                                    Door door = (Door) maze[this.coordY][this.coordX + 1];
                                    if (this.bag != null && this.bag.pin == door.pin) {
                                        door.setHidden(true);
                                        checkObstacle = false;
                                    } else if (door.getHidden()) {
                                      checkObstacle = false;
                                    }else {
                                        checkObstacle = true;
                                    }
                                }

                            } else {
                                checkObstacle = false;
                            }
                        }
                    }

                    if (!checkObstacle) {

                        this.coordX++;
                        totalMoves++;
                    }
                }
                break;
            case 's': //South
                if (this.coordY < 9) {
                    if (maze[this.coordY + 1][this.coordX].returnType() == 1) {
                        checkObstacle = true;
                    } else {
                        //Type 4 = Key 1
                        //Type 6 = Key 2
                        //Type 8 = Key 3
                        if (maze[this.coordY + 1][this.coordX].returnType() == 4 || maze[this.coordY + 1][this.coordX].returnType() == 6 || maze[this.coordY + 1][this.coordX].returnType() == 8) {
                            if (maze[this.coordY + 1][this.coordX] instanceof Key) {
                                Key key = (Key) maze[this.coordY + 1][this.coordX];
                                key.setCollected(true);
                                key.setHidden(true);
                                this.setKey(key);
                            }
                            checkObstacle = false;
                        } else {
                            //Type 3 = Door 1
                            //Type 5 = Door 2
                            //Type 7 = Door 3

                            if (maze[this.coordY + 1][this.coordX].returnType() == 3 || maze[this.coordY + 1][this.coordX].returnType() == 5 || maze[this.coordY + 1][this.coordX].returnType() == 7) {

                                if (maze[this.coordY + 1][this.coordX] instanceof Door) {
                                    Door door = (Door) maze[this.coordY + 1][this.coordX];
                                    if (this.bag != null && this.bag.pin == door.pin) {
                                        door.setHidden(true);
                                        checkObstacle = false;
                                    } else if (door.getHidden()) {
                                      checkObstacle = false;
                                    }else {
                                        checkObstacle = true;
                                    }
                                }

                            } else {
                                checkObstacle = false;
                            }
                        }
                    }

                    if (!checkObstacle) {
                        this.coordY++;
                        totalMoves++;
                    }
                }
                break;
            case 'w': //West
                if (this.coordX > 0) {
                    if (maze[this.coordY][this.coordX - 1].returnType() == 1) {
                        checkObstacle = true;
                    } else {
                        //Type 4 = Key 1
                        //Type 6 = Key 2
                        //Type 8 = Key 3
                        if (maze[this.coordY][this.coordX - 1].returnType() == 4 || maze[this.coordY][this.coordX - 1].returnType() == 6 || maze[this.coordY][this.coordX - 1].returnType() == 8) {
                            if (maze[this.coordY][this.coordX - 1] instanceof Key) {
                                Key key = (Key) maze[this.coordY][this.coordX - 1];
                                key.setCollected(true);
                                key.setHidden(true);
                                this.setKey(key);
                            }
                            checkObstacle = false;
                        } else {
                            //Type 3 = Door 1
                            //Type 5 = Door 2
                            //Type 7 = Door 3
                            if (maze[this.coordY][this.coordX - 1].returnType() == 3 || maze[this.coordY][this.coordX - 1].returnType() == 5 || maze[this.coordY][this.coordX - 1].returnType() == 7) {
                                if (maze[this.coordY][this.coordX - 1] instanceof Door) {
                                    Door door = (Door) maze[this.coordY][this.coordX - 1];
                                    if (this.bag != null && this.bag.pin == door.pin) {
                                        door.setHidden(true);
                                        checkObstacle = false;
                                    } else if (door.getHidden()) {
                                      checkObstacle = false;
                                    } else {
                                        checkObstacle = true;
                                    }
                                }

                            } else {
                                checkObstacle = false;
                            }
                        }
                    }

                    if (!checkObstacle) {
                        this.coordX--;
                        totalMoves++;
                    }
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
