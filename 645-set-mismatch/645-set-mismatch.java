class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int rep =  - 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < (nums.length - 1) && nums[i] == nums[i + 1]){
                rep = nums[i];
            } 
            sum = sum + i + 1- nums[i];
        }
        
        int missing = rep + sum;
        
        return new int[]{rep, missing};
    }
}