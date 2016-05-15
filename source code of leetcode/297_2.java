package leetc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Codec {
    // Encodes a tree to a single StringBuilder.
    public String serialize(TreeNode root) {
    	//calculate the sum of the tree
    	if(root==null){
    		return "null";
    	}
    	int result = calculateSum(root);
    	//
    	StringBuilder levelTraverse = new StringBuilder("");
    	Deque<TreeNode> deque = new LinkedList<>();
    	deque.add(root);
    	int count = 1;
    	levelTraverse.append(root.val+"");
    	while(count<result){
    		if(!deque.isEmpty()){
    			TreeNode tn = deque.remove();
    			if(tn==null){
    				levelTraverse.append(",null");
    				levelTraverse.append(",null");
    				deque.add(null);
    				deque.add(null);
    			}
    			else{
    				if(tn.left!=null){
        				count++;
        				deque.add(tn.left);
        				levelTraverse.append(","+tn.left.val);
        				if(count==result){
        					break;
        				}
        			}
        			else{
        				deque.add(tn.left);
        				levelTraverse.append(",null");
        			}
    				if(tn.right!=null){
    					count++;
    					deque.add(tn.right);
    					levelTraverse.append(","+tn.right.val);
    				}
    				else{
    					deque.add(tn.right);
    					levelTraverse.append(",null");
    				}
    			}
    		}
    	}
    	return levelTraverse.append(","+result).toString();
    }
    /*
     * calculate the sum of valid TreeNode
    */
    public int calculateSum(TreeNode tn){
    	if(tn==null){
    		return 0;
    	}
    	else{
    		return calculateSum(tn.left)+calculateSum(tn.right)+1;
    	}
    }
    // Decodes your encoded data to tree.
    /*
     * the last count
     */
    public TreeNode deserialize(String data) {
    	if(data.equals("null")){
    		return null;
    	}
        String[] str = data.split(",");
        ///level build tree
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        deque.add(root);
        //根据坐标之间的关系来做 创建所有节点
        TreeNode[] tnArr = new TreeNode[str.length-1];
        for(int i = 0; i < tnArr.length;i++){
        	if(!str[i].equals("null")){
        		tnArr[i] = new TreeNode(Integer.valueOf(str[i]));
        	}
        	else{
        		tnArr[i] = null;
        	}
        }///////////
        for(int i = 0; i < tnArr.length;i++){
        	if(tnArr[i]!=null){
        		if((2*i+1)<tnArr.length){
        			tnArr[i].left = tnArr[2*i+1];
        		}
        		else{
        			break;
        		}
        		if((2*i+2)<tnArr.length){
        			tnArr[i].right = tnArr[2*i+2];
        		}
        	}
        }
        return tnArr[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));