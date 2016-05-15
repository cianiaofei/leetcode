package com.zongfei;
/**
 *275 题目 本身不难 注意一些细节就行 
 *水题 
 */
public class Solution {
    public int hIndex(int[] citations) {
    	if(citations==null||citations.length==0||citations[citations.length-1]==0){
    		return 0;
    	}
    	else{
    		return binaryFindHindex(citations,0,citations.length-1);
    	}
    }
    public int binaryFindHindex(int[] citations,int start,int end){
    	int middle = (start + end) / 2;
    	int numbers = citations.length - middle;
    	if(citations[middle]>=numbers&&(middle==0||citations[middle-1]<=numbers)){
    		return numbers;
    	}
    	else{
    		if(citations[middle]<numbers){
    			return binaryFindHindex(citations,middle+1,end);
    		}
    		else{
    			return binaryFindHindex(citations,start,middle-1);
    		}
    	}
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] citations = {1,1,2,3,4,5,7};
    	System.out.println(s.hIndex(citations));
    }
}