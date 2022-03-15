class Solution {
    public int maxRotateFunction(int[] nums) {
        int res = 0;
        int oneSum = 0;
        for(int n : nums){
            oneSum += n;
        }
        for(int i = 0; i < nums.length; i++){
            res += i*nums[i];
            // System.out.println(res);
        }
        
        /// res0 = 0n0 1n1 2n2
        //  res1 = 1n0 2n1 0n2
        //  res1 - res0 = 0n0 1n1 2n2 - (1n0 1n1 1n2) + length*nums[i]; 
        int tmp = res;
        for(int i = 1; i < nums.length; i++){
            tmp = tmp + oneSum  - nums.length *nums[nums.length - i];
            res = Math.max(res, tmp);
        }
        return res;
        
    }
}