class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int count = 1;
        int xend = intervals[0][1];
        for(int[] intvs : intervals){
            if(intvs[0] >= xend){
                count++;
                xend = intvs[1];
            }
        }
        return intervals.length - count;
        
    }
}