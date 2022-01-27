class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] cur : intervals){
            if(cur[1] < newInterval[0]){
                res.add(cur);
            }else if (cur[0] > newInterval[1]){
                res.add(newInterval);
                newInterval = cur; // 防止重复添加的办法就是占位
            }else{
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[0][0]);
    }
}