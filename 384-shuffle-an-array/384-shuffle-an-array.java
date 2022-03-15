class Solution {
    private int[] nums;
    private int[] reset;
    private Random rd = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
        this.reset = nums.clone();
    }
    
    public int[] reset() {
        this.nums = this.reset;
        reset = reset.clone();
        return nums;
    }
    
    public int[] shuffle() {
        for(int i = 0; i <nums.length; i++){
            swap(i, rd.nextInt(nums.length));
        }
        return nums;
        
    }
    
    public void swap(int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */