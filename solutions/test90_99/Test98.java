package test90_99;


/**给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
*/
/**
 * 可以检测中序遍历是否按序排列来判断是否是BST
 * */
public class Test98 {
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}
       return checkBST(root,null,null);
		
    }
	private static boolean checkBST(TreeNode root,Integer bigger,Integer smaller) {
		//判断当前节点是否满足条件
			if(bigger != null && root.val >= bigger) {
				return false;
			}
			if(smaller != null && root.val <= smaller) {
				return false;
			}
		//对左节点进行递归
		if(root.left != null) {
			if(!checkBST(root.left,root.val,smaller)) {
				return false;
			}
		}
		
		//对右节点进行递归
		if(root.right != null) {
			if(!checkBST(root.right,bigger,root.val)) {
				return false;
			}
		}
		
		return true;
	}
}
