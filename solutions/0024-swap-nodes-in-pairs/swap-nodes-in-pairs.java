/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        while(pre.next!=null && pre.next.next!=null){
            
            ListNode tail=pre.next.next;
            ListNode cur=pre.next;
            cur.next=tail.next;
            pre.next=tail;
            pre.next.next=cur;
            pre=pre.next.next;
        }
        return dummy.next;
    }

}