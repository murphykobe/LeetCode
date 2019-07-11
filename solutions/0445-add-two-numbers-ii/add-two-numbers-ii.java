/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;

        ListNode l3=new ListNode(0);
        ListNode cur=l3;
        l1=reverse(l1);
        l2=reverse(l2);
        
        while(l1!=null && l2!=null){
   
            sum+=l1.val;
            l1=l1.next;
            
            sum+=l2.val;
            l2=l2.next;

            cur.next=new ListNode(sum%10);
            sum=(sum-sum%10)/10;
            cur=cur.next;
        }
        if(sum==1){
            cur.next=new ListNode(1);
        }

        while(l1!=null){
            sum+=l1.val;
            cur.next=new ListNode(sum%10);
            sum=(sum-sum%10)/10;
            cur=cur.next;
            l1=l1.next;
        }
            
        while(l2!=null){
            sum+=l2.val;
            cur.next=new ListNode(sum%10);
            sum=(sum-sum%10)/10;
            cur=cur.next;
            l2=l2.next;
        }
        
        if(sum==1){
            cur.next=new ListNode(1);
        }
        
        return reverse(l3.next);
    }
    
    public ListNode reverse(ListNode node){
        ListNode pre=null;
        ListNode cur=node;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
    
}