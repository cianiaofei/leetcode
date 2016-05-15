package com.zongfei;
/**
 * 超时 310
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	if(edges==null||edges.length==0){
    		return null;
    	}
    	else{
    		List<Integer> minRootSet = new ArrayList<>();
    		int[][] matrix = new int[n][n];
    		for(int i = 0; i < edges.length;i++){
    			int node1 = edges[i][0];
    			int node2 = edges[i][1];
    			matrix[node1][node2] = 1;
    			matrix[node2][node1] = 1;
    		}
    		////////////////////////////////////////广度优先遍历
    		int index = 0;
    		int min = Integer.MAX_VALUE;
    		while(index<n){//outer while
    			Deque<Integer> queue = new ArrayDeque<Integer>();
    			int[] color = new int[n];//为已经选择的点着色
    			int curDeepth = 0;
    			queue.add(index);
    			////一层一层的来
    			color[index] = 1;
    			while(!queue.isEmpty()){//medium while
    				Deque<Integer> subLayer = new ArrayDeque<>();
    				boolean flag = false;
    				while(!queue.isEmpty()){//inner while
    					int curNode = queue.remove();
    					boolean isIn = false;
    					for(int i = 0;i<matrix.length;i++){
							int neighbor = matrix[curNode][i];
							if(neighbor==1&&color[i]==0){
								color[i] = 1;
								subLayer.add(i);
								isIn = true;
							}
						}
    					if(isIn==false){
    						if(curDeepth==min){
    							minRootSet.add(index);
    						}
    						else if(curDeepth<min){
    							minRootSet.clear();
    							minRootSet.add(index);
    							min = curDeepth;
    						}
    						else{}
    						flag = true;
    						break;
    					}
    				}//inner while
    				if(flag==true){
    					break;
    				}
    				else{
    					curDeepth++;
    				}
    				queue = subLayer;
    			}//medium while
    			index++;
    		}//outer while
    		return minRootSet;
    	}
    }
    public static void main(String[] args){
    	int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
    	Solution s = new Solution();
    	System.out.println(s.findMinHeightTrees(6, edges));
    }
}