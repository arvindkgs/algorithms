import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Paypal
//Given a matrix, 1's are lands and 0's water, find no of islands
//1's directly above,below,left,right,upper-left,upper-right,lower-left,lower-right is one island

class Scratch {
    public static void main(String[] args) {

        int[][] mat = {{1,1,1},{1,1,1}};
        List<Point> allOnes = populateAllOnes(mat);

        List<Point> visited = new ArrayList<>();
        int noIslands = 0;
        for(Point one : allOnes){
            if(!visited.contains(one)){
                traverse(one, visited, mat);
                noIslands++;
            }
        }

        System.out.println(noIslands);
    }

    private static List<Point> populateAllOnes(int[][] mat) {
        List<Point> allOnes = new ArrayList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]!=0){
                    allOnes.add(new Point(i,j));
                }
            }
        }
        return allOnes;
    }

    private static void traverse(Point one, List<Point> visited, int[][] mat) {
        List<Point> neighbors = getNeighbors(one, mat[0].length-1, mat.length-1);
        for(Point neighbor: neighbors){
            if(mat[neighbor.x][neighbor.y] == 1 && !visited.contains(neighbor)){
                visited.add(neighbor);
                traverse(neighbor, visited, mat);
            }
        }
    }

    private static List<Point> getNeighbors(Point one, int maxCol, int maxRow) {
        List<Point> result = new ArrayList<>();
        if(one.x > 0){
            Point top = new Point(one.x-1,one.y);
            result.add(top);
            //top-left
            if(one.y > 0){
                Point bottom = new Point(one.x-1,one.y-1);
                result.add(bottom);
            }
            //top-right
            if(one.y < maxCol){
                Point right = new Point(one.x-1,one.y+1);
                result.add(right);
            }
        }
        if(one.y > 0){
            Point left = new Point(one.x,one.y-1);
            result.add(left);
        }
        if(one.y < maxCol){
            Point right = new Point(one.x,one.y+1);
            result.add(right);
        }
        if(one.x < maxRow){
            Point bottom = new Point(one.x+1,one.y);
            result.add(bottom);
            //bottom-left
            if(one.y > 0){
                Point left = new Point(one.x+1,one.y-1);
                result.add(left);
            }
            //bottom-right
            if(one.y < maxCol){
                Point right = new Point(one.x+1,one.y+1);
                result.add(right);
            }
        }

        return result;
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Point && this.x == ((Point) obj).x && this.y == ((Point) obj).y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}