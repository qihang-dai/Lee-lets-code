class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        dfs(res, new ArrayList(), nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> path, int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList(path)); 
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(path.contains(nums[i])) continue; //
            path.add(nums[i]);
            dfs(res, path, nums);
            path.remove(path.size() - 1);
        }
        
        
    }
}