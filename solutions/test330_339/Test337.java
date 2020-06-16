package test330_339;

public class Test337 {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    public int[] helper(TreeNode node){
        if(node == null) return new int[2];
        int[] res = new int[2];
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        res[1] = left[0] + right[0] + node.val;
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return res;
    }
}