package test;
/*
 * 319
 * �ö�̬�滮 ��úܶ�
 * ��Ȼ��һ�о��ܽ�� �Ǹ���ѧ����
 */
public class Solution {
    public int bulbSwitch(int n) {
    	if(n==0){
    		return 0;
    	}
       boolean[] isOff = new boolean[n];//0��ʾ��
       int sum = n;
       for(int i = 1; i < n;i+=2){
    	  isOff[i] = true;
    	  sum--;
       }
       for(int i = 3; i < n;i++){//out for
    	   for(int j = i-1; j < n;j+=i){
    		   if(isOff[j]){
    			   isOff[j] = false;
    			   sum++;
    		   }
    		   else{
    			   isOff[j] = true;
    			   sum--;
    		   }
    	   }
       }//out for
       if(isOff[n-1]){
    	   return sum+1;
       }
       else{
    	   return sum-1;
       }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println((int)Math.sqrt(10000000));
    }
}