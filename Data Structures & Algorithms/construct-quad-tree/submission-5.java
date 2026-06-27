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
        return build(0,0,grid.length,grid);
    }

    Node build(int r, int c, int size, int[][] grid){
        if(sameBox(r,c,size,grid)) return new Node(grid[r][c] == 1, true);
        int half = size/2;
        Node topLeft = build(r, c, half, grid);
        Node topRight = build(r, c + half, half, grid);
        Node bottomLeft = build(r + half, c, half, grid);
        Node bottomRight = build(r + half, c + half, half, grid);
        if(topLeft.isLeaf && 
            topRight.isLeaf && 
            bottomLeft.isLeaf && 
            bottomRight.isLeaf && 
            topLeft.val == topRight.val && 
            topLeft.val == bottomLeft.val && 
            topLeft.val == bottomRight.val) 
        return topLeft;
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    boolean sameBox(int r, int c, int size, int[][] grid){
        int val = grid[r][c];
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(grid[i][j] != val) return false;
            }
        }
        return true;
    }
}