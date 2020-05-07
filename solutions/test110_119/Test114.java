package test110_119;

import java.util.Stack;

class Solution {
    //解法一 ： 镜像左子树，转移右子树
    public void flatten_1(TreeNode root) {
        while(root != null){
            if(root.left != null){
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;

                //找到连接点（最右端）
                TreeNode next = root.right;
                while(next.right != null){
                    next = next.right;
                }
                next.right = temp;
            }
            root = root.right;
        }
    }

    //解法二：自底向上，后序遍历
    TreeNode _node;
    public void flatten_2(TreeNode root) {
        if(root != null){
            flatten_2(root.right);
            flatten_2(root.left);
            
            root.right = _node;
            root.left = null;
            _node = root;
        }
    }

    //解法三：自顶向下，先序遍历，用栈记录中间值
    public void flatten(TreeNode root) { 
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode pre = null;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop(); 

            if(pre!=null){
                pre.right = temp;
                pre.left = null;
            }

            if (temp.right != null){
                s.push(temp.right);
            }
            if (temp.left != null){
                s.push(temp.left);
            } 

            pre = temp;

        }
    }
}