package test220_229;

import java.util.LinkedList;
import java.util.Queue;

public class Test226 {

    // 方法一 - 递归
    public TreeNode invertTree1(TreeNode root) {
        if(root  == null) return null;
        root.left = invertTree1(root.left);
        root.right = invertTree1(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    // 方法二 - 迭代
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int currLength = queue.size();
            for(int i = 0; i < currLength; i++){
                TreeNode currNode = queue.poll();

                TreeNode temp = currNode.left;
                currNode.left = currNode.right;
                currNode.right = temp;

                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
        }
        return root;

    }
}