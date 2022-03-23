class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        if(count == 0) return 0;
        
        int time = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0 , -1}};
        while(!q.isEmpty()){
            time++;
            int size = q.size();
            for(int k = 0; k < size; k++){
                int[] rot = q.poll();
                for(int[] d : dirs){
                    int i = rot[0] + d[0];
                    int j = rot[1] + d[1];
                    if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) 
                        continue;
                    count--;
                    grid[i][j] = 2;
                    q.add(new int[]{i, j});
                }
            }
        }
        
        
        
        
        if(count != 0) return -1;
        return time - 1;
    }
    
//     public void dfs(int[][] grid, int i, int j){
//         if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
//         if(grid[i][j] != 1) return;
//         grid[i][j] = 2;
        
//         dfs(grid, i - 1 , j);
//         dfs(grid, i + 1, j);
//         dfs(grid, i, j - 1);
//         dfs(grid, i, j + 1);
//     }
}