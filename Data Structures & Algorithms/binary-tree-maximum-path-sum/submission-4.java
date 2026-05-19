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

    int dfs(TreeNode root){
        if(root == null) return 0;
        int lM = Math.max(dfs(root.left), 0);
        int rM = Math.max(dfs(root.right), 0);
        res = Math.max(res, Math.max(root.val + lM + rM, root.val + Math.max(lM, rM)));
        return root.val + Math.max(lM, rM);
    }
}
