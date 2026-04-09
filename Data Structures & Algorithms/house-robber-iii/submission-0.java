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
class Solution {
    Map<TreeNode, Integer> map;
    public int rob(TreeNode root) {
        map = new HashMap<>();
        map.put(null, 0);
        return dfs(root);
    }

    int dfs(TreeNode node){
        if(map.containsKey(node)) return map.get(node);
        int res = node.val;
        if(node.left != null){
            res += dfs(node.left.left) + dfs(node.left.right);
        }
        if(node.right != null){
            res += dfs(node.right.left) + dfs(node.right.right);
        }

        res = Math.max(res, dfs(node.left) + dfs(node.right));
        map.put(node,res);
        return res;
    }
}