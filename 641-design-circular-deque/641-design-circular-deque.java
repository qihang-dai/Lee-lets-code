class MyCircularDeque {
    
    int cap;
    int front;
    int rear;
    int[] queue;
    public MyCircularDeque(int k) {
        cap = k + 1;
        queue = new int[cap];
        front = rear = 0;
        
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        front = (front - 1 + cap) % cap;
        queue[front] = value;
        
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        queue[rear] = value;
        rear = (rear + 1) % cap;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = (front + 1 + cap) % cap;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = (rear - 1 + cap) % cap;
        return true;

        
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return queue[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return queue[(rear - 1 + cap) % cap];
        
    }
    
    public boolean isEmpty() {
        return front == rear;
        
    }
    
    public boolean isFull() {
        return (rear + 1) % cap == front;
        
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */