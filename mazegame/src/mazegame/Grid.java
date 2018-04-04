/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.util.ArrayList;

/**
 *
 * @author Jordie
 */
public class Grid {
    //Corners, need to be filled (x,y)
    private int corners[][] = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
    public static ArrayList<int[]> map = new ArrayList<int[]>();


     public void calculateCorners(int x, int y) {
        //First corner/ left corner
        this.corners[0][0] = (x / 30);        //x = 2
        this.corners[0][1] = (y / 30);        //y = 2

        //Second corner/ right corner
        this.corners[1][0] = ((x * 10) / 30); //x = 20
        this.corners[1][1] = (y / 30);        //y = 2

        //Third corner/ left bottom corner
        this.corners[2][0] = (x / 30);        //x = 2
        this.corners[2][1] = ((x * 10) / 30); //y = 20

        //Third corner/ left bottom corner
        this.corners[3][0] = ((x * 10) / 30); //x = 20
        this.corners[3][1] = ((x * 10) / 30); //y = 20
    }
    public int[][] getCorners(){
        return corners;
    }
}
