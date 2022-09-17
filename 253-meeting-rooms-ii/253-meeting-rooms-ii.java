class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        int index = 0;
        for(int[] in : intervals){
            start[index] = in[0];
            end[index] = in[1];
            index++;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        
        int res = 0, j = 0;
        for(int i = 0; i < start.length; i++){
            if(start[i] < end[j]) res++;
            else j++;
        }
        
        return res;
    }
}