package com.zongfei;
/**
 *200其实就是层次遍历 很简单的 
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
	class Place{
		int x;
		int y;
		Place(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
    public int numIslands(char[][] grid) {
    	if(grid==null||grid.length==0){
    		return 0;
    	}
    	else{//一层一层来
    		int num = 0;
    		int[][] color = new int[grid.length][grid[0].length];
    		for(int row = 0; row < grid.length;row++){
    			for(int col = 0;col < grid[0].length;col++){
    				if(grid[row][col]=='1'&&color[row][col]==0){
    					num++;
    					color[row][col] = 1;
    					colorIsland(grid,row,col,color);
    				}
    			}
    		}
    		return num;
    	}
    }

	private void colorIsland(char[][] grid, int row, int col, int[][] color) {
		// 一层层来 右下
		List<Place> list = new ArrayList<>();
		list.add(new Place(row,col));
		while(!list.isEmpty()){//while1
			List<Place> layer = new ArrayList<>();
			for(int i = 0; i < list.size();i++){//for1
				int x = list.get(i).x;
				int y = list.get(i).y;
				if(x-1>-1&&grid[x-1][y]=='1'&&color[x-1][y]==0){
					color[x-1][y] = 1;
					layer.add(new Place(x-1,y));
				}
				if(y-1>-1&&grid[x][y-1]=='1'&&color[x][y-1]==0){
					color[x][y-1] = 1;
					layer.add(new Place(x,y-1));
				}
				if(x+1<grid.length&&grid[x+1][y]=='1'&&color[x+1][y]==0){
					color[x+1][y] = 1;
					layer.add(new Place(x+1,y));
				}
				if(y+1<grid[0].length&&grid[x][y+1]=='1'&&color[x][y+1]==0){
					color[x][y+1] = 1;
					layer.add(new Place(x,y+1));
				}
			}//for1
			list = layer;
		}//while1
	}
	public static void main(String[] args){
		char[][] matrix = {{'1','0','1','1','1'},{'1','0','1','0','1'},
				{'1','1','1','0','1'}
		};
		Solution s = new Solution();
		System.out.println(s.numIslands(matrix));
	}
}