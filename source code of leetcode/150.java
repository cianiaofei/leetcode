package leetc;

import java.util.Stack;

/**
 * 150  简单到爆炸
 * 输入的是逆波兰式 用字符数组来表示的  输出为相应的值
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
     * 判断是不是操作符
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