class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] last = res.get(res.size() - 1);
            int[] cur = intervals[i];
            if(cur[0] <= last[1]){
                last[1] = Math.max(cur[1], last[1]);
            }else{
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][0]);
        
    }
}