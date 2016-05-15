package com.zongfei;
/**
 *greedy算法  122
 *好像把正数加起来就可以   居然真的是这样 只要分析出来 就可以 没有涉及到太复杂的数据结构和算法
 */
public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices==null||prices.length==0){
    		return 0;
    	}
    	else{
    		int sum = 0;
    		int[] earns = new int[prices.length];
    		earns[0] = 0;
    		for(int i = 1; i < prices.length;i++){
    			earns[i] = prices[i] - prices[i-1];
    			if(earns[i]>0){
    				sum += earns[i];
    			}
    		}
    		return sum; 
    	}
    }
}