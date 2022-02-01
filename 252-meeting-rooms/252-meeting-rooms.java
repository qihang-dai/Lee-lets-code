class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return true;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int xend = intervals[0][1];
        int count = 1;
        for(int[] intv : intervals){
            if(intv[0] >= xend){
                count++;
                xend = intv[1];
            }
        }
        return count == intervals.length;
        
        
    }
}