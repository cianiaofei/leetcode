package leetc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 316
 *这题不简单呀
 *妈的这题好烦人
 *参考的别人的想法是这样的：找最后一次出现的位置。然后对第一个字母的位置会产生约束条件
 *然后再找第一个 第一个找到了  然后递归  这也算是贪心算法吧
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
		if(s==null||s.length()<2){
			return s;
		}
		else{
			Set<Character> kind = new HashSet<Character>();
			List<Integer> lastPlace = new ArrayList<>();
			char[] chs = s.toCharArray();
			for(int i = chs.length-1; i >= 0;i--){}
			for(int i = chs.length-1; i >= 0;i--){//for
				if(!kind.contains(chs[i])){
					lastPlace.add(i);
					kind.add(chs[i]);
				}
			}//for
			StringBuilder sb = new StringBuilder();
			storeSB(sb,kind,lastPlace,chs,0);
			return sb.toString();
		}
    }

	public void storeSB(StringBuilder sb, Set<Character> kind, List<Integer> lastPlace, char[] chs, int start) {
		// TODO Auto-generated method stub
		if(lastPlace.size()== 0){
			return ;
		}
		else{
			int curEnd = lastPlace.get(lastPlace.size()-1);
			if(start==curEnd){
				if(kind.contains(chs[curEnd])){
					sb.append(chs[curEnd]);
					kind.remove(chs[curEnd]);
				}
				lastPlace.remove(lastPlace.size()-1);
				storeSB(sb,kind,lastPlace,chs,curEnd+1);
			}
			else{
				int minPlace = findMinPlace(chs,start,curEnd);
				if(chs[minPlace]>=chs[curEnd]){
					if(kind.contains(chs[curEnd])){
						sb.append(chs[curEnd]);
						kind.remove(chs[curEnd]);
					}
					lastPlace.remove(lastPlace.size()-1);
					storeSB(sb,kind,lastPlace,chs,curEnd+1);
				}
				else{
					if(kind.contains(chs[minPlace])){
						sb.append(chs[minPlace]);
						kind.remove(chs[minPlace]);
					}
					for(int i = minPlace+1; i < curEnd;i++){
						if(chs[i]<chs[curEnd]&&kind.contains(chs[i])){
							sb.append(chs[i]);
							kind.remove(chs[i]);
						}
						else if(chs[i]==chs[curEnd]){
							if(kind.contains(chs[i])){
								sb.append(chs[i]);
								kind.remove(chs[i]);
							}
							lastPlace.remove(lastPlace.size()-1);
							while(!lastPlace.isEmpty()){
								curEnd = lastPlace.get(lastPlace.size()-1);
								if(!kind.contains(chs[curEnd])){
									break;
								}
							}
						}
						else{
						}
					}
					storeSB(sb,kind,lastPlace,chs,curEnd+1);
				}
			}
		}
	}
	/**
	 * 找最小字符所在的位置
	 */
	public int findMinPlace(char[] chs,int start,int end){
		int minPlace = start;
		for(int i = start+1; start<end; i++){
			if(chs[minPlace]>chs[i]){
				minPlace = i;
			}
		}
		return minPlace;
	}
	/**
	 *判读该字符是不是这一段中最小的 
	 */
	private boolean isMin(char[] chs, int start, int curEnd) {
		// TODO Auto-generated method stub
		char measure = chs[curEnd];
		boolean isMin = true;
		for(int i = start; i < curEnd;i++){
			if(chs[i]<measure){
				isMin = false;
			}
		}
		return isMin;
	}

	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.removeDuplicateLetters("cbaddabaa"));
	}
}