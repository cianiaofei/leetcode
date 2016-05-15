package com.zongfei;
/**
 *栈溢出  我明明觉着没问题呀
 *130 
 */
public class Solution {
    public void solve(char[][] board) {
    	if(board==null||board.length==0){
    		return ;
    	}
    	else{
    		boolean[][] isBeach = new boolean[board.length][board[0].length];
    		for(int i = 0; i < board.length;i++){
    			if(board[0][i]=='O'&&isBeach[0][i]==false){
    				isBeach[0][i] = true;
    				traverse(board,0,i,isBeach);
    			}
    			if(board[board.length-1][i]=='O'&&isBeach[board.length-1][i]==false){
    				isBeach[board.length][i] = true;
    				traverse(board,board.length-1,i,isBeach);
    			}
    		}
    		for(int i = 1; i < board[0].length-1;i++){
    			if(board[i][0]=='O'&&isBeach[i][0]==false){
    				isBeach[i][0] = true;
    				traverse(board,i,0,isBeach);
    			}
    			if(board[i][board[0].length-1]=='O'&&isBeach[i][board[0].length-1]==false){
    				isBeach[i][board[0].length-1] = true;
    				traverse(board,i,board[0].length-1,isBeach);
    			}
    		}
    		for(int i = 0; i < board.length;i++){
    			for(int j = 0; j < board[0].length;j++){
    				if(isBeach[i][j]==false&&board[i][j]=='O'){
    					board[i][j] = 'X';
    				}
    			}
    		}
    	}
    }
    //层次遍历 上下左右
	public void traverse(char[][] board, int row, int col, boolean[][] isBeach) {
		if(row-1>=0&&board[row-1][col]=='O'&&isBeach[row-1][col]==false){
			isBeach[row-1][col] = true;
			traverse(board,row-1,col,isBeach);
		}
		if(row+1<board.length&&board[row+1][col]=='O'&&isBeach[row+1][col]==false){
			isBeach[row+1][col] = true;
			traverse(board,row+1,col,isBeach);
		}
		if(col-1>=0&&board[row][col-1]=='O'&&isBeach[row][col-1]==false){
			isBeach[row][col-1] = true;
			traverse(board,row,col-1,isBeach);
		}
		if(col+1<board[0].length&&board[row][col+1]=='O'&&isBeach[row][col+1]==false){
			isBeach[row][col+1] = true;
			traverse(board,row,col+1,isBeach);
		}
	}
}