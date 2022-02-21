class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> res= new ArrayList();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[0] > end){
                res.add(new int[]{start, end});
                start = cur[0];
                end = cur[1];
            }else{
                end = Math.max(end, cur[1]);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][0]);
        
    }
}