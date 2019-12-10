package test100_109;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @author WOQUQ
 *基本思路：仿照102进行层次遍历，在奇数行时利用队列的头插入
 */
public class Test103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean reverseFlag = true;
        while(!queue.isEmpty()) {
        	reverseFlag = !reverseFlag;
	        int size = queue.size();
	        List<Integer> list = new ArrayList<Integer>();
	        for(int i = 0; i < size; i++) {
	        	TreeNode node = queue.poll();
	        	if(node.left != null) queue.add(node.left);
	        	if(node.right != null) queue.add(node.right);
	        	if(reverseFlag) list.add(0, node.val);
	        	else list.add(node.val);
	        }
	        res.add(list);
        }
        return res;
    }
}
