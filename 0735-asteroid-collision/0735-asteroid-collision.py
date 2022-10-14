class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        
        res = []
        
        for a in asteroids:
            while res and res[-1] > 0 and a < 0:
                if res[-1] == -a:
                    res.pop()
                    break
                elif res[-1] > -a:
                    break
                elif res[-1] < -a:
                    res.pop() #compare next
                    continue    
            else:
                res.append(a)
        
        return res
        