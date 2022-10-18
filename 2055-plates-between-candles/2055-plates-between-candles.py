class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        A = [i for i, c in enumerate(s) if c == '|']
        res = []
        for a, b in queries:
            i = bisect_left(A, a)
            j = bisect_right(A, b) - 1
            res.append(A[j] - A[i] + 1 - (j - i + 1) if i < j else 0)
        return res
        
        