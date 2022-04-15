class MyCircularQueue {
    
    int size;
    int front;
    int rear;
    int[] queue;
    
    public MyCircularQueue(int k) {
        size = k + 1;
        front = 0;
        rear = 0;
        queue = new int[size];
        
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        
        //TODO
        queue[rear] = value;
         rear = (rear + 1) % size;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        //TODO
        front = (front + 1) % size;
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
        return queue[(rear - 1 + size) % size];
        
    }
    
    public boolean isEmpty() {
        return front == rear;
        
    }
    
    public boolean isFull() {
        return (rear + 1) % size == front;
        
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