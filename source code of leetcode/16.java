/*
 * 2016.1.13
 *思想就是确实第一个数 然后后面两个数向中间靠  二层循环解决的是三个数类似枚举的问题
 *本来以为得用动态规划  用了递归  结构时间复杂度太高
 *递归时间复杂度问题呢     有序还是有很多好处的
 */
package leetc;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	int len = nums.length;
    	switch(len){
    	case 0: 
    		return 0;
    	case 1: 
    		return nums[0];
    	case 2:
    		return nums[0]+nums[1];
    	}
    	//like force but optimal in this process
    	//sort
    	Arrays.sort(nums);
    	int min = Integer.MAX_VALUE;
    	int optimal = 0;///any is ok
    	int k = nums.length-1;
    	for(int i = 0; i < k-1;i++){
    		k = nums.length-1;
    		int j = i+1;
    		while(j<k){
    			int currentSum = nums[i]+nums[j]+nums[k];
    			int currentDistance = Math.abs(target-currentSum);
    			if(min>currentDistance){
    				optimal = currentSum;
    				min = currentDistance;
    			}
    			if(currentSum>target){
    				k--;
    				if(k==j){
    					break;
    				}
    			}
    			else if(currentSum<target){
    				j++;
    				if(j==k){
    					break;
    				}
    			}
    			else{
    				return optimal;
    			}
    		}
    	}
    	return optimal;
    }
    public static void main(String []args){
    	Solution solution = new Solution();
    	int nums[] = {1,2,4,8,16,32,64,128};
    	System.out.println(solution.threeSumClosest(nums,82));
    }
}