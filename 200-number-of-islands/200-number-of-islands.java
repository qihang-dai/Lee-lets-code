class Solution {
    class UF{
        int count;
        int[] root;
        int[] rank;
        
        
        public UF(char[][] grid){
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            root = new int[m*n];
            rank = new int[m * n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){
                        root[i * n + j] = i * n + j; 
                        // the root of then land is of the land's index it self
                        // 2d to 1d digits
                        count++;
                    }
                    rank[i*n + j] = 0;

                }
            }
        }
        
        public int find(int i ){
            if(root[i] != i) root[i] = find(root[i]);
            return root[i];
        }
        
        public void union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx != rooty){
                if(rank[rootx] > rank[rooty]){
                    root[rooty] = rootx;
                }else if(rank[rootx] < rank[rooty]){
                    root[rootx] = rooty;
                }else{
                    root[rooty] = rootx;
                    rank[rootx] +=1;
                }
                count--;
            }
        }
        
        public int getCount(){
            return count;
        }
        
    
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        UF uf = new UF(grid);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    if(i - 1 >= 0 && grid[i - 1][j] == '1'){
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if(i + 1 < m && grid[i + 1][j] == '1'){
                        uf.union(i * n + j, (i + 1)* n + j);
                    }
                    if(j - 1 >=0 && grid[i][j - 1] == '1'){
                        uf.union(i * n + j, (i * n) + j - 1);
                    }
                    if(j + 1 < n && grid[i][j + 1] == '1'){
                        uf.union(i * n + j, (i * n) + j + 1);
                    }
                }
                
            }
        }
        
        return uf.getCount();
        
    }
}