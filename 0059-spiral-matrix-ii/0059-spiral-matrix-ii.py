class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        
        left = 0
        right = n - 1
        up = 0
        down = n - 1
        
        matrix = [[0] * n for i in range(n)]
        val = 1
        while left <= right and up <= down:
            for i in range(left, right + 1):
                matrix[up][i] = val
                val += 1
            up += 1
            
            for i in range(up, down + 1):
                matrix[i][right] = val
                val += 1
            right -= 1
            
            for i in range(right, left-1, -1):
                matrix[down][i] = val
                val += 1
            down -= 1
            
            for i in range(down, up - 1, -1):
                matrix[i][left] = val
                val += 1
            left += 1
        
        return matrix
        