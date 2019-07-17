/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left=new ListNode(0);
        ListNode l=left;
        ListNode right=new ListNode(0);
        ListNode r=right;
        while(head!=null){
            if(head.val<x){
                l.next=head;
                l=l.next;
            }else{
                r.next=head;
                r=r.next;
            }
            head=head.next;
        }
        r.next=null;
        l.next=right.next;
        
        return left.next;
    }
}