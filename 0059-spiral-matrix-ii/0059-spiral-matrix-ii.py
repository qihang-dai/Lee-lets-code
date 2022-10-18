class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        
        matrix = [[0] * n for i in range(n)]
        
        top = 0
        def dfs(i, j, val):
            if i < 0 or i >= n or j < 0 or j >= n or matrix[i][j] != 0:
                return
            
            matrix[i][j] = val
            
            if i <= j + 1:  #the turn right point is always at the crossline
                dfs(i, j + 1, val + 1)

            dfs(i + 1, j, val + 1)


            dfs(i, j - 1, val + 1)


            dfs(i - 1, j, val + 1)
            
                
        dfs(0, 0, 1)

        
        return matrix
            
"""

[[1,2,3,4],
[12,13,14,5],
[11,16,15,6],
[10,9,8,7]]

[[1,2,3,4],
[16,15,14,5],
[11,12,13,6],
[10,9,8,7]]

 1 2 3 4 5
         6
         7
         8
      10 9
"""
        