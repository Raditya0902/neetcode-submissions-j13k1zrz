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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int[] inorder, int l, int r){
        if(l > r) return null;
        if(preIndex == preorder.length) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = build(preorder, inorder, l, map.get(root.val) - 1);
        root.right = build(preorder, inorder, map.get(root.val) + 1, r);
        return root;
    }
}
