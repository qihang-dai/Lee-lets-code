class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        double mod = Math.pow(10, 9) + 7.0;
        double[][] dp = new double[n + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                for(int d = 1; d <= k; d++){
                    if(d > j) break;
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - d]) % mod;
                }
            }
        }  
        
        return (int)dp[n][target];
    }
}