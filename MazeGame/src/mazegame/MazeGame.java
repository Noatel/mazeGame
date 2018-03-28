/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.awt.Graphics;

/**
 *
 * @author Jordie
 */
public class MazeGame {

    /**
     * @param args the command line arguments
     */
    
    private int dimX;
    private int dimY;
    
    static Grid grid = new Grid();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        System.exit(0);
    }
    
    public void paint(Graphics g){
        
        dimX = 60; // this is not the best solution
        dimY = 60; // for defining the size of the game!

        grid.calculateCorners(dimX, dimY);
        
        //for(int i = dimX; i < ) needs editing
    }
    
}