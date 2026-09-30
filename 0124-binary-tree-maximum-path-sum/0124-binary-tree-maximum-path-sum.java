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
     private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Ignore negative contributions from either subtree.
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // Best path that uses this node as the highest/turning point.
        int currentPath = leftGain + node.val + rightGain;

        maxPathSum = Math.max(maxPathSum, currentPath);

        // A parent can use only one branch.
        return node.val + Math.max(leftGain, rightGain);
    }
}