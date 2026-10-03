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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the head of every non-empty list.
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            // Get the smallest current node.
            ListNode smallest = minHeap.poll();

            // Append it to the result.
            current.next = smallest;
            current = current.next;

            // The next node from the same list is now a candidate.
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
}