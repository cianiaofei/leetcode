package com.zongfei;
/**
 *213与连续子数组之和那个很像 
 *分成两种情况   还是推理
 */
public class Solution {
    public int rob(int[] nums) {
    	if(nums==null||nums.length==0){
    		return 0;
    	}
    	else if(nums.length==1){
    		return nums[0];
    	}
    	else{
    		return Math.max(findMax(nums,0,nums.length-1),findMax(nums,1,nums.length));
    	}
    }

	private int findMax(int[] nums, int start, int end) {
		int[] noCur = new int[end];
		int[] withCur = new int[end];
		noCur[start] = 0;
		withCur[start] = nums[start];
		for(int i = start+1; i < end;i++){
			noCur[i] = Math.max(noCur[i-1],withCur[i-1]);
			withCur[i] = Math.max(noCur[i-1]+nums[i],nums[i]);
		}
		return Math.max(noCur[end-1],withCur[end-1]);
	}
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1};
		System.out.println(s.rob(nums));
	}
}