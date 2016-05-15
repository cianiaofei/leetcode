package leetc;

import java.util.HashMap;
import java.util.Vector;

/*
 * 2016.1.16  这个版本当大量数据时存在时间的问题
 * test 236
 * 这个版本引入哈希表 存每个节点的祖先  只需遍历一次树
 */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
	private HashMap<TreeNode,TreeNode> childToparent = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	//traverse the tree
    	if(root == null){
    		return null;
    	}
    	else{
    		saveChildToParent(root);
    		//look for the common ancestor
    		Vector<TreeNode> vecp = new Vector<>();
    		if(p==root){
    			return root;
    		}
    		vecp.add(p);
    		while(p!=root){
    			vecp.add(childToparent.get(p));
    			p = childToparent.get(p);
    		}
    		if(q==root){
    			return q;
    		}
    		Vector<TreeNode> vecq = new Vector<>();
    		vecq.add(q);
    		while(q!=root){
    			vecq.add(childToparent.get(q));
    			q = childToparent.get(q);
    		}
    		//compare
    		int lenp = vecp.size();
    		int lenq = vecq.size();
    		TreeNode tp = vecp.get(lenp-1);
    		TreeNode tq = vecq.get(lenq-1);
    		int i = 1;
    		while(tp==tq){
    			if(i==lenp||i==lenq){
    				return tp;
    			}
    			i++;
    			tp = vecp.get(lenp-i);
    			tq = vecq.get(lenq-i);
    		}
    		return vecp.get(lenp-i+1);
    	}
    }
    public void saveChildToParent(TreeNode tn){
    	if(tn.left!=null){
    		childToparent.put(tn.left,tn);
    		saveChildToParent(tn.left);
    	}
    	if(tn.right!=null){
    		childToparent.put(tn.right,tn);
    		saveChildToParent(tn.right);
    	}
    }
}