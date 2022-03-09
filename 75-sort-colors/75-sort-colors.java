class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);   
    }
    
    public void quickSort(int[] nums, int start, int end){
        if(start < end){
            int position = partition(nums, start, end);
            quickSort(nums, start, position - 1);
            quickSort(nums, position +1, end);
        }
    }

    
    public int partition(int[] nums, int start, int end){
        int p = start;
        for(int i = start; i < end; i++){
            if(nums[i] <= nums[end]){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
                p++;
            }
        }
        
        int tmp = nums[p];
        nums[p] = nums[end];
        nums[end] = tmp;
        return p;
    }
}