class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return true;
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int res = 0;
        int i = 0, j = 0;
        while(i < n && j < n){//i肯定先到达n，至于最后j结束与否也无所谓了，就是求最多重叠次数。
            if(start[i] < end[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        // System.out.println(res);
        return res - 1 == 0;
        
    }
}