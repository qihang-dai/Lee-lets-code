class Solution:
    def numDecodings(self, s: str) -> int:
        # 1 <= t <= 26
        
        def valid(s):
            val = int(s)
            if 0 < val <= 26 and s[0] != '0':
                return 1
            return 0
            
        
        if len(s) == 1:
            return valid(s)
        
        dp = [0] * len(s)
        dp[0] = valid(s[0])
        dp[1] = dp[0]*valid(s[1]) + valid(s[0] + s[1])
        
        for i in range(2, len(s)):
            dp[i] = valid(s[i]) * dp[i - 1] + valid(s[i - 1] + s[i]) * dp[i - 2]
            
            print(dp)
        print(dp)
        return dp[-1]
        