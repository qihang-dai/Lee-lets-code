class MyCircularQueue {
    
    int size;
    int front;
    int rear;
    int[] queue;
    int k;
    
    public MyCircularQueue(int k) {
        this.k = k;
        size = 0;
        front = 0;
        rear = 0;
        queue = new int[k];
        
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        //TODO
        queue[rear] = value;
        rear = (rear + 1) % k;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        //TODO
        front = (front + 1) % k;
        size--;
        return true;
        
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        //TODO
        
        return queue[front];
        
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        //TODO
        System.out.printf("rear: %s \n", rear);
        return queue[(rear - 1 + k) % k];
        
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