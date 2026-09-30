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
    private int postIndex;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();

        // Store each value's position in inorder.
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return buildTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(
            int[] postorder,
            int inorderLeft,
            int inorderRight) {

        // No elements in this subtree.
        if (inorderLeft > inorderRight) {
            return null;
        }

        // Last unprocessed postorder value is the root.
        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        // Process right subtree first because postorder
        // is being traversed from right to left.
        root.right = buildTree(
                postorder,
                rootIndex + 1,
                inorderRight
        );

        root.left = buildTree(
                postorder,
                inorderLeft,
                rootIndex - 1
        );

        return root;
    }
}