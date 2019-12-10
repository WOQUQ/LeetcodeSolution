package test60_69;

//import java.math.BigDecimal;

public class Test62 {
	/** 排列组合 **/
//    public int uniquePaths(int m, int n) {
//        if(m == 0 || n == 0) return 0;
//        if(m == 1 || n == 1) return 1;
//        m--;
//        n--;
//        BigDecimal res = factoriall(m+n).divide(factoriall(m)).divide(factoriall(n));
//        return res.intValue();
//    }
//    private BigDecimal factoriall(int a) {
//    	BigDecimal res = new BigDecimal(1);
//    	BigDecimal temp;
//    	for(int i = 1 ; i <= a; i++) {
//    		temp = new BigDecimal(i);
//    		res = res.multiply(temp);
//    	}
//    	return res;
//    }
    
    /** 动态规划 **/
    public int uniquePaths(int m,int n) {
    	 if(m == 0 || n == 0) return 0;
    	 if(m == 1 || n == 1) return 1;
    	 
    	 int[][] paths = new int[m][n];
    	 for(int i = 0; i < m; i++) paths[i][0] = 1;
    	 for(int i = 0; i < n; i++) paths[0][i] = 1;
    	 
    	 for(int i = 1; i < m; i++) {
    		 for(int j = 1; j < n; j++) {
    			 paths[i][j] = paths[i][j-1] + paths[i-1][j];
    		 }
    	 }
    	 return paths[m-1][n-1];
    }
    /** 逐行储存，未更新的部分保留上一行的数据，使得空间复杂度大幅度下降 **/
//    class Solution {
//        public int uniquePaths(int m, int n) {
//            int[] cur = new int[n];
//            Arrays.fill(cur,1);
//            for (int i = 1; i < m;i++){
//                for (int j = 1; j < n; j++){
//                    cur[j] += cur[j-1] ;
//                }
//            }
//            return cur[n-1];
//        }
//    }

}
