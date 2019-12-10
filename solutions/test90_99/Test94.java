package test90_99;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * @author WOQUQ
 *
 */
public class Test94 {
	public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrder(root,list);
        return list;
    }
	
	public void inOrder(TreeNode node,List<Integer> list) {
		
		if(node != null) {
			inOrder(node.left,list);
			list.add(node.val);
			inOrder(node.right,list);
		}
	}
}

/**
*方法二：基于栈的遍历
*本方法的策略与上衣方法很相似，区别是使用了栈。
*/

//public class Solution {
//    public List < Integer > inorderTraversal(TreeNode root) {
//        List < Integer > res = new ArrayList < > ();
//        Stack < TreeNode > stack = new Stack < > ();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            res.add(curr.val);
//            curr = curr.right;
//        }
//        return res;
//    }
//}
