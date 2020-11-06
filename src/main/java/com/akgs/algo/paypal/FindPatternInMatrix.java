package com.akgs.algo.paypal;

public class FindPatternInMatrix {
    public static void main(String[] args) {
        char[][] matrix = new char[4][];
        matrix[0] = new char[]{'a','r', 'v', 'i', 'n', 'r'};
        matrix[1] = new char[]{'q', 'a', 'r', 'v', 'i', 'o'};
        matrix[2] = new char[]{'q', 'p', 't', 'i', 'u', 'p'};
        matrix[3] = new char[]{'q', 'n', 'u', 'n', 'd', 't'};
        System.out.println(findStringInMatrix("arvind",matrix));
    }
    public static boolean findStringInMatrix(String input, char[][] matrix){
        boolean found = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0;i<rows && !found;i++){
            for(int j=0;j<cols && !found;j++){
                char ele = matrix[i][j];
                if(ele == input.charAt(0)){
                    found = traverseNext(i,j,matrix,1,input);
                }
            }
        }
        return found;
    }

    public static boolean traverseNext(int row, int col, char[][] matrix, int nxtIndex, String input){
        boolean found = false;
        if(nxtIndex >= input.length()){
            return true;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        char ele = input.charAt(nxtIndex);

        if(row < rows-1 && matrix[row+1][col] == ele){
            found = traverseNext(row+1,col,matrix,nxtIndex+1,input);
        }
        if(col < cols-1 && !found && matrix[row][col+1] == ele){
            found = traverseNext(row,col+1,matrix,nxtIndex+1,input);
        }
        return found;
    }
}
