/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
         Node currentLevel = root;

        while (currentLevel != null) {
            Node nextLevelHead = null;
            Node nextLevelTail = null;

            // Traverse the current level using existing next pointers.
            Node current = currentLevel;

            while (current != null) {
                // Add left child to the next level.
                if (current.left != null) {
                    if (nextLevelHead == null) {
                        nextLevelHead = current.left;
                    } else {
                        nextLevelTail.next = current.left;
                    }

                    nextLevelTail = current.left;
                }

                // Add right child to the next level.
                if (current.right != null) {
                    if (nextLevelHead == null) {
                        nextLevelHead = current.right;
                    } else {
                        nextLevelTail.next = current.right;
                    }

                    nextLevelTail = current.right;
                }

                current = current.next;
            }

            // Move down to the next level.
            currentLevel = nextLevelHead;
        }

        return root;
    }
}