package com.akgs.algo.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * Solves https://leetcode.com/problems/spiral-matrix
     */
    static final int[][] directions = new int[4][];
    static final int LEFT_TO_RIGHT = 0;
    static final int TOP_TO_DOWN = 1;
    static final int RIGHT_TO_LEFT = 2;
    static final int DOWN_TO_TOP = 3;
    static {
        directions[LEFT_TO_RIGHT] = new int[]{0, 1};
        directions[TOP_TO_DOWN] = new int[]{1, 0};
        directions[RIGHT_TO_LEFT] = new int[]{0, -1};
        directions[DOWN_TO_TOP] = new int[]{-1, 0};
    }
    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9,10,11,12};
        spiralMatrix(matrix).stream().forEach(System.out::println);
        //geekForGeekSpiralMatrix(matrix).stream().forEach(System.out::println);
    }
    public static List<Integer> geekForGeekSpiralMatrix(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int lowerX=0, upperX=rows-1, lowerY=0, upperY=cols-1;
        while(lowerX<=upperX && lowerY <= upperY){
            
            for(int i=lowerY;i<=upperY;i++){
                result.add(matrix[lowerX][i]);
            }
            lowerX++;
            for(int i=lowerX;i<=upperX;i++){
                result.add(matrix[i][upperY]);
            }
            upperY--;
            if (lowerX <= upperX) {
                for (int i = upperY; i >= lowerY; i--) {
                    result.add(matrix[upperX][i]);
                }
            }
            upperX--;
            if (lowerY <= upperY) {
                for (int i = upperX; i >= lowerX; i--) {
                    result.add(matrix[i][lowerY]);
                }
            }
            lowerY++;
        }
        return result;
    }
    
    public static List<Integer> spiralMatrix(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix == null && matrix.length == 0){
            return result;
        }
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int total = (rows+1) * (cols+1);
        int curr = 0, direction = 0;
        int x = 0, y = 0, spiral = 0;
        
        while(curr < total){
            result.add(matrix[x][y]);
            curr++;
            int lowerX = spiral;
            int upperX = rows - spiral;
            int lowerY = spiral;
            int upperY = cols - spiral;
            
            if((x == upperX && y == lowerY && direction == RIGHT_TO_LEFT) || 
                    (x == lowerX && y == upperY && direction == LEFT_TO_RIGHT) || 
                    (x == upperX && y == upperY && direction == TOP_TO_DOWN)){
                direction = changeDirection(directions, direction);
            }
            else if(x == lowerX + 1 && y == lowerY && direction == DOWN_TO_TOP){
                spiral++;
                direction = changeDirection(directions, direction);
            }
            
            x = x + directions[direction][0];
            y = y + directions[direction][1];
        }
        return result;
    }
    
    public static int changeDirection(int[][] directions, int direction){
        return (direction + 1) % directions.length; 
    }
}
