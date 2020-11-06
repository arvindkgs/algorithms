package com.akgs.algo.hackerrank;

import java.util.*;

/**
 * Grid of 0's and 1's. 1 is an office, 0 is empty space
 * Horizontal and vertical neighbours are considered same office
 * Example:
 * First #row
 * Second #cols
 * Binary Matrix
 * Input:
 * 4
 * 4
 * 1100
 * 0010
 * 1000
 * 0010
 * Output:
 * 4
 */
class FindNoOfficeSpacesInBinaryMatrix
{
    static class Point {
        int x;
        int y;
        boolean done = false;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "(x:"+x+", y:"+y+")";
        }
        public boolean equals(Object o){
            if (o instanceof Point && x == ((Point)o).x && y == ((Point)o).y)
                return true;
            return false;
        }
    }
    public static int numOffices(String[][] grid) {
        int rows = -1;
        int cols = -1;
        if (grid != null && grid.length > 0)
            rows = grid.length;
        if (rows > 0)
            cols = grid[0].length;
        List<Point> points = new ArrayList<Point>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j].equalsIgnoreCase("1")) {
                    points.add(new Point(i,j));
                }
            }
        }
        int nPoints = points.size();
        int numOffices = 0;
        Queue<Point> officeSpace = new LinkedList<>();
        while(nPoints > 0) {
            FindNoOfficeSpacesInBinaryMatrix.Point p = points.get(0);
            points.remove(p);
            nPoints--;
            officeSpace.add(p);
            while(!officeSpace.isEmpty()){
                Point curr = officeSpace.poll();
                if(curr != null) {
                    if(curr.y < (cols - 1)) {
                        Point neighbour = new Point(curr.x, curr.y+1);
                        if(points.remove(neighbour)){
                            officeSpace.add(neighbour);
                            nPoints--;
                        }
                    }
                    if(curr.y > 0) {
                        Point neighbour = new Point(curr.x, curr.y-1);
                        if(points.remove(neighbour)){
                            officeSpace.add(neighbour);
                            nPoints--;
                        }
                    }
                    if(curr.x < (rows - 1)) {
                        Point neighbour = new Point(curr.x+1, curr.y);
                        if(points.remove(neighbour)){
                            officeSpace.add(neighbour);
                            nPoints--;
                        }
                    }
                    if(curr.x > 0) {
                        Point neighbour = new Point(curr.x-1, curr.y);
                        if(points.remove(neighbour)){
                            officeSpace.add(neighbour);
                            nPoints--;
                        }
                    }
                }
            }
            numOffices++;
        }
        return numOffices;
    }
}

class Rextester
{
    public static String[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        String matrix[][] = new String[rowsLen][colsLen];
        int i;
        for(i=0;i<rowsLen;i++){
            String line = sc.next();
            for(int j=0;j<line.length();j++) {
                matrix[i][j] = String.valueOf(line.charAt(j));
            }
        }
        return matrix;
    }

    public static void main(String args[])
    {
        int result = FindNoOfficeSpacesInBinaryMatrix.numOffices(getMatrix());
        System.out.println(result);
    }
}
