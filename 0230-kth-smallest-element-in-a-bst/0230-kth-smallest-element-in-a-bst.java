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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        int count = 0;

        while (current != null || !stack.isEmpty()) {

            // Go as far left as possible.
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the next smallest node.
            current = stack.pop();
            count++;

            if (count == k) {
                return current.val;
            }

            // Move to the right subtree.
            current = current.right;
        }

        return -1; // k is guaranteed to be valid.
    }
}