class ExamRoom {
    TreeSet<Integer> set;
    int n;
    public ExamRoom(int N) {
        set = new TreeSet<Integer>();
        n = N;
    }

    public int seat() {        
        if(set.size() == 0){
            set.add(0);
            return 0;
        }                
        
        int gap = set.first(), sit = 0, pre = set.first();
        for(int cur: set){
            if(gap < (cur - pre) / 2){
                gap = (cur - pre) / 2;
                sit = (cur + pre) / 2;
            }
            pre = cur;
        }
        if(n - 1 - pre > gap)
            sit = n - 1;

        set.add(sit);
        return sit;
    }

    public void leave(int p) {
        set.remove(p);
    }
}