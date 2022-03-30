class Solution {
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> tmp = new LinkedList();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }
    
    public void dfs(int[] candidates, int start, int target){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList(tmp));
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            sum += candidates[i];
            tmp.add(candidates[i]);
            dfs(candidates, i, target);
            tmp.removeLast();
            sum -= candidates[i];
        }
        
    }
}