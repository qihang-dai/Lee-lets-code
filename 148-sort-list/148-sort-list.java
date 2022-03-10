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
        if(head == null || head.next == null) return head;
        
        ListNode prev = findMid(head);
        ListNode mid = prev.next;
        prev.next = null;
        ListNode a = sortList(head);
        ListNode b = sortList(mid);
        return merge(a, b);
        
        
        
    }
    
    
    public ListNode findMid(ListNode head){
        ListNode fast = head, slow = head, prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        return prev;
    }
    
    public ListNode merge(ListNode p1, ListNode p2){
        ListNode dummy = new ListNode(-1), p = dummy;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        
        p.next = p1 == null? p2 : p1; 
        return dummy.next;
    }
    
    
}