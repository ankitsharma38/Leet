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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        // oddCurrent traverses the odd list
        ListNode oddCurrent = oddHead;
        // evenCurrent traverses the even list
        ListNode evenCurrent = evenHead;

        // Iterate as long as there are at least two more nodes (one odd, one even)
        while (evenCurrent != null && evenCurrent.next != null) {
            oddCurrent.next = evenCurrent.next;
            oddCurrent = oddCurrent.next;
            evenCurrent.next = oddCurrent.next;
            evenCurrent = evenCurrent.next;
        }
        oddCurrent.next = evenHead;
        return oddHead;
    }
}