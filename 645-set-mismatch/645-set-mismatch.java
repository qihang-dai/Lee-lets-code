class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int rep = -1, miss = -1;
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) rep = index + 1;
            else nums[index] = - nums[index];
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                miss = i + 1;
        }
        return new int[]{rep, miss};
        
    }
}