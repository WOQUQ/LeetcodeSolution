package test290_299;

import java.util.LinkedList;
import java.util.Queue;

public class Test297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;

        StringBuffer res = new StringBuffer();
        dfs(root, res);

        return res.toString();
    }
    private void dfs(TreeNode node, StringBuffer res){
        if(node == null){
            res.append("null,");
        }else{
            res.append(node.val+",");
            dfs(node.left,res);
            dfs(node.right,res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null) return null;
        String[] arrStr = data.split(",");
        Queue<String> queue = new LinkedList<String>();
        for(String str : arrStr){
            queue.add(str);
        }
        TreeNode root = new TreeNode();
        root = anti_dfs(root, queue);

        return root;

    }

    private TreeNode anti_dfs(TreeNode node, Queue<String> queue){
        if( !queue.isEmpty() ){
            String currStr = queue.poll();

            if(currStr.equals("null")){
                node = null;
            }else{
                node = new TreeNode(Integer.parseInt(currStr));
                node.left = anti_dfs(node.left, queue);
                node.right = anti_dfs(node.right, queue);
            }

        }
        
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Test297 test = new Test297();
        System.out.println(test.deserialize(test.serialize(root)));
    }
}