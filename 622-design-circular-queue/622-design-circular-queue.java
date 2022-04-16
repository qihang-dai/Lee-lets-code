class MyCircularQueue {
    
    int front, rear, count, cap;
    int[] q;
    public MyCircularQueue(int k) {
        front = rear = 0;
        cap = k;
        q = new int[cap + 1];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        q[rear] = value;
        if(rear == cap - 1) rear = 0;
        else rear++;
        count++;
        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(front == cap - 1) front = 0;
        else front++;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        int tmp = rear - 1;
        if(tmp < 0) tmp = cap - 1;
        return q[tmp];
    }
    
    public boolean isEmpty() {
        return 0 == count;
    }
    
    public boolean isFull() {
        return count == cap;
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