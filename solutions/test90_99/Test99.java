package test90_99;
/**
 * 二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树
 * @author WOQUQ
 * 
 * 基本思路： 通过中序遍历找到两个被交换的节点，然后将它们换回来
 *
 */
public class Test99 {
	TreeNode pre = null;
	TreeNode node1 = null;
	TreeNode node2 = null;
	
	public void recoverTree(TreeNode root) {
        //中序遍历找到相互交换位置的两节点
		inOrder(root);
		
		//将这两个节点的val值换回来
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
    }
	
	private void inOrder(TreeNode node) {
		if(node != null) {
			inOrder(node.left);
			
			//判断当前value值，将其与上一个值做对比，如发现不是增序，将上个节点记为node1,将此节点记为node2
			if(pre != null && node1 == null && node.val <= pre.val) {
				node1 = pre;
				node2 = node;
			}
			//将满足非增序条件的第二个节点记为node2
			else if(pre != null && node.val <= pre.val) {
				node2 = node;
			}
			
			//更新pre
			pre = node;
			
			inOrder(node.right);
		}
	}
}
