class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        int p = 0;
        while(p <= j){
            if(nums[p] == 0){
                swap(nums, p, i);
                p++;
                i++;
            }else if(nums[p] == 2){
                swap(nums, p, j);
                j--;
            }else{
                p++;
            }
        }
        
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        
    }
}