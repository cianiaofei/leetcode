package com.zongfei;

import java.util.Arrays;

/**
 *排个序试试  不知道是不是会超时 
 *效率居然这么搞  估计没人实现o(n)
 *并查集有空是得学学的
 *128
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
        	return 0;
        }
        else{
        	Arrays.sort(nums);
        	int res = 1;
        	int index = 0;
        	int curLen = 1;
        	while(index<nums.length-1){
        		if(nums[index+1]==nums[index]+1){
        			curLen++;
        			index++;
        		}
        		else if(nums[index+1]==nums[index]){
        			index++;
        		}
        		else{
        			res = Math.max(res,curLen);
        			curLen = 1;
        			index++;
        		}
        	}
        	return Math.max(res,curLen);
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {1,2,0,1};
    	System.out.println(s.longestConsecutive(nums));
    }
}