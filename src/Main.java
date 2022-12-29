public class Main {




    //   101

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null) return true;
            return symmetric(root.left, root.right);
        }
        private boolean symmetric(TreeNode left, TreeNode right){
            if(left == null && right == null) return true;
            else if(left == null || right == null) return false;
            else{
                return left.val == right.val && symmetric(left.right, right.left) && symmetric(left.left, right.right);
            }
        }
    }





//  733
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oColor = image[sr][sc];
        if (oColor == newColor) {
            return image;
        }
        int[][] dir = new int[][]{{0, 1},{0, -1},{1, 0},{-1, 0}};
        image[sr][sc] = newColor;
        for (int i = 0; i < dir.length; i ++) {
            int nextX = sr + dir[i][0];
            int nextY = sc + dir[i][1];
            if (nextX < 0 || nextX >= image.length || nextY < 0 || nextY >= image[0].length) {
                continue;
            }
            if (image[nextX][nextY] != oColor) {
                continue;
            }
            floodFill(image, nextX, nextY, newColor);
        }
        return image;
    }






//  695
    private int n, m;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] > 0) ans = Math.max(ans, trav(i, j, grid));
        return ans;
    }
    private int trav(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] < 1) return 0;
        grid[i][j] = 0;
        return 1 + trav(i-1, j, grid) + trav(i, j-1, grid) + trav(i+1, j, grid) + trav(i, j+1, grid);
    }
}