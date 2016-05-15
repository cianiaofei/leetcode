package com.zongfei;
/**
 *这是一种新的数据结构  binary index tree 底层原理估计是比较复杂的   
 *先把代码记住  307
 */
public class NumArray {
	private int[] res;
	private int[] nums;
    public NumArray(int[] nums) {
    	this.nums = nums;
    	res = new int[nums.length+1];
    	for(int i = 0; i < nums.length;i++){
    		int x = i+1;
    		while(x<res.length){
    			res[x] += nums[i];
    			x += x &(-x);
    		}
    	}
    }

    void update(int i, int val) {
        int x = i + 1;
        while(x<res.length){
			res[x] += (val-nums[i]);
			x += x &(-x);
		}
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
       int sum = 0;
       for(int x = j+1;x>0;x-=x&(-x)){
    	   sum += res[x];
       }
       for(int x = i;x>0;x-=x&(-x)){
    	   sum -= res[x];
       }
       return sum; 
    }
    public static void main(String[] args){
    	int[] nums = {9,-8};
    	NumArray na = new NumArray(nums);
    	System.out.println(na.sumRange(1, 1));
    	na.update(0,3);
    	System.out.println(na.sumRange(0, 1));
    }
}
// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);