package com.zongfei;
/**
 *md还是没想清楚 先留着315 
 *好像每次遍历到它都更新一次就可以了
 *什么时候更新的问题 已经把我搞晕了
 */
import java.util.LinkedList;
import java.util.List;

public class Solution {
	class TreeNode{
		int curValue;
		int count;
		int minThanIt;
		TreeNode parent;
		TreeNode left;
		TreeNode right;
		TreeNode(int curValue,int count){
			this.curValue = curValue;
			this.count = count;
		}
	}
    public List<Integer> countSmaller(int[] nums) {
    	List<Integer> list = new LinkedList<Integer>();
    	TreeNode tn = null;
    	for(int i = nums.length-1;i>=0;i--){
    		tn = buildBT(tn,list,nums[i]);
    	}
		return list;
    }
	private TreeNode buildBT(TreeNode tn, List<Integer> list, int value) {
		if(tn==null){
			tn = new TreeNode(value,1);
			list.add(0,tn.minThanIt);
		}
		else{
			update(tn);
			if(tn.curValue==value){
				tn.count++;
				list.add(0,tn.minThanIt);
			}
			else if(tn.curValue>value){
				tn.minThanIt++;
				if(tn.left==null){
					tn.left = new TreeNode(value,1);
					list.add(0,Math.max(0,tn.minThanIt-tn.count));
					tn.left.parent = tn;
					tn.left.minThanIt = Math.max(0,tn.minThanIt-tn.count);
				}
				else{
					buildBT(tn.left,list,value);
				}
			}
			else{
				if(tn.right==null){
					tn.right = new TreeNode(value,1);
					list.add(0,tn.minThanIt+tn.count);
					tn.right.parent = tn;
					tn.right.minThanIt = tn.minThanIt+tn.count;
				}
				else{
					buildBT(tn.right,list,value);
				}
			}
		}
		return tn;
	}
	private boolean isRight(TreeNode tn) {
		// TODO Auto-generated method stub
		if(tn.parent==null){
			return false;
		}
		return tn.parent.curValue<tn.curValue;
	}
	private void update(TreeNode tn) {
		if(tn.parent==null){
			return ;
		}
		else{
			tn.minThanIt = Math.max(tn.parent.minThanIt+tn.parent.count,tn.minThanIt);
		}
	}
	public static void main(String[] args){
		int nums[] = {51,9,21,84,66,65,36,100,41};
		Solution s = new Solution();
		System.out.println(s.countSmaller(nums));
	}
}