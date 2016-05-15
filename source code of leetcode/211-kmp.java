package leetc;
//211 ��Ҫ��kmp�㷨  ʱ�临�ӶȻ���̫��  һ�����ĸ��ط���������  ������ѽ
//ԭ�����ҵ���������� ���⿼��Ĳ�����kmp�㷨
public class WordDictionary {
	private StringBuilder data = new StringBuilder("");
    public void addWord(String word) {
        data.append(word);
    }
    /*
     * KMP�㷨
     * ���Ȼ�ȡ��next[]
     */
    public boolean search(String word) {
    	String str = data.toString();
    	char[] target = str.toCharArray();
    	char[] pattern = word.toCharArray();
    	int[] next = new int[pattern.length];
    	next = getNext(word);
    	int j = 0;
    	for(int i = 0; i < target.length;){
    		if(j==pattern.length){
    			return true;
    		}
    		if(j==-1||pattern[j]=='.'||pattern[j]==target[i]){
    			i++;
    			j++;
    		}
    		else{
    			j = next[j];
    		}
    	}
        return false;
    }
    /*
     * get next
     * ����next��ʱ���൱�����õ���kmp�㷨���������֪��Ϣ
     * next��next��next  
     */
    
    public int[] getNext(String str){//�ж�str���� 
    	char[] ch = str.toCharArray();
    	int[] next = new int[str.length()];
    	next[0] = -1;
    	if(str.length()>1){
    		next[1] = 0;
    	}
    	else{
    		return next;
    	}
    	for(int i = 2; i < str.length();i++){
    		if(ch[next[i-1]]==ch[i-1]){
    			next[i] = next[i-1]+1;
    		}
    		else{//�ص�
    			int temp = next[i-1];
    			while(temp!=-1){
    				if(ch[temp]==ch[i-1]){
    					next[i] = temp+1;
   						break;
   					}
   					else{
   						temp = next[temp];
   					}
    			}///
    			if(temp==-1){
    				next[i] = 0; 
    			}
   			}
   		}
   	return next;
 }
    
    public static void main(String []args){
    	String str = "aaaaaaaaaaaaaaaaaaab";
    	WordDictionary wd = new WordDictionary();
    	wd.getNext(str);
    }
}

