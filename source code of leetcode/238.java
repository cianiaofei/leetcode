/*
 * 238 
 * 要求：给一串数字计算除了除每个数字之外n-1个数的乘积
 * 解法：比较简单的方法是计算n个数的乘积 把需要除去的数字除掉（这样做的问题就是可能会出现越界的问题 就是超出Integer的上界）
 * 解法：先计算左边的乘积  再计算右边的乘积 两次循环搞定
 */
package leetc;

public class Solution {
	/*
	 *res[]返回结果 
	 */
    public int[] productExceptSelf(int[] nums){
    	if(nums==null){
    		return null;
    	}
    	else{
    		int[] res = new int[nums.length];
    		res[0] = 1;
    		for(int i = 1;i < nums.length;i++){
    			res[i] = res[i-1] * nums[i-1];
    		}
    		int right = 1;
    		for(int i = nums.length-2;i>=0;i--){
    			right = right * nums[i+1];
    			res[i] = right *  res[i];
    		}
    		return res;
    	}
    }
}