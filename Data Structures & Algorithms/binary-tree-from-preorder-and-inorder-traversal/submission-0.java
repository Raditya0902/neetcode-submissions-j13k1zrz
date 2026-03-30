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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, new int[]{0}, 0, inorder.length - 1, map);
    }

    TreeNode build(int[]preorder, int[] preIndex, int start, int end, HashMap<Integer,Integer> map){
        if(start > end) return null;
        int rootVal = preorder[preIndex[0]++];
        TreeNode node = new TreeNode(rootVal);
        int index = map.get(rootVal);
        node.left = build(preorder, preIndex, start, index - 1, map);
        node.right = build(preorder, preIndex, index+1, end, map);
        return node;
    }
}
