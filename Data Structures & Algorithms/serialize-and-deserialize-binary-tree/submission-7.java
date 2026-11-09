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
    int idx;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    void buildString(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("N").append(",");
            return;
        }
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    TreeNode buildTree(String[] nodes){
        if(nodes[idx].equals("N")){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx++]));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return buildTree(nodes);
    }
}
