package com.zongfei;

import java.util.ArrayList;
import java.util.List;

/**
 *栈溢出  我明明觉着没问题呀
 *130 
 *广度优先遍历  记住的是 递归比较深的话是会很吃资源的
 */
class Node{
	int x;
	int y;
	public Node(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Solution {
    public void solve(char[][] board) {
    	if(board==null||board.length==0){
    		return ;
    	}
    	else{
    		boolean[][] isBeach = new boolean[board.length][board[0].length];
    		for(int i = 0; i < board.length;i++){
    			if(board[i][0]=='O'&&isBeach[i][0]==false){
    				isBeach[i][0] = true;
    				bfs(board,i,0,isBeach);
    			}
    			if(board[i][board[0].length-1]=='O'&&isBeach[i][board[0].length-1]==false){
    				isBeach[i][board[0].length-1] = true;
    				bfs(board,i,board[0].length-1,isBeach);
    			}
    		}
    		for(int i = 1; i < board[0].length-1;i++){
    			if(board[0][i]=='O'&&isBeach[0][i]==false){
    				isBeach[0][i] = true;
    				bfs(board,0,i,isBeach);
    			}
    			if(board[board.length-1][i]=='O'&&isBeach[board.length-1][i]==false){
    				isBeach[board.length-1][i] = true;
    				bfs(board,board.length-1,i,isBeach);
    			}
    		}
    		for(int i = 0; i < board.length;i++){
    			for(int j = 0; j < board[0].length;j++){
    				if(board[i][j]=='O'&&isBeach[i][j]==false){
    					board[i][j] = 'X';
    				}
    			}
    		}
    	}
   }

	private void bfs(char[][] board, int x, int y, boolean[][] isBeach) {
		List<Node> level = new ArrayList<Node>();
		level.add(new Node(x,y));
		while(!level.isEmpty()){
			List<Node> temp = new ArrayList<Node>();
			int len = level.size();
			for(int i = 0; i < len;i++){
				Node node = level.remove(0);
				if(node.x-1>=0&&board[node.x-1][node.y]=='O'&&isBeach[node.x-1][node.y]==false){
					isBeach[node.x-1][node.y] = true;
					temp.add(new Node(node.x-1,node.y));
				}
				if(node.x+1<board.length&&board[node.x+1][node.y]=='O'&&isBeach[node.x+1][node.y]==false){
					isBeach[node.x+1][node.y] = true;
					temp.add(new Node(node.x+1,node.y));
				}
				if(node.y-1>=0&&board[node.x][node.y-1]=='O'&&isBeach[node.x][node.y-1]==false){
					isBeach[node.x][node.y-1] = true;
					temp.add(new Node(node.x,node.y-1));
				}
				if(node.y+1<board[0].length&&board[node.x][node.y+1]=='O'&&isBeach[node.x][node.y+1]==false){
					isBeach[node.x][node.y+1] = true;
					temp.add(new Node(node.x,node.y+1));
				}
			}
			level = temp;
		}
	}
	public static void main(String[] args){
		char[][] board = {"OXXOX".toCharArray(),"XOOXO".toCharArray(),"XOXOX".toCharArray(),
				"OXOOO".toCharArray(),"XXOXO".toCharArray()};
		Solution s = new Solution();
		s.solve(board);
		System.out.println("");
	}
}