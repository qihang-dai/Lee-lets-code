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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(3, (a,b) -> a.val - b.val);
        for(ListNode n : lists){
            if(n!= null) pq.add(n);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();
            p.next = cur;
            cur = cur.next;
            if(cur != null) pq.add(cur);
            p = p.next;
        }
        return dummy.next;
        
    }
}