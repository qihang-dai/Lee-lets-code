class MyCircularQueue {
    
    int k, front, rear, size;
    int[] q;
    public MyCircularQueue(int k) {
        q = new int[k];
        this.k = k;
        front = rear = size = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        q[rear] = value;
        rear = rear + 1 == k ? 0 : rear + 1;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = front + 1 == k ? 0 : front + 1;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        int end = rear - 1 < 0 ? k -1 : rear - 1;
        return q[end];
        
    }
    
    public boolean isEmpty() {
        return size == 0;
        
    }
    
    public boolean isFull() {
        return size == k;
        
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