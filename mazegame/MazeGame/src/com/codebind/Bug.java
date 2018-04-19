package com.codebind;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author NoahTelussa
 * I made this in the lessons
 * Too lazy to write here comments, sorry :)
 *
 */
class Bug {
    private int coordX;
    private int coordY;
    private int direction;
    private String SYMBOL;
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;


    public Bug() {
        SYMBOL = "";
        direction = NORTH;
    }

    public Bug(String sym,int positionX,int positionY) {
        coordX = positionX;
        coordY = positionY;
        direction = NORTH;
        SYMBOL = sym;
    }

    public String toString(){
        return "Positie van " + SYMBOL + " Coord x :" + coordX + " Coord y :" + coordY+ " direction :" + direction;
    }

    public int getYPosition(){
        return coordY;
    }
    public int getXPosition(){
        return coordX;
    }
    public String getSymbol(){
        return SYMBOL;
    }

    public void move(){
        switch(direction){
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
    public int getDirection(){
        return direction;
    }

    //Turn the bug
    public void turn (int turns){
        direction = turns;
    }

}
