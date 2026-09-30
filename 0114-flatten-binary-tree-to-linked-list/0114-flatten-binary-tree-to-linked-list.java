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
    public void flatten(TreeNode root) {
       TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node in the left subtree.
                TreeNode predecessor = current.left;

                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // Connect the original right subtree after the predecessor.
                predecessor.right = current.right;

                // Move the left subtree to the right.
                current.right = current.left;
                current.left = null;
            }

            // Move to the next node in the flattened structure.
            current = current.right;
        } 
    }
}