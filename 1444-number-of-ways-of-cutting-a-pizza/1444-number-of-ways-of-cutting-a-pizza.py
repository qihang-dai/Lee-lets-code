class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        m, n, mod = len(pizza), len(pizza[0]), 10 ** 9 + 7
        
        presum = [[0] * (n + 1) for i in range(m + 1)]
        
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                presum[i][j] = presum[i + 1][j] + presum[i][j + 1] - presum[i + 1][j + 1] + (pizza[i][j] == 'A')
        
        for r in presum:
            print(r)
        
        
        @lru_cache(None) #as memeory table
        def dp(k, r, c):
            if presum[r][c] == 0: # is the cut remaining has no apple
                return 0
            if k == 0:
                return 1
            res = 0
            for i in range(r + 1, m):
                if presum[r][c] - presum[i][c] > 0:
                    res = (res + dp(k - 1, i, c)) % mod
            for j in range(c + 1, n):
                if presum[r][c] - presum[r][j] > 0:
                    res = (res + dp(k - 1, r, j)) % mod
            return res
            
            
        return dp(k - 1, 0, 0)
                
        