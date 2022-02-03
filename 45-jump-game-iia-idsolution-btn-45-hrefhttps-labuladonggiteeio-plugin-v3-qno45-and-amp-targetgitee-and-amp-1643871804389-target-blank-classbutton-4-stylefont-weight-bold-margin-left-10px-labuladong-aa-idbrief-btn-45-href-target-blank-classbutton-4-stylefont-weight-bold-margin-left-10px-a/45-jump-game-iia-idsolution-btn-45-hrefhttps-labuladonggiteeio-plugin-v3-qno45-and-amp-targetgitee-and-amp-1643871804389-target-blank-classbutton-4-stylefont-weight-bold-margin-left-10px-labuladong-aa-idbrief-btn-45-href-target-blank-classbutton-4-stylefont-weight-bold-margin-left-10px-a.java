class Solution {
    public int jump(int[] nums) {
        int cover = 0;
        int end = 0;
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++){
            cover = Math.max(cover, i + nums[i]);
            if(i == end){
                res++;
                end = cover;
            }
        }
        return res;
    }
}