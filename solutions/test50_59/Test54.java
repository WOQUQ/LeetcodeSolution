package test50_59;

import java.util.ArrayList;
import java.util.List;

public class Test54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList<Integer>();
        int totalCount = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<Integer>(totalCount);
        int leftMax = 0;
        int rightMax = matrix[0].length - 1;
        int upMax = 0;
        int downMax = matrix.length - 1;

        int i = 0;
        int j = 0;
        res.add(matrix[0][0]);
        while(res.size() != totalCount){
            while(j < rightMax)
                res.add(matrix[i][++j]);

            upMax++;

            while(i < downMax)
                res.add(matrix[++i][j]);

            rightMax--;
            if(rightMax >= leftMax && downMax >= upMax){
                while(j > leftMax)
                    res.add(matrix[i][--j]);

                downMax--;

                if(downMax < upMax)
                    break;

                while(i > upMax)
                    res.add(matrix[--i][j]);

                leftMax++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Test54 test = new Test54();
        int[][] nums = {
            { 1, 2, 3 ,4},
            { 5, 6, 7, 8},
            { 9, 10, 11, 12 }
        };
        System.out.println(test.spiralOrder(nums));
    }
}