class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        int[] res = new int[2];
        res[0] = left;
        if(left >= nums.length ||nums[left] != target) res[0] = -1;
        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                left = mid + 1;
            }
        }
        res[1] = right;
        if(right < 0 || (nums[right] != target )) res[1] = -1;
        return res;
    }
}