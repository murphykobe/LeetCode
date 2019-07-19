 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int l=0;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy,fast=dummy;
        
        while(fast.next!=null){
            fast=fast.next;
            l++;
        }
        
        for(int i=l-k%l;i>0;i--){
            slow=slow.next;
        }
        
        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;
        
        return dummy.next;
        
    }
}

