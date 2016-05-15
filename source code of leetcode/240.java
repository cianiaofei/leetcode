package com.zongfei;
/**
 * 240 有顺序时使用二分查找 好像没啥太大意思 
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null||matrix.length==0){
    		return false;
    	}
    	else{
    		for(int row=0; row<matrix.length;row++){
    			if(target<matrix[row][0]){
    				return false;
    			}
    			else if(isFindTarget(matrix[row],0,matrix[row].length,target)){
    				return true;
    			}
    			else{}
    		}
    	}
		return false;
    }
    public boolean isFindTarget(int[] nums,int left,int right,int target){
    	if(left>right||left==right){
    		return false;
    	}
    	else{
    		int middle = (left+right)/2;
    		if(target==nums[middle]){
    			return true;
    		}
    		else{
    			if(nums[middle]<target){
    				return isFindTarget(nums,middle+1,right,target);
    			}
    			else{
    				return isFindTarget(nums,left,middle,target);
    			}
    		}
    	}
    }
    public static void main(String[] args){
    	int[][]matrix = {
    	                 {-1,3}
    	               };
    	Solution s = new Solution();
    	System.out.println(s.searchMatrix(matrix,1));
    }
}