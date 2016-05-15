package leetc;
//211 主要是kmp算法  时间复杂度还是太高  一定是哪个地方出问题了  不高了呀
//原来是我的理解有问题 这题考察的并不是kmp算法
public class WordDictionary {
	private StringBuilder data = new StringBuilder("");
    public void addWord(String word) {
        data.append(word);
    }
    /*
     * KMP算法
     * 首先获取其next[]
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
     * 在求next的时候相当于又用到了kmp算法充分利用已知信息
     * next的next的next  
     */
    
    public int[] getNext(String str){//判断str长度 
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
    		else{//重点
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

