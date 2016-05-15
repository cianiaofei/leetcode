package leetc;

import java.util.ArrayList;
import java.util.Stack;

/*
 *要考虑原来的式子中可能会有空格
 *第一步中缀转后缀 
*/
public class Solution {
	private ArrayList<String> postArray = new ArrayList<>();
	private Stack<Character> opStack = new Stack<>();
	private Stack<Integer> resultStack = new Stack<>();
    public int calculate(String s) {
       //
    	inToPost(s);
    	/////根据逆波兰式求表达式的值
    	for(String str:postArray){
    		if(isNum(str.charAt(0))){
    			resultStack.push(Integer.valueOf(str));
    		}
    		else{
    			if(str.charAt(0)=='+'){
    				int a = resultStack.pop();
    				int b = resultStack.pop();
    				resultStack.push(b+a);
    			}
    			else if(str.charAt(0)=='-'){
    				int a = resultStack.pop();
    				int b = resultStack.pop();
    				resultStack.push(b-a);
    			}
    			else if(str.charAt(0)=='*'){
    				int a = resultStack.pop();
    				int b = resultStack.pop();
    				resultStack.push(b*a);
    			}
    			else{
    				int a = resultStack.pop();
    				int b = resultStack.pop();
    				resultStack.push(b/a);
    			}
    		}
    	}
    	return resultStack.peek();
    }
    /*中缀转为后缀 存到postArray中  用到opStack
     * 数字直接放 到postArray
     * 要注意考虑可能会有空格
     * 先把里面的输出来 ‘（’直接放  ‘）’一直出到'('
     */
    public void inToPost(String st){
    	for(int i = 0; i < st.length();i++){
    		if(st.charAt(i)==' '){
    			//空格不管直接下一个
    		}
    		else if(st.charAt(i)=='('){//'('直接放进去
    			opStack.push(st.charAt(i));
    		}
    		else if(isNum(st.charAt(i))){///数字
    			String str = "";
    			while(i<st.length()&&isNum(st.charAt(i))){
    				str += st.charAt(i);
    				i++;
    			}//一直加到不是数字
    			postArray.add(str);
    			i--;//for循环最后还有个++
    		}
    		else if(st.charAt(i)=='+'||st.charAt(i)=='-'){
    			if(opStack.isEmpty()||opStack.peek()=='('){//opStack为空或者栈顶为左括号
    				opStack.add(st.charAt(i));
    			}
    			else{
    				while(!opStack.isEmpty()&&opStack.peek()!='('){
    					postArray.add(opStack.pop()+"");
    				}
    				opStack.push(st.charAt(i));
    			}
    		}////
    		else if(st.charAt(i)=='*'||st.charAt(i)=='/'){
    			if(opStack.isEmpty()||opStack.peek()=='('){//opStack为空或者栈顶为左括号
    				opStack.add(st.charAt(i));
    			}
    			else{
    				while(!opStack.isEmpty()&&(opStack.peek()=='*'||opStack.peek()=='/')){
    					postArray.add(opStack.pop()+"");
    				}
    				opStack.push(st.charAt(i));
    			}
    		}
    		else{///‘）’
    			if(st.charAt(i)==')'){
    				while(opStack.peek()!='('){
    					postArray.add(opStack.pop()+"");
    				}
    				opStack.pop();
    			}
    			else{}
    		}
    	}////////
    	//如果栈里还有东西都输出来
    	while(!opStack.isEmpty()){
    		postArray.add(opStack.pop()+"");
    	}
    }
    /*
     * 判断是否为数字
    */
    public boolean isNum(char ch){
    	if(ch>='0'&&ch<='9'){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    //////////////////////////////////////////////
    public static void main(String args[]){
    	Solution s = new Solution();
    	String str = " 3+5 / 2 ";
    	System.out.println(s.calculate(str));
    }
}
 