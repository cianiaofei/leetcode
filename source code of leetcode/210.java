package leetc;
/**
 * 实质是判断这个图是否有环
 * 拓扑排序  入度为0
 * 时间复杂度太高了  time limit
 * 改进：把入度信息记录下来  不用每次都重新计算
 * 210应该不难
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int[] result = new int[numCourses];
    	for(int i = 0; i < numCourses;i++){
    		result[i] = i;
    	}
        if(numCourses==0||prerequisites==null||prerequisites.length==0){
        	return result;
        }
        else{
        	int[] inValue = new int[numCourses];
        	boolean[][] matrix = new boolean[numCourses][numCourses];
        	for(int row = 0; row < prerequisites.length;row++){//////////
        			int tempCol = prerequisites[row][0];
        			int tempRow = prerequisites[row][1];
        			if(matrix[tempRow][tempCol]==false){
        				matrix[tempRow][tempCol] = true;
            			inValue[tempCol]++;
        			}
        	}///////////
        	int[] courses = new int[numCourses];
        	for(int i = 0; i < courses.length;i++){
        		courses[i] = 1;
        	}
        	int index = 0;
        	while(numCourses!=0){
        		int target = -1;
        		for(int col = 0;col < matrix.length;col++){///
        			if(courses[col]!=0&&inValue[col]==0){
        				target = col;
        				break;
        			}
        		}
        		if(target==-1){
        			return new int[0];
        		}
        		courses[target] = 0;
        		result[index++] = target;
        		for(int i = 0; i < matrix.length;i++){
        			if(matrix[target][i]==true){
        				matrix[target][i] = false;
            			inValue[i]--;
        			}
        		}
        		numCourses--;
        	}//while
        	if(numCourses==0){
        		return result;
        	}
        	else{
        		return new int[0];
        	}
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[][] matrix = {{1,0}};
    	System.out.println(s.findOrder(2,matrix));
    }
}