package test370_379;

public class Test378 {
    // public int kthSmallest(int[][] matrix, int k) {
    //     int min = matrix[0][0];
    //     int max = matrix[matrix.length - 1][matrix.length - 1];

    //     int mid = min + (max - min)/2;
    //     while (true) {
    //         int i  = matrix.length - 1;
    //         int j = 0;
    //         int sum = 0;
    //         int res = min;
    //         while(i >= 0 && j < matrix.length){
    //             if(matrix[i][j] <= mid){
    //                 res = Math.max(res, matrix[i][j]);
    //                 if(++j == matrix.length){
    //                     sum += j + i*matrix.length;
    //                 }
    //                 continue;
    //             }
                
    //             if(matrix[i][j] > mid){
    //                 i--;
    //                 sum += j;
    //                 continue;
    //             }
    //         }
    //         if(sum == k) return res;
    //         if(mid == min) return max;
    //         if(mid == max) return min;
            
    //         if(sum > k){
    //             max = mid;
    //             mid = min + (mid - min)/2;
    //         }else if(sum < k){
    //             min = mid;
    //             mid = (int) (mid + Math.ceil((max - mid) / 2.0));
    //         }
            
    //     }

        
    // }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        Test378 test = new Test378();
        // int[][] matrix = { {2,3,6,6,10}, {5,9,12,17,19}, {10,14,17,20,20}, {15,17,20,24,24}, {20,20,25,26,29}};
        int[][] matrix1 = {{1,2},{1,3}};
        System.out.println(test.kthSmallest(matrix1, 1));
    }
}