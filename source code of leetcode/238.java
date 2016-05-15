/*
 * 238 
 * Ҫ�󣺸�һ�����ּ�����˳�ÿ������֮��n-1�����ĳ˻�
 * �ⷨ���Ƚϼ򵥵ķ����Ǽ���n�����ĳ˻� ����Ҫ��ȥ�����ֳ�������������������ǿ��ܻ����Խ������� ���ǳ���Integer���Ͻ磩
 * �ⷨ���ȼ�����ߵĳ˻�  �ټ����ұߵĳ˻� ����ѭ���㶨
 */
package leetc;

public class Solution {
	/*
	 *res[]���ؽ�� 
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