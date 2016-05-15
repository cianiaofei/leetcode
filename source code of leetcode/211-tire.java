package leetc;
/*
 * 用到的是tire树
 * isEnd是不是字符串结尾
 * childs孩儿们 
 * branch划分各分支的依据 与childs对应
 */

import java.util.ArrayList;
import java.util.Vector;

class Tire{
    char value;
	int isEnd;
	ArrayList<Tire> childs = new ArrayList<>();
	Vector<Character> branch = new Vector<>();
	public Tire(){}
	public Tire(char ch){
		this.value = ch;
	}
}
public class WordDictionary {
	private Tire root = new Tire();
    public void addWord(String word) {
    	Tire tire = root;
    	int wordLen = word.length();
    	for(int i = 0; i < wordLen;i++){
    		char currentChar = word.charAt(i);
    		if(tire.branch.contains(currentChar)){
    			tire = tire.childs.get(find(currentChar,tire.branch));
    		}
    		else{
    			while(i<wordLen){
    				currentChar = word.charAt(i);
    				tire.branch.add(currentChar);
    				Tire newTire = new Tire(currentChar);
    				tire.childs.add(newTire);
    				tire = newTire;
    				tire.isEnd = -1;
    				i++;
    			}
    			tire.isEnd = 1;
    			break;
    		}
    	}
    }
    /*
     * 寻找当前字符所在的位置
    */
    public int find(char ch,Vector<Character> vec){
    	for(int i = 0; i < vec.size();i++){
    		if(vec.get(i)==ch){
    			return i;
    		}
    	}
    	return -1;
    }
    
    /*
     * 从根开始往下搜
     * 遇到.时特别注意
     */
    public boolean search(String word){
    	return search(word,root);
    }
    public boolean search(String word,Tire tire){
    	for(int i = 0; i < word.length();i++){
    		char currentCh = word.charAt(i);
    		if(currentCh != '.'){
    			if(!tire.branch.contains(currentCh)){
    				return false;
    			}
    			else{
    				if(i==word.length()-1){
    					tire = tire.childs.get(find(currentCh,tire.branch));
    					if(tire.isEnd==1){
    						return true;
    					}
    					else{
    						return false;
    					}
    				}
    				else{
    					tire = tire.childs.get(find(currentCh,tire.branch));
    				}
    			}
    		}
    		else{
    			if(i==word.length()-1){
    				if(Iscontains(tire.childs)){
    					return true;
    				}
    				else{
    					return false;
    				}
    			}
    			else{
    				String str = word.substring(i+1,word.length());
    				for(int index = 0; index < tire.childs.size();index++){
    					if(search(str,tire.childs.get(index))){
    						return true;
    					}
    				}
    				return false;
    			}
    		}
    	}
		return false;
    }
    
    public boolean Iscontains(ArrayList<Tire> al){
    	for(int i = 0; i < al.size();i++){
    		if(al.get(i).isEnd==1){
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args){
    	WordDictionary wd = new WordDictionary();
    	wd.addWord("a");
    	wd.addWord("ab");
    	System.out.println(wd.search("a"));
    	System.out.println(wd.search("a.")); 
    	System.out.println(wd.search("ab"));
    	System.out.println(wd.search(".a")); 
    	System.out.println(wd.search(".b"));
    	System.out.println(wd.search("ab.")); 
    	System.out.println(wd.search("."));
    	System.out.println(wd.search("..")); 
    }
}

