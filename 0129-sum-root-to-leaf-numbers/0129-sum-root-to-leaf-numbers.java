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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentNumber) {
        if (node == null) {
            return 0;
        }

        // Append the current digit to the number formed so far.
        currentNumber = currentNumber * 10 + node.val;

        // A leaf represents one complete root-to-leaf number.
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        return dfs(node.left, currentNumber)
             + dfs(node.right, currentNumber);
    }
}