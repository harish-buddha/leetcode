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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Create a gap of n nodes
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move together
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}