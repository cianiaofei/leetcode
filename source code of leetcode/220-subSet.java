package com.ac;

import java.util.TreeSet;
/**
 *220  ��Ҫ��TreeSet������ݽṹ 
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
    			long min = (long)nums[i] - t;///////////����ط�Ϊʲô������ʾ��ǿ������ת����  �㲻��  ����������int�� ��Ӧ��ѽ
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