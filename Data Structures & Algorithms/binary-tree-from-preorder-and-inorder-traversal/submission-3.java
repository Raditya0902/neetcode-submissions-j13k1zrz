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
    Map<Integer, Integer> map = new HashMap<>();
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] pre, int[] in, int l, int r){
        if(l > r) return null;
        if(preIdx == pre.length) return null;
        int rootVal = pre[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        root.left = build(pre, in, l, map.get(root.val) - 1);
        root.right = build(pre, in, map.get(root.val) + 1, r);
        return root;
    }
}
