package com.ac;

import java.util.Comparator;
import java.util.TreeMap;

/**
 *��TreeMap����  ʱ�临�Ӷ�Ϊo(nlogn)
 *TreeMap�ĵײ�ṹ�������Ǻ����
 */
public class Solution {
	private TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums==null||k<0){
    		return null;
    	}
    	else if(nums.length==0||k==0){
    		int[] arr = new int[1];
    		return arr;
    	}
    	else{
    		int[] res = new int[nums.length+1-k];
    		//�ȴ���ǰK��
    		for(int i = 0; i < k;i++){
    			if(!tm.containsKey(nums[i])){
    				tm.put(nums[i],1);
    			}
    			else{
    				int curValue = tm.get(nums[i]);
    				tm.put(nums[i],++curValue);
    			}
    		}///////////////////////////////
    		res[0] = findMax(tm);
    		for(int i = k;i < nums.length;i++){
    			if(tm.get(nums[i-k])==1){
    				tm.remove(nums[i-k]);
    			}
    			else{
    				int curValue = tm.get(nums[i-k]);
    				tm.put(nums[i-k],--curValue);
    			}
    			if(tm.containsKey(nums[i])){
    				int curValue = tm.get(nums[i]);
    				tm.put(nums[i],++curValue);
    			}
    			else{
    				tm.put(nums[i],1);
    			}
    			res[i-k+1] = findMax(tm);
    		}
    		return res;
    	}
    }
    private int findMax(TreeMap<Integer, Integer> map) {
		// ȡ��һ������
    	return map.lastKey();
	}
	class MyComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2)*(-1);
		}
    }
}