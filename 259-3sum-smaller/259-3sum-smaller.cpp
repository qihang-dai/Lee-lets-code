class Solution {
public:
    int threeSumSmaller(vector<int>& nums, int target){
        if (nums.size() < 3){
            return 0;
        }
        
        int res = 0;
        sort(nums.begin(), nums.end());
        
        for (int i = 0; i + 2 < nums.size(); i++){
            int left = i + 1;
            int right = nums.size() -1;
            
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum >= target){
                    
                    right--;
                }else{
                    res += right - left;
                    left++;
                    
                }
            }
        }
        return res;
    }
};