class MovingAverage {
    int sum;
    double size;
    double curSize;
    LinkedList<Integer> q;
    public MovingAverage(int size) {
        this.sum = 0;
        this.curSize = 0;
        this.size = size;
        this.q = new LinkedList();
    }
    
    public double next(int val) {
        q.add(val);
        curSize++;
        sum += val;
        if(curSize <= size){
            // System.out.println(curSize + " " + sum);
            return sum / curSize;
        }else{
            int remove = q.removeFirst();
            sum -= remove;
            // System.out.println(remove + " " + sum);
            return sum/size;
        }
           
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */