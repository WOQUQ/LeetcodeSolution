package test220_229;

public class Test221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;

        int result = 0;
        int length = matrix[0].length;
        int[] preDp = new int[length];

        for(int i = 0; i < length; i++){
            preDp[i] = matrix[0][i] == '1' ? 1 : 0;
            if(preDp[i] == 1)
                result = 1;
        }
        
        for(int i = 1; i < matrix.length; i++){
            int[] currDp = new int[length];
            currDp[0] = matrix[i][0] == '1' ? 1 : 0;
            if(currDp[0] == 1 && result == 0)
                result = 1;

            for(int j = 1; j < length; j++){
                if(matrix[i][j] == '1'){
                    currDp[j] = Math.min(preDp[j], Math.min(preDp[j-1], currDp[j-1])) + 1;
                    if(currDp[j] > result)
                        result = currDp[j];
                }
            }

            preDp = currDp;

        }

        return result*result;
    } 

    public static void main(String[] args) {
        Test221 test = new Test221();
        char[][] input = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(test.maximalSquare(input));
    }
}