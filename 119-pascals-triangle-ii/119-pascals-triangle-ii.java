class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList(){{add(1);}};
        if(rowIndex == 0) return cur;
        List<Integer> previous = getRow(rowIndex - 1);
        for(int i = 0; i < previous.size() - 1; i++){
            cur.add(previous.get(i) + previous.get(i+1)); 
        }
        cur.add(1);
        return cur;
        
    }
}