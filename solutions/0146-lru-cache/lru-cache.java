class LRUCache {
    
    private Map<Integer,Node> map;
    private Node head=new Node(0,0);
    private Node tail=new Node(0,0);
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        int res=-1;
        if(map.containsKey(key)){
            Node n=map.get(key);
            res=n.value;
            remove(n);
            insertToHead(n);
        }
        return res;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            n.value=value;
            remove(n);
            insertToHead(n);
        }else{
            if(map.size()==capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node n=new Node(key,value);
            map.put(key,n);
            insertToHead(n);
        }
    }
    
    public void remove(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }
    
    public void insertToHead(Node n){
        Node headNext=head.next;
        n.next=headNext;
        headNext.prev=n;
        n.prev=head;
        head.next=n;
    }

    class Node{
        int key,value;
        Node prev,next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */