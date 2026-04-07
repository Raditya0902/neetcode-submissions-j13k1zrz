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
    List<Integer> ls = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        helper(root);
        return ls;
    }  

    void helper(TreeNode node){
        if(node == null) return;
        ls.add(node.val); 
        helper(node.left);
        helper(node.right);
    }
}