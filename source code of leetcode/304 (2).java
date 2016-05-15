package com.zongfei;
/**
 *动态规划问题 
 *304 效率居然这么低 表示想不通
 */
public class NumMatrix {
	private int[][] result;
	private int[][] matrix;
    public NumMatrix(int[][] matrix) {
    	this.matrix = matrix;
    	if(matrix==null||matrix.length==0){
    		return;
    	}
        result = new int[matrix.length][matrix[0].length];
        result[0][0] = matrix[0][0];
        for(int i = 1; i < matrix[0].length;i++){
        	result[0][i] = result[0][i-1] + matrix[0][i];
        }
        for(int i = 1; i < matrix.length;i++){
        	result[i][0] = result[i-1][0] + matrix[i][0];
        }
        for(int row = 1; row < matrix.length;row++){
        	for(int col = 1; col < matrix[0].length;col++){
        		result[row][col] = result[row][col-1] + (result[row-1][col]-result[row-1][col-1])
        				+matrix[row][col];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(matrix==null||matrix.length==0){
    		return 0;
    	}
    	int innocent = 0;
    	for(int i = col1; i <= col2;i++){
    		innocent += matrix[row1][i];
    	}
    	for(int i = row1+1; i <= row2;i++){
    		innocent += matrix[i][col1];
    	}
        return result[row2][col2]-result[row1][col2]-(result[row2][col1]-result[row1][col1])+innocent;
    }
    public static void main(String[] args){
    	int[][] matrix = {
    	          {3, 0, 1, 4, 2},
    	          {5, 6, 3, 2, 1},
    	          {1, 2, 0, 1, 5},
    	          {4, 1, 0, 1, 7},
    	          {1, 0, 3, 0, 5}
    	        };
    	NumMatrix s = new NumMatrix(matrix);
    	System.out.println(s.sumRegion(1,2,2,4));
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);