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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: empty subtree or one of the target nodes.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search both subtrees.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p and q were found in different subtrees.
        if (left != null && right != null) {
            return root;
        }

        // Return whichever subtree contains a target.
        return left != null ? left : right;
    }
}