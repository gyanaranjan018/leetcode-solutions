class LRUCache {
    //create DLL Node
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    //create head and tail node to keep tarck of start and end
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int cap;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {          
          this.cap = capacity;
          cache = new HashMap<Integer, Node>();
          head.next = tail;
          tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node res = cache.get(key);
        deleteNode(res);
        addNode(res);
        return res.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            deleteNode(cache.get(key));
        }
        if(cache.size() == cap){
            //delete the tail.prev as that is not used in a while
            deleteNode(tail.prev);                    
        }
        addNode(new Node(key, value));
    }

    //Adds node after the head node
    public void addNode(Node newNode){
        cache.put(newNode.key, newNode);
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    //deletes the node.
    public void deleteNode(Node delNode){
        cache.remove(delNode.key);
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */