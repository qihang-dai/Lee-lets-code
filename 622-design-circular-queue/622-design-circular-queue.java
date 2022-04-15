class Node{
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

class MyCircularQueue {
    
    int cap;
    Node front, rear;
    int size;
    public MyCircularQueue(int k) {
        cap = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        Node nextNode = new Node(value);
        if(isEmpty()){
            front = nextNode;
            rear = nextNode;
        }else{
            rear.next = nextNode;
            rear = rear.next;
        }
        size++;

        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front = front.next;
        size--;
        return true;
        
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return front.val;
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return rear.val;
        
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