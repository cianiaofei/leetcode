package com.zongfei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 15题  前面那种方法比较通用但是蛮复杂的 
 * 刚刚看了下提示用两个指针   对于一个排好序的数组用两个指针  动态在两侧变化能够调整和的大小
 * 很直观的过程
 */
enum Direction{
	LEFT,RIGHT;
}
public class Solution {
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
    	if(nums==null||nums.length<3){
    		return null;
    	}
    	else{
    		Arrays.sort(nums);
    		int start = 0,end = nums.length-1;
    		generateSolution(nums,start,end);
    	}
        return res;
    }
	private void generateSolution(int[] nums, int start, int end) {
		if(end-start<2){
			return;
		}
		int value = nums[start] + nums[end];
		Direction direction;
		if(value>0){
			direction = Direction.LEFT;
		}
		else{
			direction = Direction.RIGHT;
		}
		int place = find(nums,start,end,direction,-value);
		if(place==-1){
			if(direction==Direction.LEFT){
				   while(nums[end]==nums[end-1]){
					   end--;
					   if(end==start){
				    		return;
				    	}
				    }
					generateSolution(nums,start,end-1);
			}
			else{
				  while(nums[start]==nums[start+1]){
						start++;
						if(start==end){
							return;
						}
					}
					generateSolution(nums,start+1,end);
				}
			}
		else{
			List<Integer> inList = new ArrayList<Integer>();
			inList.add(nums[start]);
			inList.add(nums[place]);
			inList.add(nums[end]);
			res.add(inList);
			int pend = end;
			while(nums[end]==nums[end-1]){
			    end--;
			    if(end==start){
			    	return;
			    }
			}
			generateSolution(nums,start,end-1);
			while(nums[start]==nums[start+1]){
				start++;
				if(start==pend){
					return;
				}
			}
			generateSolution(nums,start+1,pend);
		}
	}
	public int find(int[] nums, int start, int end, Direction direction, int value) {
		// TODO Auto-generated method stub
		if(direction == Direction.LEFT){
			for(int i = start+1; i < end;i++){
				if(nums[i]==value){
					return i;
				}
				if(nums[i]>value){
					break;
				}
			}
		}
		else{
			for(int i = end-1; i > start;i--){
				if(nums[i]==value){
					return i;
				}
				if(nums[i]<value){
					break;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(s.threeSum(nums));
	}
}