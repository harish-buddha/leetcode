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
    public boolean isSameTree(TreeNode p, TreeNode q) {
         // Both nodes are null, so this subtree matches.
        if (p == null && q == null) {
            return true;
        }

        // Exactly one node is null, so the structures differ.
        if (p == null || q == null) {
            return false;
        }

        // Values differ, so the trees cannot be identical.
        if (p.val != q.val) {
            return false;
        }

        // Both current nodes match; compare their subtrees.
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}