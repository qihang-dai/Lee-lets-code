class Solution {
    int res = 0;

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X'){
                    res++;
                    dfs(i, j, board);
                }
            }
        }
        return res;
        
        
    }
    
    public void dfs(int i, int j, char[][] board){
        if(i < 0 || j < 0|| i >= board.length || j >= board[0].length) return;
        if(board[i][j] != 'X') return;
        board[i][j] ='.';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j+ 1, board);
        dfs(i, j - 1, board);
    }
}