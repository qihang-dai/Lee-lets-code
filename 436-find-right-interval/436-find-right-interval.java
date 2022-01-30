class Solution {
    public int[] findRightInterval(int[][] intervals) {
        Map<int[], Integer> map = new HashMap();
        int n = intervals.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // res[map.get(intervals[n - 1])] = - 1;
        for(int i = 0; i < n; i++){
            int j = i;
            while(j < n && intervals[j][0] < intervals[i][1]){
                j++;
            }
            if(j == n){
                res[map.get(intervals[i])] = -1;
            }else{
                res[map.get(intervals[i])] = map.get(intervals[j]);
            }
        }
        return res;
        
    }
}