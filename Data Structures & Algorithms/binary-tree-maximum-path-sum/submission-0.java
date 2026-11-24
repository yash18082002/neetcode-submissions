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
    int best = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        gain(root);
        return best;
    }

    private int gain(TreeNode root) {
        if (root == null) return 0;

        int leftGain = Math.max(0, gain(root.left));
        int rightGain = Math.max(0, gain(root.right));

        best = Math.max(best, leftGain + rightGain + root.val);

        return root.val + Math.max(leftGain, rightGain);
    }
}
