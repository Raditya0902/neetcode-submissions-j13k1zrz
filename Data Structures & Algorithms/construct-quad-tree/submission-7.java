/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0,0, grid.length);
    }

    Node build(int[][] grid, int r, int c, int size){
        if(isSame(grid, r, c, size)) return new Node(grid[r][c] == 1, true);
        Node root = new Node(false, false);
        int half = size / 2;
        root.topLeft = build(grid, r, c, half);
        root.topRight = build(grid, r, c + half, half);
        root.bottomLeft = build(grid, r + half, c, half);
        root.bottomRight = build(grid, r + half, c + half, half);
        return root;
    }

    boolean isSame(int[][] grid, int r, int c, int size){
        int val = grid[r][c];
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(val != grid[i][j]) return false;
            }
        }
        return true;
    }
}