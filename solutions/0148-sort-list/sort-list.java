// Sort a linked list in O(n log n) time using constant space complexity.
//
// Example 1:
//
//
// Input: 4->2->1->3
// Output: 1->2->3->4
//
//
// Example 2:
//
//
// Input: -1->5->3->4->0
// Output: -1->0->3->4->5
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head, fast=head, prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        prev.next=null;
        
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        
        return merge(l1,l2);
    }   
    
    public ListNode merge(ListNode a,ListNode b){
        ListNode pre=new ListNode(0);
        ListNode p=pre;
        while(a!=null && b!=null){
            if(a.val>b.val){
                p.next=b;
                b=b.next;
            }else{
                p.next=a;
                a=a.next;
            }
            p=p.next;
        }
        if(a==null){
            p.next=b;
        }
        if(b==null){
            p.next=a;
        }
        return pre.next;
        
    }
}
