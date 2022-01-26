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
    public ListNode reverseList(ListNode head) {
        //head .next is enough. head == null is simply for empty list
        if(head == null || head.next == null) return head;
        //in this recursion, push to the last Node, and do reverse from the end.
        // to
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
        
    }
}