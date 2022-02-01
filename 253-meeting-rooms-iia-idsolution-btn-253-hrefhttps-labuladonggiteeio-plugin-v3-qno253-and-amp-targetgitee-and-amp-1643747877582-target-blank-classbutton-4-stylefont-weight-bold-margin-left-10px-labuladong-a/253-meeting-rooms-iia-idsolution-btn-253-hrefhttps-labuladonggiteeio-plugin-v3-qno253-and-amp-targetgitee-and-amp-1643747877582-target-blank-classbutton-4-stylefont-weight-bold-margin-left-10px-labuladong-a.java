class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int res = 0;
        
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start); 
        Arrays.sort(end);

        
        int i = 0, j = 0, count = 0;
        while(i < n && j < n){ 
            if(start[i] < end[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            
            res = Math.max(count, res);
        } 
        
        return res;
        
    }
}