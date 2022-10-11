class Solution:
    def maximumSwap(self, num: int) -> int:
        
        s = list(str(num))
        
        s = [int(x) for x in s]
        
        backmax = [int(x) for x in s]
        
        n = len(s)
        # print(n)
        
        for i in range(n - 2, -1, -1):
            backmax[i] = max(backmax[i], backmax[i + 1])
        print(backmax)
        
        for i in range(0, n, 1):
            if s[i] != backmax[i]:
                for j in range(n - 1, i, -1):
                    # print(i, j)
                    if s[j] == backmax[i]:
                        # print(j)
                        s[i], s[j] = s[j], s[i]
                        return int("".join(map(str, s))) 
        return num
                    
        
        