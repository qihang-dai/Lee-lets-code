class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        for location, numPassengers in sorted(x for num, up, to in trips for x in [[up, num], [to, -num]]):
            capacity -= numPassengers
            if capacity < 0:
                return False
        return True
        
