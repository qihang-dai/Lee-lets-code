class Solution {
    public void nextPermutation(int[] nums) {
        
        int pivot1 = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                pivot1 = i;
                break;
            }
        }
        
        if(pivot1 == -1){
            reverse(0, nums);
            return;
        }
        for(int j = nums.length - 1; j > pivot1; j--){
            if(nums[j] > nums[pivot1]){
                swap(j, pivot1, nums);
                break;
            }
        }
        
        reverse(pivot1 + 1, nums);
        
        
    }
    
    public static void swap(int i, int j, int[] nums){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
    }
    
    public void reverse(int i, int[] nums){
        int j = nums.length - 1;
        while(i < j){
            swap(i, j, nums);
            i++;
            j--;
        }
        
    }
}