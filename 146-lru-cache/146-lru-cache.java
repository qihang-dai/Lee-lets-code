class LRUCache {
    /**
    We need as fast as possible. 
    1. So the first in first out， sequentially ordered with the addin order
    should be linkedList (easy to add and delete, easy to modify)
    Cause we may need to delete something in the middle, Double list is best.
    2. we need to reuse the data again, so fast search, hashMap
    3. 
    
    **/
    class Node{
        public int key, val; // the key can support val to key find
        public Node next, prev;
        public Node(int k, int v){
            key = k;
            val = v;
        }
    }
    
    class DoubleList{
        private Node head, tail;
        private int size;
        
        public DoubleList(){
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        public void addLast(Node x){
            // add x into the link list
            x.prev = tail.prev;
            x.next = tail;
            
            //change the the old link;
            tail.prev.next = x;
            tail.prev = x;
            
            size++;
            
        }
        
        public void remove(Node x){
            // let x be jumped 
            x.prev.next = x.next;
            //since its double list we need to modify the reverse order, the preve thing
            x.next.prev = x.prev;
            size--;
        }
        
        //would remove the least used task that at the start
        //need to return the data back cause we would need this for delete map
        public Node removeFirst(){
            if(head.next == tail) return null;
            Node first = head.next;
            remove(first);
            return first;
            
        }
        
        public int size(){
            return size;
        }
    }
    
    
    private Map<Integer, Node> map; //search tool
    private DoubleList cache;   //real queue
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;        
        map = new HashMap();
        cache = new DoubleList();
    }
    
    
    private void makeRecent(int key){
        Node x = map.get(key); //we would check that in the get function so no need to check here
        cache.remove(x); //remove the original node
        cache.addLast(x); // add this to the last
        
    }
    
    private void deleteKey(int key){
        Node x = map.get(key);
        map.remove(key);
        cache.remove(x);
    }
    
    private void addRecent(int key, int value){ // the most recent is at the last
        Node x = new Node(key, value);
        cache.addLast(x);
        map.put(key, x);    
    }
    
    private void removeLeastRecent(){
        Node x = cache.removeFirst();
        int key = x.key;
        map.remove(key);
    }
    
    
    
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        makeRecent(key);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        //check if i want to add the same , delete and add. no need to worry about the cap cause we are rewrite
        if(map.containsKey(key)){
            deleteKey(key);
            addRecent(key, value);
            return;
        }
        
        //add new, so check size
     // if the queue max size is reached, remove the last one
        if(cap == cache.size()){
            removeLeastRecent();
        }
        
        //add as normal
        addRecent(key, value);
        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */