class MyHashMap {
    class Node{
        int key, value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node[] nodes;
    public MyHashMap() {
        nodes = new Node[10009];
        
    }
    
    int getIndex(int key){
        int hash = Integer.hashCode(key);
        hash ^= hash >>> 16;
        return hash % nodes.length;
    }
    
    public void put(int key, int value) {
        int idx = getIndex(key);
        Node loc = nodes[idx], tmp = loc;
        if(loc != null){
            Node prev = null;
            while(tmp != null){
                if(tmp.key == key){
                    tmp.value = value;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            //record last Node
            tmp = prev;
        }
        Node node = new Node(key, value);
        
        node.next = loc;
        nodes[idx] = node;
        
        // if(tmp != null){
        //     tmp.next = node;
        // }else{
        //     nodes[idx] = node;
        // }
        
        
    }
    
    public int get(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if(loc != null){
            while(loc != null){
                if(loc.key == key){
                    return loc.value;
                }
                loc = loc.next;
            }
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int idx = getIndex(key);
        Node loc = nodes[idx];
        if(loc != null){
            Node prev = null;
            while(loc != null){
                if(loc.key == key){
                    if(prev != null) prev.next = loc.next;
                    else nodes[idx] = loc.next;
                    return;
                }
                prev = loc;
                loc = loc.next;
            }

        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */