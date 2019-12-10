package test100_109;
/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * @author WOQUQ
 * 基本思路： 先检查root左右节点val值是否相等，再通过递归检查左右子树镜像
 *
 */
public class Test101 {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
        return checkNode(root.left,root.right);
    }
	private boolean checkNode(TreeNode left,TreeNode right) {
		//判断两节点是否相等
		if(left == null && right == null) return true;
		else if(left == null || right == null) return false;
		if(left.val != right.val) return false;
		
		//检查左右子树是否镜像相等
		if( !checkNode(left.left,right.right) || !checkNode(left.right,right.left)) return false;
		
		return true;
	}
}
