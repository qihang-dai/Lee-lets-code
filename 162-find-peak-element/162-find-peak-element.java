class Solution {
    public int helper(int[] nums, int left, int right){
        if(left == right) return left;
        int mid = (left + right)/2;
        int mid1 = mid + 1;
        if(nums[mid] < nums[mid1]){
            left = mid1;
        }else{
            right =  mid;
        }
        return helper(nums, left, right);
    }
    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
        
    }
}