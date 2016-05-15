package com.zongfei;
/**
 *超简单的样子  o(n)时间复杂度 
 * 162
 */
public class Solution {
    public int findPeakElement(int[] nums) {
    	for(int i = 1; i < nums.length;i++){
    		if(nums[i]<nums[i-1]){
    			return i-1;
    		}
    	}
		return nums.length-1;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {1,2,3,5,6,8};
    	System.out.println(s.findPeakElement(nums));
    }
}