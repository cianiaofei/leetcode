package leetc;
 /*
  * 152 关键还是找关系   一步一步来  别把自己搞晕了
  * 状态转移函数  包括当前元素否定 比较
  */
public class Solution {
    public int maxProduct(int[] nums) {
    	int allMax = nums[0];
    	int globalMax = nums[0];
    	int globalMin = nums[0];
    	for(int i = 1; i < nums.length;i++){
    		int temp = globalMax;
    		globalMax = Math.max(nums[i],Math.max(globalMax*nums[i],globalMin*nums[i]));
    		globalMin = Math.min(nums[i],Math.min(globalMin*nums[i],temp*nums[i]));
    		allMax = Math.max(allMax,globalMax);
    	}
        return allMax;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {-4,-3,-2};
    	System.out.println(s.maxProduct(nums));
    }
}