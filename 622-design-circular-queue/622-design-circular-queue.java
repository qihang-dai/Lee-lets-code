class MyCircularQueue {
    int cap, front, rear;
    int[] queue;
    int size = 0;
    
    int inc(int i){
        if(++i >= cap) i = 0;
        return i;
    }
    
    int dec(int i){
        if(--i < 0) i = cap - 1;
        return i;
    }
    
    public MyCircularQueue(int k) {
        front = rear = 0;
        cap = k;
        queue = new int[cap];
        Arrays.fill(queue, -1);

    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        queue[rear] = value;
        rear = inc(rear);
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        queue[front] = -1;
        front = inc(front);
        size--;
        return true;
    }
    
    public int Front() {
        return queue[front];
        
    }
    
    public int Rear() {
        return queue[dec(rear)];
        
    }
    
    public boolean isEmpty() {
        return size == 0;
        
    }
    
    public boolean isFull() {
        return size == cap;
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