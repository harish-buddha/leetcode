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
     private int preorderIndex = 0;
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();

        // Store each value's position in inorder.
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildSubtree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(
            int[] preorder,
            int inorderLeft,
            int inorderRight) {

        // No nodes remain in this subtree.
        if (inorderLeft > inorderRight) {
            return null;
        }

        // The next preorder value is the root.
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find the root's position in inorder.
        int rootIndex = inorderMap.get(rootValue);

        // Everything to the left belongs to the left subtree.
        root.left = buildSubtree(
                preorder,
                inorderLeft,
                rootIndex - 1
        );

        // Everything to the right belongs to the right subtree.
        root.right = buildSubtree(
                preorder,
                rootIndex + 1,
                inorderRight
        );

        return root;
    }
}