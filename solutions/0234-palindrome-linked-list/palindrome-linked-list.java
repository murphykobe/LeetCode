/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        if(f!=null){
            s=s.next;
        }
        s=reverse(s);
        f=head;
        while(s!=null){
            if(f.val!=s.val){
                return false;
            }
            f=f.next;
            s=s.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        while(head!=null){
            ListNode cur=head.next;
            head.next=pre;
            pre=head;
            head=cur;
        }
        return pre;
    }
}