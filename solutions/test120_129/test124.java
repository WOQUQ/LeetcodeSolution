package test120_129;

public class test124 {

    int _max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return _max;
    }

    private int findMax(TreeNode root){
        if(root == null)  return 0;

        int leftMax = Math.max(0, findMax(root.left));
        int rightMax = Math.max(0, findMax(root.right));
            
        _max = Math.max((leftMax + rightMax + root.val), _max);

        int rootMax = Math.max(leftMax, rightMax) + root.val;
        return rootMax;
        
    }
}

