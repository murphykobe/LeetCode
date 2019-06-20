// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//
// Example:
//
//
// Input:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// Output: 1->1->2->3->4->4->5->6
//
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
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        return mergeKLists(lists,0,lists.length-1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end){
            int mid = (end - start) / 2 + start;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        } else {
            return null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode l3=dummy;
        while(l1!=null || l2!=null) {
            if(l1!=null && l2!=null){
                if(l1.val>=l2.val){
                    l3.next=new ListNode(l2.val);
                    l3=l3.next;
                    l2=l2.next;
                }
                else{
                    l3.next=new ListNode(l1.val);
                    l3=l3.next;
                    l1=l1.next;
                }            
            }
            else if(l1!=null && l2==null){
                l3.next=new ListNode(l1.val);
                l3=l3.next;
                l1=l1.next;
            }
            else if(l1==null && l2!=null){
                l3.next=new ListNode(l2.val);
                l3=l3.next;
                l2=l2.next;
            }

            
        }
        return dummy.next;
    }
}
