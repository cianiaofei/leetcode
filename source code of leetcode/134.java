package com.zongfei;
/**
 *先用最暴力的方法试试
 *形成一个环形链表 果然超时了
 *稍微动下脑子  稍微推理一下  如果发生什么  必然会有什么 
 *规律是客观存在的 134先放放 程序实现
 *没太大意思 主要是逻辑推理
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas==null||gas.length==0){
    		return -1;
    	}
    	else{
    		for(int i = 0; i < gas.length;i++){
    			gas[i] -= cost[i];
    		}
    		int place = 0;
    		int sum = 0;
    		for(int i = 0; i < gas.length;i++){
    			sum += gas[i];
    			if(sum < 0){
    				if(i==gas.length-1){
    					return -1;
    				}
    				else{
    					place = i + 1;
    					sum = 0;
    					continue;
    				}
    			}
    		}
    		for(int i = 0; i < place;i++){
    			sum += gas[i];
    			if(sum<0){
    				return -1;
    			}
    		}
    		return place;
    	}//else
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	
    }
}