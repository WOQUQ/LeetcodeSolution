package test100_109;

import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素
 * @author WOQUQ
 * 可以使用哈希表进一步提速
 */
public class Test105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null || inorder == null || preorder.length ==0 || inorder.length == 0 || preorder.length != inorder.length) {
    		return null;
    	}
    	
        TreeNode root = new TreeNode(preorder[0]);
        helper(root, preorder,inorder);
        return root;
    }
    private void helper(TreeNode root,int[] preorder, int[] inorder) {
        int headPosition = 0;
        for(; headPosition < inorder.length; headPosition++) {
        	if(inorder[headPosition] == root.val) break;
        }
        int[] leftInorder = new int[headPosition];
        int[] rightInorder = new int[inorder.length - headPosition - 1];
        int[] leftPreorder = new int[headPosition];
        int[] rightPreorder = new int[inorder.length - headPosition - 1];
        
        for(int i = 0; i < headPosition; i++) {
        	leftInorder[i] = inorder[i];
        	leftPreorder[i] = preorder[1 + i];
        }
        
        for(int i = headPosition+1; i < inorder.length; i++) {
        	rightInorder[i - headPosition - 1] = inorder[i];
        	rightPreorder[ i -headPosition - 1] = preorder[i];
        }
        
        if(leftPreorder.length > 0) {
        	TreeNode left = new TreeNode(leftPreorder[0]);
        	root.left = left;
        }
        if(rightPreorder.length > 0) {
        	TreeNode right = new TreeNode(rightPreorder[0]);
        	root.right = right;
        }
        
        if(leftPreorder.length > 1) {
        	helper(root.left,leftPreorder,leftInorder);
        }
        if(rightPreorder.length > 1) {
        	helper(root.right,rightPreorder,rightInorder);
        }
        
    }
    public static void main(String[] args) {
		Test105 test = new Test105();
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		test.buildTree(preorder, inorder);
	}
}
