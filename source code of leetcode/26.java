package com.ac;
/**
 *26  
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
    	if(nums==null||nums.length==0){
    		return 0;
    	}
    	else if(nums.length==1){
    		return 1;
    	}
    	else{
    		int max = nums[nums.length-1];
    		for(int i = 0; i < nums.length-1;i++){
    			if(nums[i]==max){
    				return i+1;
    			}
    			else{
    				while(nums[i+1]==nums[i]){
    					movePre(nums,i);
    				}
    			}
    		}
    	}
        return nums.length;
    }

	private void movePre(int[] nums, int start) {
		// TODO Auto-generated method stub
		for(int i = start; i < nums.length-1;i++){
			nums[i] = nums[i+1];
		}
	}
	public static void main(String[] args){
		int[] arr = {1,2,2,2,3};
		Solution s = new Solution();
		System.out.println(s.removeDuplicates(arr));
	}
}