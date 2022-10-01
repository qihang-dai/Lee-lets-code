class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        int[] dp = new int[100001];
        
        //get the max porfit at each difficulty
        for(int i = 0; i < difficulty.length; i++){
            dp[difficulty[i]] = Math.max(dp[difficulty[i]], profit[i]); 
        }
        
        // get the max profit below each difficutly
        for(int i = 1; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        
        int res = 0;
        
        for(int w : worker){
            res += dp[w];
        }
        return res;
        
        
    }
}