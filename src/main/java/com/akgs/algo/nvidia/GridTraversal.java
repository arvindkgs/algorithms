package com.akgs.algo.nvidia;

import java.util.ArrayList;
import java.util.List;

public class GridTraversal {
    public static void main(String[] args) {
        /**
         * A robot is placed on an infinite 2D grid. The robot is initially facing the east direction. It moves in a spiral movement turning to its left after each move. The movements are given as an input array.
         * For example, assume the Robot is initially at (x,y) and the movement array is [4,3,5,2,1,6,...].
         * x = 2, y = 2
         * After 1st move, Robot will be at (x+4,y) = 6, 2
         * After 2nd move, Robot will be at (x+4,y+3) 6, 5
         * After 3rd move, Robot will be at (x-1,y+3) 1, 5
         * After 4th move, Robot will be at (x-1,y+1) 1, 3
         * After 5th move, Robot will be at (x,y+1)   2, 3
         * After 6th move, Robot will be at (x,y+7)   2, 9
         *  minX = 1, maxX = 6, deltaX = 5
         *  minY = 2, maxY = 9, deltaY = 7
         *  area = 5 * 7 = 35
         * and so on.
         * Find the minimum area of the rectangle which can enclose all these points.
         */
        int[] movement = new int[]{4,3,5,2,1,6};
        int x = 2, y = 2;
        //Expected 
        System.out.println("Minimum area: "+findMinimumArea(x,y,movement));
    }

    private static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static enum DIRECTION {
        EAST(1, 0), NORTH(0, -1), SOUTH(0, 1), WEST(-1, 0);
        int x; int y;
        DIRECTION(int x, int y){
            this.x = x;
            this.y = y;
        }
        void move(Point p, int delta){
            p.x += delta * this.x;
            p.y += delta * this.y;
        }
    };

    private static List<DIRECTION> directions = new ArrayList<>();

    static {
        directions.add(DIRECTION.EAST);
        directions.add(DIRECTION.SOUTH);
        directions.add(DIRECTION.WEST);
        directions.add(DIRECTION.NORTH);
    }

    static int nextDirection(int direction){
        return (direction + 1) % 4;
    }

    private static int findMinimumArea(int x, int y, int[] movement) {
        int area = 0;
        int direction = 0;
        int minX = Math.min(Integer.MAX_VALUE, x), maxX = Math.max(0, x), minY = Math.min(Integer.MAX_VALUE, y), maxY = Math.max(0, y);
        int delta = 0;
        Point point = new Point(x,y);
        while(delta < movement.length){
            directions.get(direction).move(point, movement[delta]);
            minX = Math.min(minX, point.x); maxX = Math.max(maxX, point.x); minY = Math.min(minY, point.y); maxY = Math.max(maxY, point.y);
            System.out.println("point = " + point);
            direction = nextDirection(direction);
            delta++;
        }
        area = Math.abs(minX - maxX) * Math.abs(minY - maxY);
        return area;
    }
}
