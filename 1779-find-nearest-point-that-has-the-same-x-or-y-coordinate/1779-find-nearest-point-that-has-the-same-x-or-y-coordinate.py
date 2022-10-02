class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        index, small = -1, math.inf
        for i, (r, c) in enumerate(points):
            dx, dy = r - x, c - y
            if dx * dy == 0 and abs(dx + dy) < small:
                small = abs(dx + dy)
                index = i
        return index
        