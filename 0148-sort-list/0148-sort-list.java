/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode sortList(ListNode head) {
        // Base case: empty list or single node.
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list.
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves.
        ListNode secondHalf = slow.next;
        slow.next = null;

        // Recursively sort both halves.
        ListNode left = sortList(head);
        ListNode right = sortList(secondHalf);

        // Merge the sorted halves.
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        // Attach remaining nodes.
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }
}