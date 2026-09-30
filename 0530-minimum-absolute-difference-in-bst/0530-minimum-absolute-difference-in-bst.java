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
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Visit left subtree
        inorder(node.left);

        // Compare current node with previously visited node
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }

        prev = node.val;

        // Visit right subtree
        inorder(node.right);
    }
}