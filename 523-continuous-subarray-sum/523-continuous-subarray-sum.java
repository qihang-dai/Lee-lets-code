class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningsum = 0;
        for(int i = 0; i < nums.length; i++){
            runningsum += nums[i];
            if(k != 0) runningsum %= k;
            Integer pre = map.get(runningsum);
            if(pre != null){
                if(i - pre > 1) return true;
            }else{
                map.put(runningsum, i);
            }
        }
        
        return false;
    }
}