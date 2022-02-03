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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        ListNode cur = head, prev = null;
        
        while(left > 1){
            prev = cur; //1
            cur = cur.next;
            left--;
            right--;
        }
        
        ListNode before = prev, tail = cur, tmp;
        while(right > 0){
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
            right--;
        }
        
        if(before != null) before.next = prev;
        else head = prev;
        tail.next = cur;
        return head;
        
        
        
        
        
    }
}