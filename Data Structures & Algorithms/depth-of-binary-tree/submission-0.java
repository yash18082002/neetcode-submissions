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
    int depth = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return depth;
    }

    private void dfs(TreeNode root, int h) {
        if (root == null) return;

        depth = Math.max(depth, h);
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
    }
}
