package leetc;

import java.util.ArrayList;

/*
 * 208
 *相当于加深下记忆  比含有正则表达式的简单的度
 */
class TrieNode {
	char value;
    ArrayList<TrieNode> childs = new ArrayList<>();
    ArrayList<Character> branch = new ArrayList<>();
    int isEnd;
    public TrieNode() {}
    public TrieNode(char ch){
    	value = ch;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode trie = root;
    	int wordLen = word.length();
    	for(int i = 0; i < wordLen;i++){
    		char currentCh = word.charAt(i);
    		if(trie.branch.contains(currentCh)){
    			trie = trie.childs.get(find(currentCh,trie.branch));
    			if(i==(wordLen-1)){
    				trie.isEnd = 1;
    			}
    		}
    		else{
    			while(i<wordLen){
    				currentCh = word.charAt(i);
    				trie.branch.add(currentCh);
    				TrieNode newTire = new TrieNode(currentCh);
    				trie.childs.add(newTire);
    				trie = newTire;
    				trie.isEnd = -1;
    				i++;
    			}
    			trie.isEnd = 1;
    			break;
    		}
    	}
    }
   
    // Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode trie = root;
    	for(int i = 0; i < word.length();i++){
    		char currentCh = word.charAt(i);
    		if(!trie.branch.contains(currentCh)){
    			return false;
    		}
    		else{
    			if(i==word.length()-1){
    				trie = trie.childs.get(find(currentCh,trie.branch));
    				if(trie.isEnd==1){
    					return true;
    				}
    				else{
    					return false;
    				}
    			}
    			else{
    				trie = trie.childs.get(find(currentCh,trie.branch));
    			}
    		}
    	}
    	return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode trie = root;
    	for(int i = 0; i < prefix.length();i++){
    		char currentCh = prefix.charAt(i);
    		if(!trie.branch.contains(currentCh)){
    			return false;
    		}
    		else{
    				trie = trie.childs.get(find(currentCh,trie.branch));
    			}
    		}
    	return true;
    }
    /*
     * 寻找当前字符所在的位置
    */
    public int find(char ch,ArrayList<Character> vec){
    	for(int i = 0; i < vec.size();i++){
    		if(vec.get(i)==ch){
    			return i;
    		}
    	}
    	return -1;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");