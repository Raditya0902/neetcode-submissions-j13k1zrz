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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        while(node != null || !st.isEmpty()){
            while(node != null){
                st.push(node);
                node = node.left;
            }
            TreeNode curr = st.pop();
            if(--k == 0) return curr.val;
            node = curr.right;
        }
        return -1;
    }
}
