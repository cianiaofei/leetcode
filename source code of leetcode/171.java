package leetc;
/**
 *171
 * 有点26进制的感觉
 */
public class Solution {
    public int titleToNumber(String s) {
        if(s==null){
        	return 0;
        }
        else{
        	int len = s.length();
        	int result = 0;
        	for(int i = 0; i < len;i++){
        		result += (s.charAt(i)-'A'+1)*func(len-1-i);
        	}
        	return result;
        }
    }
    public int func(int a){
    	int result = 1;
    	for(int i = 0; i < a;i++){
    		result *= 26;
    	}
    	return result;
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.titleToNumber("AA"));
    }
}