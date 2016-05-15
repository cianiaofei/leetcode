package leetc;
 /*
  * 152 �ؼ������ҹ�ϵ   һ��һ����  ����Լ�������
  * ״̬ת�ƺ���  ������ǰԪ�ط� �Ƚ�
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