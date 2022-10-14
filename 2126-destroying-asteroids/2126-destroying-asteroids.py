class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: List[int]) -> bool:
        asteroids.sort()
        
        for a in asteroids:
            if mass < a:
                return False
            else:
                mass += a
        return True
        