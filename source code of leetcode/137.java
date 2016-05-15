package com.zongfei;

import java.util.HashMap;

/**
 * 很没意思的题137
 **/
public class Solution {
    public int singleNumber(int[] nums) {
    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	for(int i = 0; i < nums.length;i++){
    		if(hm.containsKey(nums[i])){
    			if(hm.get(nums[i])==2){
    				hm.remove(nums[i]);
    			}
    			else{
    				int value = hm.get(nums[i]);
    				hm.put(nums[i],++value);
    			}
    		}
    		else{
    			hm.put(nums[i],1);
    		}
    	}
    	for(int a:hm.keySet()){
    		return a;
    	}
    	return 0;
    }
}