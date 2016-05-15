/*
 * 5寻找最长回文数 
 * 这个刚开始想的是类似穷举的算法，狮子吃天无从下口
 * 比较好理解的一种方法 是回文串肯定是个中心 采用由中心到两边的方法   
 * 易错点：这个中心可能是两个字符之间的空隙 
 */
package leetc;

public class Solution {
	/*
	 *从中心到两边的策略
	 *由于中心可能是字符串也可能是两个字符之间 所以统一在两个字符之间加‘#’
	 *最长个数计算 向字符串后面追加字符和将字符插入到字符串最前面时间开销差异很大 常数型时间复杂度和线性时间复杂度
	 *maxStr存最大的 tempStr存当前以该字符为中心的回文串
	 *offset是向两边的偏移
	 */
    public String longestPalindrome(String str) {
    	if(str==null){
    		return null;
    	}
    	else{
    		String maxStr = "";
    		int maxLen = 0;
    		String s = addChar(str);
    		for(int i = 0; i < s.length();i++){
    			int offset = 1;
    			int currentLen = 1; 
    			if(s.charAt(i)=='#'){
    				currentLen = 0;
    			}
    			while((i-offset)>=0&&(i+offset)<s.length()){
    				if(s.charAt(i-offset)==s.charAt(i+offset)){
    					if(s.charAt(i-offset)!='#'){
    						currentLen+=2;
    					}
    					else{}
    					offset++;
    				}
    				else{
    					break;
    				}
    			}
    			if(maxLen<currentLen){
    				maxLen = currentLen;
    				maxStr = s.substring(i-offset+1, i+offset);
    				if(maxLen>=s.length()){
    					return str;
    				}
    				else{}
    			}
    		}
    		//
    		return func(maxStr);
    	}
    }
    /*
     *输入回文数的后半部分  根据后半部分补全前半部分
     *需要一步反转操作
     */
    public String func(String str){
    	StringBuilder sb = new StringBuilder("");
    	for(int i = 0;i<str.length();i++){
    		if(str.charAt(i)!='#'){
    			sb.append(str.charAt(i));
    		}
    	}
    	return sb.toString();
    }
    /*
     * 负责在两个字符空隙  添加字符‘#’目的是为了统一操作
     */
    public String addChar(String str){ 
    	StringBuilder sb = new StringBuilder("");
    	for(int i = 0; i < str.length()-1;i++){
    		sb.append(str.charAt(i));
    		sb.append('#');
    	}
    	sb.append(str.charAt(str.length()-1));
    	return sb.toString();
    }
    /*
     * 测试函数
     */
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.longestPalindrome("cccccc"));
    }
}
/*
 * 结果超时
 */
 