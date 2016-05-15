package leetc;

import java.util.Stack;

/**
 * 150  �򵥵���ը
 * ��������沨��ʽ ���ַ���������ʾ��  ���Ϊ��Ӧ��ֵ
 */
public class Solution {
    public int evalRPN(String[] tokens) {
    	if(tokens==null||tokens.length==0){
    		return 0;
    	}
    	else{
    		Stack<Integer> stack = new Stack<>();
    		for(int i = 0; i < tokens.length;i++){
    			if(isOperate(tokens[i])){
    				char ch = tokens[i].charAt(0);
    				int latter = stack.pop();
					int former = stack.pop();
    				if(ch=='+'){
    					stack.push(former+latter);
    				}
    				else if(ch=='-'){
    					stack.push(former-latter);
    				}
    				else if(ch=='*'){
    					stack.push(former*latter);
    				}
    				else{
    					stack.push(former/latter);
    				}
    			}
    			else{
    				stack.push(Integer.valueOf(tokens[i]));
    			}
    		}
    		return stack.pop();
    	}
    }
    /**
     * �ж��ǲ��ǲ�����
     */
    public boolean isOperate(String str){
    	if(str.length()>1){
    		return false;
    	}
    	char ch = str.charAt(0);
    	return (ch=='+'||ch=='-'||ch=='*'||ch=='/');
    }
    public static void main(String[] args){
    	String[] tokens = {"4", "13", "5", "/", "+"};
    	Solution s = new Solution();
    	System.out.println(s.evalRPN(tokens));
    }
}