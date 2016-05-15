package com.ac;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *三个数之和为0的组合  
 *最容易想到的方法是三层循环
 */
import java.util.List;

public class Solution {
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
    	if(nums==null||nums.length==0){
    		return res;
    	}
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length-2;i++){
    		if(i>0&&nums[i-1]==nums[i]){
    			continue;
    		}
    		for(int j = i+1; j < nums.length-1;j++){
    			if(j>i+1&&nums[j-1]==nums[j]){
        			continue;
        		}
    			int cur = nums[i] + nums[j];
    			if(cur>0){
    				break;
    			}
    			for(int k = j+1; k < nums.length;k++){
    				if(cur+nums[k]>0){
    					break;
    				}
    				if(cur+nums[k]==0){
    					List<Integer> inList = new ArrayList<Integer>();
    					inList.add(nums[i]);
    					inList.add(nums[j]);
    					inList.add(nums[k]);
    					res.add(inList);
    					break;
    				}
    			}
    		}
    	}
        return res;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
    	System.out.println(s.threeSum(nums));
    }
}