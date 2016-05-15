package leetc;

/*
 * 2016.1.16  这个版本当大量数据时存在时间的问题
 * test 236
 */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isContain(root,p,q,0)){
        	if(isContain(root.left,p,q,0)){
        		return lowestCommonAncestor(root.left,p,q);
        	}
        	else if(isContain(root.right,p,q,0)){
        		return lowestCommonAncestor(root.right,p,q);
        	}
        	else{
        		return root;
        	}
        }
        else{/////buhuizoudaozhe
        	return null;
        }
    }
    public boolean isContain(TreeNode tn,TreeNode p,TreeNode q,int count){
    	if(count==2){
    		return true;
    	}
    	if(tn==null){
    		return false;
    	}
    	else{
    		if(tn==p||tn==q){
    			count++;
    			return isContain(tn.left,p,q,count)||isContain(tn.right,p,q,count);
    		}
    		else{
    			return isContain(tn.left,p,q,count)||isContain(tn.right,p,q,count);
    		}
    	}
    }
}