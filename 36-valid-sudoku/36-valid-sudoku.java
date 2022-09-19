class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] subMatrix = new boolean[9][9];
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int c = board[i][j] - '1';
                if(row[i][c] || col[c][j] || subMatrix[3 * (i/3) + j/3][c]) return false;
                row[i][c] = true;
                col[c][j] = true; 
                subMatrix[3 * (i/3) + j/3][c] = true;
            }
        }
        
        return true;
        
        
        
    }
}