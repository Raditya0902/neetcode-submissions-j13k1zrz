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
    List<String> strs = new ArrayList<>();
    int idx = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return String.join(",", strs);
    }

    void dfs(TreeNode node){
        if(node == null){
            strs.add("N");
            return;
        }
        strs.add(String.valueOf(node.val));
        dfs(node.left);
        dfs(node.right);
        //pre
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ls = data.split(",");
        return dfsD(ls);
    }

    TreeNode dfsD(String[] ls){
        if(ls[idx].equals("N")){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(ls[idx]));
        idx++;
        node.left = dfsD(ls);
        node.right = dfsD(ls);
        return node;
    }

}
