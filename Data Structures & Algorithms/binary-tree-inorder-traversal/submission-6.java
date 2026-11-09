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
    List<Integer> ls;
    public List<Integer> inorderTraversal(TreeNode root) {
        ls = new ArrayList<>();
        helper(root);
        return ls;
    }

    void helper(TreeNode node){
        if(node == null) return;
        helper(node.left);
        ls.add(node.val);
        helper(node.right);
    }
}