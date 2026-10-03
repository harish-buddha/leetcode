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

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        // No elements in this range.
        if (left > right) {
            return null;
        }

        // Choose the middle element as the root.
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        // Elements before mid form the left subtree.
        root.left = buildTree(nums, left, mid - 1);

        // Elements after mid form the right subtree.
        root.right = buildTree(nums, mid + 1, right);

        return root;
    }
}