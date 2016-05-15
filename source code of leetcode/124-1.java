package leetc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 图的深度优先遍历
 * 124
 * Definition for a binary tree node.
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public int maxPathSum(TreeNode root) {
    	if(root==null){
    		return 0;
    	}
    	else{
    		//给孩子找父亲
    		HashMap<TreeNode,TreeNode> parent = new HashMap<>();
    		setParentForChild(root,parent);
    		parent.put(root,null);
    		//对图进行深度优先遍历
    		HashMap<TreeNode,Integer> sum = new HashMap<>();
    		Set<TreeNode> keySet = parent.keySet();
    		Iterator<TreeNode> ite = keySet.iterator();
    		int max = Integer.MIN_VALUE;
    		Set<TreeNode> used = new HashSet<>();
    		while(ite.hasNext()){
    			TreeNode cur = ite.next();
    			if(sum.containsKey(cur)){
    				if(max<sum.get(cur)){
    					max = sum.get(cur);
    				}
    			}
    			else{
    				int value = calculatSum(cur,parent,sum,used);
    				used.remove(cur);
    				if(value>max){
    					max = value;
    				}
    				sum.put(cur, value);
    			}
    		}
    		return max;
    	}
    }
    
    /**
     * 求从某个远点出发的累加值 
     */
    public int calculatSum(TreeNode tn,HashMap<TreeNode,TreeNode> parent,
    		HashMap<TreeNode,Integer> sum,Set<TreeNode> used){
    	used.add(tn);
    	if(tn==null){
    		return 0;
    	}
    	else if(sum.containsKey(tn)){
    		return sum.get(tn);
    	}
    	else{
    		int max = Integer.MIN_VALUE;
    		int left = Integer.MIN_VALUE;
    		if(!used.contains(tn.left)){
    			left = tn.val + calculatSum(tn.left,parent,sum,used);
    			used.remove(tn.left);
    		}
    		int right = Integer.MIN_VALUE;
    		if(!used.contains(tn.right)){
    			right = tn.val + calculatSum(tn.right,parent,sum,used);
    			used.remove(tn.right);
    		}
    		int parents = Integer.MIN_VALUE;
    		if(!used.contains(parent.get(tn))){
    			parents = tn.val + calculatSum(parent.get(tn),parent,sum,used);
    			used.remove(parent.get(tn));
    		}
    		max = Math.max(Math.max(left, right),parents);
    		sum.put(tn,max);
    		return max;
    	}
    }
    
    /*
     *为孩子找父亲节点 
     */
    public void setParentForChild(TreeNode tn,HashMap<TreeNode,TreeNode> parent){
    	if(tn==null){
    		return ;
    	}
    	else{
    		if(tn.left!=null){
    			parent.put(tn.left, tn);
    		}
    		if(tn.right!=null){
    			parent.put(tn.right, tn);
    		}
    		setParentForChild(tn.left,parent);
    		setParentForChild(tn.right,parent);
    	}
    }
    public static void main(String[] args){
    	TreeNode tn = new TreeNode(1);
    	tn.left = new TreeNode(2);
    	tn.right = new TreeNode(4);
    	tn.left.left = new TreeNode(3);
    	tn.left.right = new TreeNode(5);
    	Solution s = new Solution();
    	System.out.println(s.maxPathSum(tn));
    }
}