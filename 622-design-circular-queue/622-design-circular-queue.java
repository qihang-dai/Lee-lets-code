class MyCircularQueue {
    
    int cap, count, rear, front;
    int[] queue;
    public MyCircularQueue(int k) {
        cap = k;
        queue = new int[k];
        count = rear = front = 0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        queue[rear] = value;
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
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return queue[(rear - 1 + cap) % cap];
        
    }
    
    public boolean isEmpty() {
        return count == 0;
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