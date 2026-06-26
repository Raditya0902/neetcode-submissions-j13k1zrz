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
    int pI = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for(int i = 0; i < n; i++) map.put(inorder[i], i);
        return build(preorder, inorder, 0, n - 1);
    }

    TreeNode build(int[] pre, int[] in, int l, int r){
        if(l > r) return null;
        if(pI == pre.length) return null;
        TreeNode root = new TreeNode(pre[pI++]);
        root.left = build(pre, in, l, map.get(root.val) - 1);
        root.right = build(pre, in, map.get(root.val) + 1, r);
        return root;
    }
}
