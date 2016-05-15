/*
 * 5Ѱ��������� 
 * ����տ�ʼ�����������ٵ��㷨��ʨ�ӳ����޴��¿�
 * �ȽϺ�����һ�ַ��� �ǻ��Ĵ��϶��Ǹ����� ���������ĵ����ߵķ���   
 * �״�㣺������Ŀ����������ַ�֮��Ŀ�϶ 
 */
package leetc;

public class Solution {
	/*
	 *�����ĵ����ߵĲ���
	 *�������Ŀ������ַ���Ҳ�����������ַ�֮�� ����ͳһ�������ַ�֮��ӡ�#��
	 *��������� ���ַ�������׷���ַ��ͽ��ַ����뵽�ַ�����ǰ��ʱ�俪������ܴ� ������ʱ�临�ӶȺ�����ʱ�临�Ӷ�
	 *maxStr������ tempStr�浱ǰ�Ը��ַ�Ϊ���ĵĻ��Ĵ�
	 *offset�������ߵ�ƫ��
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
     *����������ĺ�벿��  ���ݺ�벿�ֲ�ȫǰ�벿��
     *��Ҫһ����ת����
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
     * �����������ַ���϶  ����ַ���#��Ŀ����Ϊ��ͳһ����
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
     * ���Ժ���
     */
    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.longestPalindrome("cccccc"));
    }
}
/*
 * �����ʱ
 */
 