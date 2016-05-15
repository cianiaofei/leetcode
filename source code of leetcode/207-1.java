package leetc;
/**
 * ʵ�����ж����ͼ�Ƿ��л�
 * ��������  ���Ϊ0
 * ʱ�临�Ӷ�̫����  time limit
 * 207Ӧ�ò���
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0||prerequisites==null||prerequisites.length==0){
        	return true;
        }
        else{
        	boolean[][] matrix = new boolean[numCourses][numCourses];
        	for(int row = 0; row < prerequisites.length;row++){//////////
        			int tempRow = prerequisites[row][0];
        			int tempCol = prerequisites[row][1];
        			matrix[tempRow][tempCol] = true;
        	}///////////
        	int[] courses = new int[numCourses];
        	for(int i = 0; i < courses.length;i++){
        		courses[i] = 1;
        	}
        	while(numCourses!=0){
        		int target = -1;
        		for(int col = 0;col < numCourses;col++){///
        			if(courses[col]==0){
        			}
        			else{//
        				boolean isIn = false;
        				for(int row = 0;row < numCourses;row++){///////////////////
        					if(matrix[row][col]==true){
        						isIn = true;
        						break;
        					}
            			}///////////////////////
        				if(isIn==false){
        					target = col;
        					break;
        				}
        			}//
        		}///
        		if(target==-1){
        			return false;
        		}
        		courses[target] = 0;
        		for(int i = 0; i < numCourses;i++){
        			matrix[target][i] = false;
        		}
        		numCourses--;
        	}//while
        	if(numCourses==0){
        		return true;
        	}
        	else{
        		return false;
        	}
        }
    }
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[][] matrix = {{1,0},{0,1}};
    	System.out.println(s.canFinish(2,matrix));
    }
}