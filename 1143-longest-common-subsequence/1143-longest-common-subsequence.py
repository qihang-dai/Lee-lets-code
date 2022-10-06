class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = [[0] * (len(text1) + 1) for i in range(len(text2) + 1)]
        
        for i, a in enumerate(text2):
            for j, b in enumerate(text1):
                dp[i + 1][j + 1] = dp[i][j] + 1 if a == b else max(dp[i][j + 1], dp[i + 1][j])
        
        return dp[-1][-1]
        
        