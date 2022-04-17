class MyCircularQueue {
    int cap, front, rear;
    int[] queue;
    
    int inc(int i){
        return (i + 1) % cap;
    }
    
    int dec(int i){
        return (i - 1 + cap) % cap;
    }
    
    public MyCircularQueue(int k) {
        front = rear = 0;
        cap = k + 1;
        queue = new int[cap];
        Arrays.fill(queue, -1);

    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        queue[rear] = value;
        rear = inc(rear);
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        queue[front] = -1;
        front = inc(front);
        return true;
    }
    
    public int Front() {
        return queue[front];
        
    }
    
    public int Rear() {
        return queue[dec(rear)];
        
    }
    
    public boolean isEmpty() {
        return front == rear;
        
    }
    
    public boolean isFull() {
        return inc(rear) == front;
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