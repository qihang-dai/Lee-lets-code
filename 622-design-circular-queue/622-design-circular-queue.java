class MyCircularQueue {
    
    int front, rear, count, cap;
    int[] q;
    public MyCircularQueue(int k) {
        front = rear = 0;
        cap = k + 1;
        q = new int[cap];
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        q[rear] = value;
        rear = (rear + 1) % cap;
        count++;
        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = (front + 1) % cap;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return q[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return q[(rear - 1 + cap) % cap];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % cap == front;
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