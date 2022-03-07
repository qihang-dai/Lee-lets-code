class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] > 0) return res;
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }
                if(sum < 0){
                    j++;
                }
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    //去重
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                    
                    //普通递归
                    j++;
                    k--;
                }
            }
        }
        
        return res;
        
    }
}