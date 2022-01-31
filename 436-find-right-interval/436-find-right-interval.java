class Solution {
    public int[] findRightInterval(int[][] intervals) {
        Map<int[], Integer> map = new HashMap();
        int n = intervals.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++){
            int[] right = binarySearch(intervals, intervals[i][1], 0, intervals.length - 1);
            res[map.get(intervals[i])] = right == null? -1 : map.get(right);
        }
        return res;
    }
    
    int[] binarySearch(int[][] intervals, int right, int low, int high){
        if(low >= high){
            if(intervals[low][0] >= right){
                return intervals[low];
            }
            return null;
        }
        
        int mid = low + (high - low)/2;

        if(intervals[mid][0] < right){
            return binarySearch(intervals, right, mid + 1, high);
        }else{
            return binarySearch(intervals, right, low, mid);
        }
        
    }
        
}