package com.ac;

import java.util.TreeSet;
/**
 *220  主要是TreeSet这个数据结构 
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(nums==null||t<0||k<1){
    		return false;
    	}
    	else{
    		TreeSet<Long> treeSet = new TreeSet<>();
    		for(int i = 0; i < nums.length;i++){
    			long max = (long)nums[i] + t + 1;
    			long min = (long)nums[i] - t;///////////这个地方为什么必须显示的强制类型转换呢  搞不懂  不这样就是int吗 不应该呀
    			if(!treeSet.subSet(min,max).isEmpty()){
    				return true;
    			}
    			treeSet.add((long)nums[i]);
    			if(treeSet.size()==k+1){
    				treeSet.remove((long)nums[i-k]);
    			}
    		}
    		return false;
    	}
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {1,3,1};
    	System.out.println(Integer.MAX_VALUE);
    	System.out.println(s.containsNearbyAlmostDuplicate(nums,1,1));
    }
}