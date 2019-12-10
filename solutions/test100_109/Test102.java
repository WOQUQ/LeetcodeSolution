package test100_109;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值（即遂层的，从左到右访问所有节点）
 * @author WOQUQ
 *
 */
public class Test102 {

	public List<List<Integer>> levelOrder(TreeNode root){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//如果参数为null，直接返回，res默认null
		if(root == null) {
			return res;
		}
		//使用队列进行层次遍历
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		//将root放入队列中作为起点，开始遍历
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			List<Integer> list = new ArrayList<Integer>(size);
			for(int i = 0; i < size;i++) {
				//取出队列中的一个Node，将其数值记入新建的list中
				TreeNode node = queue.poll();
				list.add(node.val);
				
				//将左节点加入队列中，等待下一次循环
				if(node.left != null) {
					queue.add(node.left);
				}
				
				//将右节点加入队列中，等待下一次循环
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			res.add(list);	
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		
	}
}
