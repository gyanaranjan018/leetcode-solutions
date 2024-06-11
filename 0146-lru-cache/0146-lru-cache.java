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
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
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
        int resdata = res.val;
        deleteNode(res);
        addNode(res);
        //head.next because taht is the address where we inserted res
        cache.put(key, head.next);
        return resdata;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node existingNode = cache.get(key);
            cache.remove(key);
            deleteNode(existingNode);
        }
        if(cache.size() == cap){
            //delete the tail.prev as that is not used in a while
            cache.remove(tail.prev.key);
            deleteNode(tail.prev);                    
        }
        addNode(new Node(key, value));
        cache.put(key, head.next);
    }

    //Adds node after the head node
    public void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    //deletes the node.
    public void deleteNode(Node delNode){
        Node back = delNode.prev;
        Node front = delNode.next;
        back.next = front;
        front.prev = back;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */