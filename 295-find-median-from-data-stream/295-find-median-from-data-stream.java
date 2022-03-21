class MedianFinder {
    
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    public MedianFinder() {
        small = new PriorityQueue<Integer>((a,b) -> b - a);
        large = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if(small.size() >= large.size()){
            small.add(num);
            large.add(small.poll());
        }else{
            large.add(num);
            small.add(large.poll());
        }
        
        
    }
    
    public double findMedian() {
        if(small.size() > large.size()){
            return small.peek();
        }else if(small.size() < large.size()){
            return large.peek();
        }
        return (small.peek() + large.peek())/2.0;
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */