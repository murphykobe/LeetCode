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
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int n=0;
        while(head!=null){
            head=head.next;
            n++;
        }
        for(int step=1;step<n;step<<=1){
            ListNode cur=dummy.next;
            ListNode prev=dummy;
            while(cur!=null){
                ListNode left=cur;
                ListNode right=split(cur,step);
                cur=split(right,step);
                prev=merge(left,right,prev);
            }
        }
        
        return dummy.next;
    }
    
    public ListNode split(ListNode head, int step){
        if(head==null) return null;
        for(int i=1;head.next!=null && i<step;i++){
            head=head.next;
        }
        ListNode right=head.next;
        head.next=null;
        return right;
    }
    
    public ListNode merge(ListNode left,ListNode right,ListNode prev){
        ListNode cur=prev;
        while(left!=null && right!=null){
            if(left.val>right.val){
                cur.next=right;
                right=right.next;
            }else{
                cur.next=left;
                left=left.next;
            }
            cur=cur.next;
        }
        if(left!=null) cur.next=left;
        else if(right!=null) cur.next=right;
        while(cur.next!=null) cur=cur.next;
        return cur;
    }
}