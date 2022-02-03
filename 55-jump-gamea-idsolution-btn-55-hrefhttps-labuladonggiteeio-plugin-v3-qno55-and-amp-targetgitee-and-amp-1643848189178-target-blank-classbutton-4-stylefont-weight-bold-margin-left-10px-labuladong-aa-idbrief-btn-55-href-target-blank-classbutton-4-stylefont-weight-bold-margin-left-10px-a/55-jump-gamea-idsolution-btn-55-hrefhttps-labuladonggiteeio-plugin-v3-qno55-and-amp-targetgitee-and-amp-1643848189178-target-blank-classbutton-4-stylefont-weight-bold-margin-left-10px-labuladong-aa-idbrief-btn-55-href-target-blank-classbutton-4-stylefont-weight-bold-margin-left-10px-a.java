class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int cover = nums[0];
        for(int i = 1; i <= cover; i++){
            cover = Math.max(i +nums[i], cover);
            if(cover >= nums.length - 1) return true;
        }
        return false;
        
    }
}