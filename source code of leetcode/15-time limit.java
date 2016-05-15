package com.zongfei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Tuple{
	int x;
	int y;
	public Tuple(int x,int y){
		this.x = x;
		this.y = y;
	}
}
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	HashMap<Integer,HashSet<Integer>> set = new HashMap<Integer,HashSet<Integer>>();
    	HashMap<Integer,ArrayList<Tuple>> hm = new HashMap<Integer,ArrayList<Tuple>>();
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length-1;i++){//////////////////////////////
    		for(int j = i+1; j < nums.length;j++){
    			if(!hm.containsKey(nums[i]+nums[j])){
    				ArrayList<Tuple> inList = new ArrayList<Tuple>();
    				hm.put(nums[i]+nums[j],inList);
    				inList.add(new Tuple(i,j));
    				HashSet<Integer> inSet = new HashSet<Integer>();
    				inSet.add(i);
    				set.put(nums[i]+nums[j],inSet);
    			}
    			else{
    				if(!set.get(nums[i]+nums[j]).contains(i)){
    					set.get(nums[i]+nums[j]).add(i);
    					hm.get(nums[i]+nums[j]).add(new Tuple(i,j));
    				}
    			}
    		}
    	}///////////////////////////
    	Set<Integer> noDuplicate = new HashSet<Integer>();
    	for(int i = 0; i < nums.length;i++){
    		if(hm.containsKey(-nums[i])&&!noDuplicate.contains(-nums[i])){
    			//遍历hashMap
    			noDuplicate.add(-nums[i]);
    			ArrayList<Tuple> temp = hm.get(-nums[i]);
    			for(int index = 0; index < temp.size();index++){
    				ArrayList<Integer> al = new ArrayList<Integer>();
    				if(i>=temp.get(index).x){
    					continue;
    				}
    				al.add(nums[i]);
    				al.add(nums[temp.get(index).x]);
    				al.add(nums[temp.get(index).y]);
    				list.add(al);
    			}	
    		}
    	}
		return list;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {-1,0,1,2,-1,-4};
    	System.out.println(s.threeSum(nums));
    }
}