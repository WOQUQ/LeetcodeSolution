package test50_59;

public class Test59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int right = n-1;
        int left = 0;
        int top = 0;
        int bottom = n-1;

        int num = 1;

        while(num <= n*n){
            for(int i = left; i <= right; i++) res[top][i] = num++; // left to right.
            top++;
            for(int i = top; i <= bottom; i++) res[i][right] = num++; // top to bottom.
            right--;
            for(int i = right; i >= left; i--) res[bottom][i] = num++; // right to left.
            bottom--;
            for(int i = bottom; i >= top; i--) res[i][left] = num++; // bottom to top.
            left++;
        }
        return res;
    }
}