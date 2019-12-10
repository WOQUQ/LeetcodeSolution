package test40_49;

import java.util.Collections;

public class Test48 {
    public void rotate(int[][] matrix) {
       int size = matrix.length;
       for(int i = 0; i < size; i++) {
    	   for(int j = i; j < size; j++) {
    		   int temp = matrix[i][j];
    		   matrix[i][j] = matrix[j][i];
    		   matrix[j][i] = temp;
    	   }
       }
       for(int i = 0; i < size; i++)
    	   matrix[i] = reverseArray(matrix[i]);
       
    }
    private int[] reverseArray(int[] arr) {
    	int size = arr.length;
    	if(size < 2) return arr;
    	
    	int left = 0;
    	int right = size-1;
    	while(left < right) {
    		int temp = arr[left];
    		arr[left] = arr[right];
    		arr[right] = temp;
    		left++;
    		right--;
    	}
    	return arr;
    }
    public static void main(String[] args) {
		Test48 test = new Test48();
		int[][] matrix = 
			{
				  {1,2,3},
				  {4,5,6},
				  {7,8,9}
			};
		test.rotate(matrix);
		for(int i = 0;i < matrix.length; i++)
			for(int j = 0; j < matrix.length; j++)
				System.out.println(matrix[i][j]);
	}

}
