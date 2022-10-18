class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        
        m, n = len(matrix), len(matrix[0])
        
        left = 0
        right = n - 1
        up = 0
        down = m - 1
        
        res = []

        while left <= right and up <= down:
            for i in range(left, right + 1):
                res.append(matrix[up][i])
            up += 1
            
            for i in range(up, down + 1):
                res.append(matrix[i][right])
            right -= 1
            
            #need to check this incase the while loop doesnt stop cause the loop condition var has changed
            if up > down or left > right:
                break
            
            for i in range(right, left-1, -1):
                res.append(matrix[down][i])
            down -= 1
            
            for i in range(down, up - 1, -1):
                res.append(matrix[i][left])
            left += 1
        
        return res