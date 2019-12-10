package test100_109;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class Test107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Stack stack = new Stack();
        //若参数为null，则直接返回
        if(root == null) {
        	return res;
        }
        
        //建立队列，将root存入队列中作为遍历起点
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	List<Integer> list = new ArrayList<Integer>(size);
        	
        	for(int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		list.add(node.val);
        		if(node.left != null) {
        			queue.add(node.left);
        		}
        		if(node.right != null) {
        			queue.add(node.right);
        		}
        		
        	}
        	//将list加入res的第一个位置，其余向后移动一位，实现倒序输出
        	res.add(0, list);
        	//stack.push(list);
        	
        }
//        while(!stack.isEmpty()) {
//        	res.add((List<Integer>) stack.pop());
//        }
        return res;
        
    }
}
