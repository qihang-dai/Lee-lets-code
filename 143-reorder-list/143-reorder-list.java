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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode pre = null, nxt, cur = mid;
        while(cur != null){
            //记录后节点，反转指向
            nxt = cur.next;
            cur.next = pre;
            
            //移动两个指针
            pre = cur;
            cur = nxt;
        }
        ListNode l1 = head, l2 = pre, tmp;
        //为什么是Pre?你就这样想：每次两个指针移动，最后cur指向末节点的下一个NULL
        //难点在共用尾部节点->如果是奇数数个，l1和l2节点数相同，如果是奇数个，l2比l1多一个节点
        //因为和直接分节点不同，这是共用尾部节点，所以l1的节点数会更多,l2会先变成null
        // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
        //res: [1,6,2,5,3,4],since they got 4 in common, just ensure at last no null.next
        // convert 1->2->3->4->5->6->7 into 1->2->3->4 and 7->6->5->4
        while(l2.next != null){
            tmp = l1.next;
            l1.next = l2;
            l1 = tmp;
            
            tmp = l2.next;
            l2.next = l1;
            l2 = tmp;
        }
        //每次循环内进行两次操作：l1 -> l2, l2 -> l1, l1 = l1.next; l2 = l2.next;
        //所以会循环到l1.next 和 l2.next都为空指针的情况，会出现求Null的next的exception
        
    }
}