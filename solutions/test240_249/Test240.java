package test240_249;

public class Test240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix.length == 0 || matrix[0].length == 0) return false;

        int i = matrix.length - 1;
        int j = 0;

        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] > target)
                i--;
            else if(matrix[i][j] < target)
                j++;
            else
                return true;
        }

        return false;
    }
}