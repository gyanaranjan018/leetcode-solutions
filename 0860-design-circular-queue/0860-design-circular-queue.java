class MyCircularQueue {
    int[] queue;
    int rear, front, n, count;
    public MyCircularQueue(int k) {
        queue = new int[k];
        rear = -1;
        front = 0;
        n = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear++;
        queue[rear % n] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front++;
        count--;
        return true;
    }
    
    public int Front() {
        if(front > rear){
            return -1;
        }
        return queue[front % n];
    }
    
    public int Rear() {
        if(front > rear){
            return -1;
        }
        return queue[rear % n];
    }
    
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }
        else 
            return false;
    }
    
    public boolean isFull() {
        if(count == n){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */