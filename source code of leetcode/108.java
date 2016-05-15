package leetc;

/**108
 * 类似二分查找.
 * java中参数传值一定要注意   引用传递很坑的   其实引用传递也是一个副本只是指向同一块内存而已
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums.length==0){
    		return null;
    	}
    	else{
    		return recuBuildBST(nums,0,nums.length);
    	}
    }
    /*
     *find the middle 
     *divide into the left and the right and recursive 
    */
    public TreeNode recuBuildBST(int[] nums,int start,int end){
    	int mid = (start + end)/2;
    	TreeNode tn = new TreeNode(nums[mid]);
    	int startLeft = start;
    	int endLeft = mid;
    	int startRight = mid+1;
    	int endRight = end;
    	if(startLeft!=endLeft){
    		recuBuildBST(tn,nums,startLeft,endLeft,1);
    	}
    	if(startRight!=endRight){
    		recuBuildBST(tn,nums,startRight,endRight,-1);
    	}
    	return tn;
    }
    public void recuBuildBST(TreeNode tn,int[] nums,int start,int end,int flag){
    	int temp;
    	int mid = (start + end)/2;
    	if(flag==1){
    		temp = 1;
    		tn.left = new TreeNode(nums[mid]);
    	}
    	else{
    		temp = -1;
    		tn.right = new TreeNode(nums[mid]);
    	}
    	int startLeft = start;
    	int endLeft = mid;
    	int startRight = mid+1;
    	int endRight = end;
    	TreeNode tt = null;
    	if(temp==1){
    		tt = tn.left;
    	}
    	else{
    		tt = tn.right;
    	}
    	if(startLeft!=endLeft){
    		recuBuildBST(tt,nums,startLeft,endLeft,1);
    	}
    	if(startRight!=endRight){
    		recuBuildBST(tt,nums,startRight,endRight,-1);
    	}
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] nums = {0,1,2,3,4,5};
    	s.sortedArrayToBST(nums);
    	System.out.println("");
    }
}