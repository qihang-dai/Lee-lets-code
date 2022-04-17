class MyCircularDeque {
    
    int cap, front, rear;
    int[] queue;
    int inc(int i){
        if(++i >= cap) i = 0;
        return i;
    }
    
    int dec(int i){
        if(--i < 0) i = cap - 1;
        return i;
    }
    

    public MyCircularDeque(int k) {
        cap = k + 1;
        queue = new int[cap];
        front = rear = 0;
        
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        front = dec(front);
        queue[front] = value;
        return true;
        
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        queue[rear] = value;
        rear = inc(rear);
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front = inc(front);
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear = dec(rear);
        return true;
        
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return queue[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return queue[dec(rear)];
    }
    
    public boolean isEmpty() {
        // print();
        return front == rear;
        
    }
    
    public boolean isFull() {
        // print();
        return inc(rear) == front;
    }
    
    public void print(){
        for(int n : queue){
            System.out.printf("%d\s", n);
        }
        System.out.println();
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