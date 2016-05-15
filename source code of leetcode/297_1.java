package leetc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

/**
 * 一层层的来  不简单
 * 存先序和中序貌似简单很多
 * 当时没考虑有相同数字时的情况  结果真有这种情况
 * 有重复数字时 中序与先序确定树是否还行的通呢(行不通)
 * 这里引入了两个HashMap最后超时 nlogn感觉时间复杂度不高呀
 * 明明挺快的 10000的数据时 用hashmap遍历很慢为什么呢
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Codec {
    // 先序和中序 重复的应hashmap存起来
    public StringBuilder serialize(TreeNode root) {
    	HashMap<Integer,Integer> showMapAct = new HashMap<>();
    	HashMap<TreeNode,Integer> nodeMapShow = new HashMap<>();
    	HashSet<Integer> set = new HashSet<>();//store the all values
        Vector<Integer> preOrderVec = new Vector<>();
    	Vector<Integer> inOrderVec = new Vector<>();
        preOrderTraverse(root,preOrderVec,set,showMapAct,nodeMapShow);
        inOrderTraverse(root,inOrderVec,nodeMapShow);//
        StringBuilder preStr = preOrderVec.toStringBuilder();
        preStr = preStr.subStringBuilder(1,preStr.length()-1)+",";
        StringBuilder inStr = inOrderVec.toStringBuilder();
        inStr = inStr.subStringBuilder(1,inStr.length()-1);
        StringBuilder result =  preStr+inStr;
        StringBuilder extraInfo = "";
        //traverse the hashMap ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！慢
        Set<Entry<Integer,Integer>> entrySet = showMapAct.entrySet();
        for(HashMap.Entry<Integer,Integer> entry:entrySet){
            StringBuilder temp = entry.getKey()+":"+entry.getValue();
        	extraInfo += temp + ",";
        }
        if(showMapAct.isEmpty()){
        	return result +"k";
        }
        else{
        	return result +"k"+extraInfo.subStringBuilder(0,extraInfo.length()-1);
        }
    }
    //preOrder
    public void preOrderTraverse(TreeNode tn,Vector<Integer> preOrderVec,
    		HashSet<Integer> set,HashMap<Integer,Integer> showMapAct,HashMap<TreeNode,Integer> nodeMapShow){
    	if(tn==null){
    		return ;
    	}
    	else{
    		int value = tn.val;
    		if(set.contains(value)){
    			Random rand = new Random();
    			int keyValue = rand.nextInt(Integer.MAX_VALUE);
    			while(set.contains(keyValue)){
    				keyValue = rand.nextInt(Integer.MAX_VALUE);
    			}//use the random vaule replace the actual 
    			value = keyValue;
    			showMapAct.put(value,tn.val);
    			nodeMapShow.put(tn,value);
    		}
    		set.add(value);
    		preOrderVec.add(value);
    		preOrderTraverse(tn.left,preOrderVec,set,showMapAct,nodeMapShow);
    		preOrderTraverse(tn.right,preOrderVec,set,showMapAct,nodeMapShow);
    	}
    }
    //inOrder
    public void inOrderTraverse(TreeNode tn,Vector<Integer> inOrderVec,
    		HashMap<TreeNode,Integer> nodeMapShow){
    	if(tn==null){
    		return ;
    	}
    	else{
    		int value = tn.val;
    		if(nodeMapShow.containsKey(tn)){
    			value = nodeMapShow.get(tn);
    		}
    		inOrderTraverse(tn.left,inOrderVec,nodeMapShow);
    		inOrderVec.add(value);
    		inOrderTraverse(tn.right,inOrderVec,nodeMapShow);
    	}
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(StringBuilder data) {
        //分成两组
    	HashMap<Integer,Integer> showMapAct = new HashMap<>();
    	StringBuilder[] result = data.split("k");
    	//deal with showMapAct
    	if(result.length==1 || result[1].length()==0){
    	}
    	else{
    		StringBuilder[] extraInfo = result[1].split(",");
    		for(int i = 0; i < extraInfo.length;i++){
    			StringBuilder[] temp = extraInfo[i].split(":");
    			showMapAct.put(Integer.valueOf(temp[0]),Integer.valueOf(temp[1]));
    		}///////
    	}
    	StringBuilder[] nums = result[0].split(",");
    	int[] preOrder = new int[nums.length/2];
    	int[] inOrder = new int[nums.length/2];
    	initArray(preOrder,nums,0,nums.length/2);
    	initArray(inOrder,nums,nums.length/2,nums.length);
    	return constructTree(preOrder,0,preOrder.length,inOrder,0,inOrder.length,showMapAct);
    }
    //init the array
    public void initArray(int[] arr,StringBuilder[]str,int start,int end){
    	for(int i = start; i < end;i++){
    		arr[i-start] = Integer.valueOf(str[i].trim());
    	}
    }
    
    public TreeNode constructTree(int[]preOrder,int preStart,int preEnd,
    		int[]inOrder,int inStart,int inEnd,HashMap<Integer,Integer> showMapAct){
    	if(preStart==preEnd){///////the condition to exit
    		return null;
    	}
    	else{
    		int value = preOrder[preStart];
    		if(showMapAct.containsKey(value)){
    			value = showMapAct.get(value);
    		}
    		TreeNode tn = new TreeNode(value);
    		//look for the position in the inorder sequence
    		int place = findPositionInorder(inOrder,preOrder[preStart]);
    		tn.left = constructTree(preOrder,preStart+1,preStart+(place-inStart)+1,inOrder,inStart,place,showMapAct);
    	    tn.right = constructTree(preOrder,preStart+(place-inStart)+1,preEnd,inOrder,place+1,inEnd,showMapAct);
    	    return tn;
    	}
    }
    //look for the position in the inorder sequence
    public int findPositionInorder(int[]inOrder,int value){
    	int place = 0;
    	while(inOrder[place] != value){
    		place++;
    	}
    	return place;
    }
    ////levelBuildTree
    /*
     * 一层层的来建树，要引入队列不需要递归
    */
    public TreeNode levelBuildTree(int[] nums){
    	Deque<TreeNode> deque = new LinkedList<>();
    	TreeNode tn = new TreeNode(nums[0]);
    	deque.add(tn);
    	int i = 0;
    	while(!deque.isEmpty()){
    		TreeNode temp = deque.remove();
    		if((++i)!=nums.length){
    			temp.left = new TreeNode(nums[i]);
    			deque.add(temp.left);
    		}
    		else{
    			break;
    		}
    		if((++i)!=nums.length){
    			temp.right = new TreeNode(nums[i]);
    			deque.add(temp.right);
    		}
    		else{
    			break;
    		}
    	}
    	return tn;
    }
    //读数据
    public int[] fileRead(StringBuilder fileName) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(fileName));
    	StringBuilder str = br.readLine();
    	StringBuilder result[] = str.split(",");
    	int[] nums = new int[result.length];
    	for(int i = 0; i < nums.length;i++){
    		nums[i] = Integer.valueOf(result[i]);
    	}
    	br.close();
    	return nums;
    }
    
    public static void main(String []args) throws IOException{
    	Codec codec = new Codec();
    	//读文件
    	int nums[] = codec.fileRead("data.txt");
    	//////////////////////////////////
    	 TreeNode root = codec.levelBuildTree(nums);
    	 codec.deserialize(codec.serialize(root));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));