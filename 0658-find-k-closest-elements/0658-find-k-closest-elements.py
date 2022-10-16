class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        heap = []
        res = []
        
        for a in arr:
            dist = abs(a - x)
            heapq.heappush(heap, (dist, a))
        
        for i in range(k):
            res.append(heapq.heappop(heap)[1])
        
        return sorted(res)