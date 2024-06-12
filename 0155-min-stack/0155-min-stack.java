class MinStack {
    class Node {
        int val;
        int minVal;
        Node next;

        public Node(int val, int minVal, Node next) {
            this.val = val;
            this.minVal = minVal;
            this.next = next;
        }
    }

    Node head;
    
    public MinStack() {
        head = null;
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.minVal), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public int getMin() {
        if (head == null) {
            return -1;
        }
        return head.minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */