package test230_239;

public class Test236 {
    TreeNode p;
    TreeNode q;
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        helper(root);
        return result;
    }

    private boolean helper(TreeNode root){
        if(root != null){
            boolean left = helper(root.left);
            boolean right = helper(root.right);

            if(left && right){
                this.result = root;
                return false;
            }

            if(left || right ){
                if(root == p || root  == q){
                    this.result = root;
                    return false;
                }

                return true;
            }

            if(root == p || root  == q){
                return true;
            }
        }

        return false;
    }
}