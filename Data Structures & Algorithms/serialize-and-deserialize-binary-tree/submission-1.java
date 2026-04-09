/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    int ind = 0;
    List<String> res = new ArrayList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return String.join(",", res);
        
    }

    void dfs(TreeNode node){
        if(node == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfs(node.left);
        dfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ls = data.split(",");
        return dfsD(ls);
    }

    TreeNode dfsD(String[] ls){
        if(ls[ind].equals("N")){
            ind++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(ls[ind]));
        ind++;
        node.left = dfsD(ls);
        node.right = dfsD(ls);
        return node;
    }
}
