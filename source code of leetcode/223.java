package com.zongfei;
/**
 * 223
 *beats 100%
 *没有涉及到什么算法和数据结构  没啥意思 
 */
public class Solution {
    public int computeArea(int preLeft, int preDown, int preRight, int preUp, 
    		int nextLeft, int nextDown, int nextRight, int nextUp) {
    	if(nextLeft>=preRight||nextDown>=preUp){
    		return calcuArea(preLeft,preDown,preRight,preUp)+
    				calcuArea(nextLeft,nextDown,nextRight,nextUp);
    	}
    	else if(nextRight<=preLeft||nextUp<=preDown){
    		return calcuArea(preLeft,preDown,preRight,preUp)+
    				calcuArea(nextLeft,nextDown,nextRight,nextUp);
    	}
    	else{
    		int all = calcuArea(preLeft,preDown,preRight,preUp)+
    				calcuArea(nextLeft,nextDown,nextRight,nextUp);
    		int coverWidth = Math.min(preRight,nextRight)-Math.max(preLeft,nextLeft);
    		int coverHeight = Math.min(preUp,nextUp)-Math.max(preDown,nextDown);
    		return all - coverWidth * coverHeight;
    	}
    }
    private int calcuArea(int left, int down, int right, int up) {
		// TODO Auto-generated method stub
		return (right-left)*(up-down);
	}
	public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.computeArea(-3,0,3,4,0,-1,9,2));
    }
}