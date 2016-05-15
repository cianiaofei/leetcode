package com.zongfei;
/**
 *275好像不难  就是个二分查找 
 */
public class Solution {
    public int hIndex(int[] citations) {
    	if(citations==null||citations.length==0||citations[0]==0){
    		return 0;
    	}
		return findHindex(citations,0,citations.length);
    }
    public int findHindex(int[] citations,int start,int end){
    	int middle = (start + end) / 2;
    	int numbers = end - middle + 1;
    	if(middle==citations.length-1||
    			citations[middle]>=numbers&&citations[middle+1]<=numbers){
    		return middle;
    	}
    	else{
    		if(citations[middle]<numbers){
    			return findHindex(citations,start,middle-1);
    		}
    		else if(citations[middle+1]>numbers){
    			return findHindex(citations,middle+1,end);
    		}
    		else{
    			return -1;
    		}
    	}
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] citations = {0,0,0};
    	System.out.println(s.findHindex(citations,0,citations.length));
    }
}