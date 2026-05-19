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
    List<String> ls = new ArrayList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return String.join(",", ls);
    }

    void dfs(TreeNode node){
        if(node == null){
            ls.add("N");
            return;
        }
        ls.add(String.valueOf(node.val));
        dfs(node.left);
        dfs(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] res = data.split(",");
        return dfsD(res);
    }

    TreeNode dfsD(String[] res){
        if(res[ind].equals("N")){
            ind++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(res[ind]));
        ind++;
        node.left = dfsD(res);
        node.right = dfsD(res);
        return node;
    }
}
