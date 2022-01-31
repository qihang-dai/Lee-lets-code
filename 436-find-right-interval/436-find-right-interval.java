class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap();
        int n = intervals.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            map.put(intervals[i][0], i);
        }
        for(int i = 0; i < n; i++){
            Map.Entry<Integer, Integer> pos = map.ceilingEntry(intervals[i][1]);
            res[i] = pos == null ? -1 : pos.getValue();
        }
        return res;
    }
    
        
}