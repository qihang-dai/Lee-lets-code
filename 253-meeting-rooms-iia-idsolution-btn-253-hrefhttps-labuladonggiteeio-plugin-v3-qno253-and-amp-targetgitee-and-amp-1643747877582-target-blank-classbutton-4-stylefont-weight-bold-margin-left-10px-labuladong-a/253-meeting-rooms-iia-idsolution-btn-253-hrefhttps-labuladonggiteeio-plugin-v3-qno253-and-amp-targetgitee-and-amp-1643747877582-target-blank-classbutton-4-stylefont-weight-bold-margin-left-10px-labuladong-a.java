class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int[] intvs: intervals){
            start = Math.min(start, intvs[0]);
            end = Math.max(end, intvs[1]);
        }
        int[] cul = new int[end - start];
        int res = 0;
        for(int[] intvs: intervals){
            for(int i = intvs[0]; i < intvs[1]; i++){
                cul[i - start]++;
            }
        }
        
        for(int n : cul){
            res = Math.max(res, n);
        }
        return res;
    }
}