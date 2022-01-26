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
        
        int n = lists.length;
        if(n == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(n, (a,b) -> a.val - b.val);
        
        for(ListNode list : lists){
            if(list != null) pq.add(list);
        }
        
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if(node.next != null){
                node = node.next;
                pq.offer(node);
            }
        }
        return dummy.next;
        
    }
}