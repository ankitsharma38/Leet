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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // Using two pointer slow & fast
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;  // to keep tracking of node before slow

        // Move fast by 2 and slow by 1 step until fast reaches end
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Now 'slow' points to the middle node
        // 'prev' points to the node before middle
        prev.next = slow.next; // Deleting middle node

        return head; // Returning updt list
    }
}
