package test100_109;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。
 * @author WOQUQ
 *基本思路： 通过层次遍历确定层数
 */
public class Test104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()) {
        	res++;
        	int size = queue.size();
        	for(int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		if(node.left != null) queue.add(node.left);
        		if(node.right != null) queue.add(node.right);
        	}
        }
        return res;
    }
}
//DFS
//class Solution {
//	  public int maxDepth(TreeNode root) {
//	    if (root == null) {
//	      return 0;
//	    } else {
//	      int left_height = maxDepth(root.left);
//	      int right_height = maxDepth(root.right);
//	      return java.lang.Math.max(left_height, right_height) + 1;
//	    }
//	  }
//	}
