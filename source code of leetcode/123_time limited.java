package com.zongfei;
/**
 *最多两次交易   123 不好做了 
 *还是最大连续子数组问题 现在把一个数组拆分成两个数组
 */
public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices==null||prices.length==0){
    		return 0;
    	}
    	else{
    		generateProfit(prices);
    		int max = Integer.MIN_VALUE;
    		for(int i = 1; i < prices.length;i++){
    			int[] arr = cpy(prices);
    			arr[i] = 0;
        		int curMax = maxSubArr(arr,0,i)+maxSubArr(arr,i,arr.length);
        		max = Math.max(max,curMax);
        	}
    		return max;
    	}
    }
    private int maxSubArr(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
    	int[] withCur = new int[end-start];
    	int[] noCur = new int[end-start];
    	withCur[0] = arr[start];
    	noCur[0] = 0;
    	int index = 0;
    	for(int i = start+1; i < end;i++){
    		index++;
    		withCur[index] = Math.max(arr[i],withCur[index-1]+arr[i]);
    		noCur[index] = Math.max(withCur[index-1],noCur[index-1]);
    	}
		return Math.max(withCur[index],noCur[index]);
	}
	private void generateProfit(int[] arr){
    	for(int i = arr.length-1;i>0;i--){
    		arr[i] = arr[i] - arr[i-1];
    	}
    	arr[0] = 0;
    }
	private int[] cpy(int[] prices) {
		// TODO Auto-generated method stub
		int[] res = new int[prices.length];
		for(int i = 0; i < prices.length;i++){
			res[i] = prices[i];
		}
		return res;
	}
}