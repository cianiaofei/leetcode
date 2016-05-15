package leetc;

import java.util.ArrayList;
import java.util.Stack;

/*
 *Ҫ����ԭ����ʽ���п��ܻ��пո�
 *��һ����׺ת��׺ 
*/
public class Solution {
	private ArrayList<String> postArray = new ArrayList<>();
	private Stack<Character> opStack = new Stack<>();
	private Stack<Integer> resultStack = new Stack<>();
    public int calculate(String s) {
       //
    	inToPost(s);
    	/////�����沨��ʽ����ʽ��ֵ
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
    /*��׺תΪ��׺ �浽postArray��  �õ�opStack
     * ����ֱ�ӷ� ��postArray
     * Ҫע�⿼�ǿ��ܻ��пո�
     * �Ȱ����������� ������ֱ�ӷ�  ������һֱ����'('
     */
    public void inToPost(String st){
    	for(int i = 0; i < st.length();i++){
    		if(st.charAt(i)==' '){
    			//�ո񲻹�ֱ����һ��
    		}
    		else if(st.charAt(i)=='('){//'('ֱ�ӷŽ�ȥ
    			opStack.push(st.charAt(i));
    		}
    		else if(isNum(st.charAt(i))){///����
    			String str = "";
    			while(i<st.length()&&isNum(st.charAt(i))){
    				str += st.charAt(i);
    				i++;
    			}//һֱ�ӵ���������
    			postArray.add(str);
    			i--;//forѭ������и�++
    		}
    		else if(st.charAt(i)=='+'||st.charAt(i)=='-'){
    			if(opStack.isEmpty()||opStack.peek()=='('){//opStackΪ�ջ���ջ��Ϊ������
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
    			if(opStack.isEmpty()||opStack.peek()=='('){//opStackΪ�ջ���ջ��Ϊ������
    				opStack.add(st.charAt(i));
    			}
    			else{
    				while(!opStack.isEmpty()&&(opStack.peek()=='*'||opStack.peek()=='/')){
    					postArray.add(opStack.pop()+"");
    				}
    				opStack.push(st.charAt(i));
    			}
    		}
    		else{///������
    			if(st.charAt(i)==')'){
    				while(opStack.peek()!='('){
    					postArray.add(opStack.pop()+"");
    				}
    				opStack.pop();
    			}
    			else{}
    		}
    	}////////
    	//���ջ�ﻹ�ж����������
    	while(!opStack.isEmpty()){
    		postArray.add(opStack.pop()+"");
    	}
    }
    /*
     * �ж��Ƿ�Ϊ����
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
 