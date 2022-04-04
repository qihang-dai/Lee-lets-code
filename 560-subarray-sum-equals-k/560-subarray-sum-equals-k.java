class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int sum = 0, res = 0;
        map.put(0, 1);
        for(int n : nums){
            sum += n;
            int sum1 = sum - k;
            if(map.containsKey(sum1)){
                res += map.get(sum1);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
        
    }
}