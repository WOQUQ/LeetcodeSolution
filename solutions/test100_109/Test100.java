package test100_109;
/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author WOQUQ
 *基本思路： 通过先序遍历对每一个节点进行逐一比较
 */
public class Test100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameNode(p,q);
    }
	
	private boolean isSameNode(TreeNode p,TreeNode q) {
		
		if( (p == null && q != null) || (p != null && q == null) ) {
			return false;
		}
		
		if(p != null && q!= null) {
			if(p.val != q.val || !isSameNode(p.left,q.left) || !isSameNode(p.right,q.right)) {
				return false;
			}
//			
//			if(!isSameNode(p.left,q.left) || !isSameNode(p.right,q.right)) {
//				return false;
//			}
		}
		return true;
	}
}
