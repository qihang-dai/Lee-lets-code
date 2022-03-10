class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int n : nums){
            count[n]++;
        }

        int idx = 0;
        for(int i = 0; i < 3; i++){
            while(count[i] > 0){
                nums[idx] = i;
                count[i]--;
                idx++;
            }
        }

    }
}