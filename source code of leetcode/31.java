package com.zongfei;

import java.util.Arrays;

/**
 * 想清楚再下手
 * 31 
 *这个题本身和排列好像并没有关系 
 *基本有思路了(自己的想法是不正确的) 不是交换是插到那个位置（是把后面的一段插过去） 还不对
 *应该是对一部分排序   一定先想好再做 
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length==0){
        	return ;
        }
        else{
        	int place = -1;
        	for(int i = nums.length-2;i >= 0;i--){
        		if(nums[i]<nums[i+1]){
        			place = i;
        			break;
        		}
        	}
        	if(place==-1){
        		 reverse(nums);
        		 return ;
        	}
        	else{
        		int newPlace = place+1;
        		int value = nums[place+1];
        		for(int i = place+2; i < nums.length;i++){
        			if(nums[place]<nums[i]&&nums[i]!=value){
        				value = nums[i];
        				newPlace = i;
        			}
        			else if(nums[place]>=nums[i]){
        				break;
        			}
        		}
        		swap(nums,place,newPlace);
        		//对place后面的进行排序
        		Arrays.sort(nums,place+1,nums.length);
        		return;
        	}
        }
    }

	private void swap(int[] nums, int place, int newPlace) {
		// TODO Auto-generated method stub
		int temp = nums[place];
		nums[place] = nums[newPlace];
		nums[newPlace] = temp;
	}

	private void reverse(int[] nums) {
		// 首尾交换的思想
		int head = 0;
		int tail = nums.length-1;
		while(head<tail){
			swap(nums,head++,tail--);
		}
		return;
	}
	public static void main(String[] args){
		int[] nums = {1,3,2};
		Solution s = new Solution();
		s.nextPermutation(nums);
		System.out.println(nums);
	}
}