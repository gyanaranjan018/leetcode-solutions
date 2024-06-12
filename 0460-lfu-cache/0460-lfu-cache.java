class LFUCache {
    final int capacity;
    int currSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoublyLinkedList> frequencyMap;

    /*.*/
    /*
    * @param capacity: total capacity of LFU Cache
    * @param curSize: current size of LFU cache
    * @param minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
    * @param cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
    * @param frequencyMap: a hash map that has key to linked list mapping, which used for storing all
    * double linked list by their frequencies
    * */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if(currNode == null){
            return -1;
        }
        updateNode(currNode);
        return currNode.val;
    }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value) {
        //corner case :  check cache capacity initialization
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            DLLNode currNode = cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        }
        else{
            currSize++;
            if(currSize > capacity){
                //Get minimum frequency list
                DoublyLinkedList minFrequencyList = frequencyMap.get(minFrequency);
                cache.remove(minFrequencyList.tail.prev.key);
                minFrequencyList.removeNode(minFrequencyList.tail.prev);
                currSize--;
            }
            //Reset minimum frequency to 1 because of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoublyLinkedList currList = frequencyMap.getOrDefault(1, new DoublyLinkedList());
            currList.addNode(newNode);
            frequencyMap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode currNode){
        int currFrequency = currNode.frequency;
        DoublyLinkedList currList = frequencyMap.get(currFrequency);
        currList.removeNode(currNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if(currFrequency == minFrequency && currList.listSize == 0){
            minFrequency++;
        }

        currNode.frequency++;

        // add current node to another list has current frequency + 1,
        // if we do not have the list with this frequency, initialize it
        DoublyLinkedList newList = frequencyMap.getOrDefault(currNode.frequency, new DoublyLinkedList());
        newList.addNode(currNode);
        frequencyMap.put(currNode.frequency, newList);
    }

    /*
    * @param key: node key
    * @param val: node value
    * @param frequency: frequency count of current node
    * (all nodes connected in same double linked list has same frequency)
    * @param prev: previous pointer of current node
    * @param next: next pointer of current node
    * */
    class DLLNode{
        int key;
        int val;
        int frequency;
        DLLNode next;
        DLLNode prev;

        public DLLNode(int key, int value){
            this.key = key;
            this.val = value;
            this.frequency = 1;
        }
    }

    /*
    * @param listSize: current size of double linked list
    * @param head: head node of double linked list
    * @param tail: tail node of double linked list
    * */
    class DoublyLinkedList{
        int listSize;
        DLLNode head;
        DLLNode tail;

        public DoublyLinkedList(){
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        /** add new node into head of list and increase list size by 1 **/
        public void addNode(DLLNode currNode){
            DLLNode nextNode = head.next;
            head.next = currNode;
            currNode.prev = head;
            currNode.next = nextNode;
            nextNode.prev = currNode;
            listSize++;
        }

        /** remove input node and decrease list size by 1**/
        public void removeNode(DLLNode currNode){
            DLLNode prevNode = currNode.prev;
            DLLNode nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */