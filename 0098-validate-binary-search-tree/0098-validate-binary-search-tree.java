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
   public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        // Current value must lie strictly inside the allowed range.
        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        // Left subtree: values must be smaller than node.val.
        boolean leftValid = validate(node.left, lower, node.val);

        // Right subtree: values must be greater than node.val.
        boolean rightValid = validate(node.right, node.val, upper);

        return leftValid && rightValid;
    }

}