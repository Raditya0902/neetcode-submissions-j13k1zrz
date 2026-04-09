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
    int res;
    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    int dfs(TreeNode node){
        if(node == null) return 0;
        int lM = Math.max(dfs(node.left), 0);
        int rM = Math.max(dfs(node.right), 0);
        res = Math.max(res, Math.max(node.val + Math.max(lM, rM), lM + rM + node.val));
        return node.val + Math.max(lM, rM);
    }
}
