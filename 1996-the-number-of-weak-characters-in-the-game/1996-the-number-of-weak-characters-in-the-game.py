class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        A = sorted(properties, key = lambda x: (-x[0], x[1]))
        _, cd = A[0]        
        res = 0
        
        for a, d in A:
            if d < cd:
                res += 1
            cd = max(d, cd)
        
        return res
                
        
        
        
        
        
        
        
        