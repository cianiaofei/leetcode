package com.zongfei;
/**28
 * 和朴素匹配非常类似 只是主串不需要再回溯了
 */
public class KMPTest {
    public int strStr(String haystack, String needle) {
    	if(haystack==null){
    		return -1;
    	}
    	else if(needle==null||needle.length()==0){
    		return 0;
    	}
        return kmpStringMatch(haystack,needle);
    }
    public int kmpStringMatch(String str,String target){
    	int[] next = new int[target.length()];
    	buildNext(target,next);
    	int n = str.length();
    	int m = target.length();
    	int i = 0; int j = 0;
    	while(i<n&&j<m){
    		if(j==-1||str.charAt(i)==target.charAt(j)){
    			i++;
    			j++;
    		}
    		else{
    			j = next[j];
    		}
    	}
    	if(j==m&&target.charAt(j-1)==str.charAt(i-1)){
    		return i-m;
    	}
    	else{
    		return -1;
    	}
    }
	public void buildNext(String target, int[] next) {
		next[0] = -1;
		if(target.length()==1){
			return;
		}
		next[1] = 0;
		int i = 2;
		while(i<target.length()){
			int pre = next[i-1];
			if(target.charAt(i-1)==target.charAt(pre)){
				next[i] = pre + 1;
				i++;
			}
			else{
				while(pre>=0&&target.charAt(i-1)!=target.charAt(pre)){
					pre = next[pre];
				}
				next[i] = pre + 1;
				i++;
			}
		}
	}
	public static void main(String[] args){
		KMPTest s = new KMPTest();
		System.out.println(s.kmpStringMatch("mississippi","issip"));
	}
}//
