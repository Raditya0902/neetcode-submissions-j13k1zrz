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
    Map<Integer, Integer> map;
    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        preIndex = 0;
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int [] inorder, int start, int end){
        if(start > end) return null;
        if(preIndex >= preorder.length) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = map.get(rootVal);
        root.left = build(preorder, inorder, start, inIndex - 1);
        root.right = build(preorder, inorder, inIndex +1, end);
        return root;
    }
}
