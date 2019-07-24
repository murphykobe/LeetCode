/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<Node,Node>();
        Node n=head;
        while(n!=null){
            map.put(n,new Node(n.val));
            n=n.next;
        }
        
        n=head;
        while(n!=null){
            map.get(n).next=map.get(n.next);
            map.get(n).random=map.get(n.random);
            n=n.next;
        }
        return map.get(head);
    }
}