class Solution:
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        A = [i for i, c in enumerate(s) if c == '|']
        print(A)
        res = []
        for a, b in queries:
            i = bisect_left(A, a)
            j = bisect_right(A, b) - 1
            print(a, b, i, j)
            res.append(A[j] - A[i] + 1 - (j - i + 1) if i < j else 0)
        return res
        
        