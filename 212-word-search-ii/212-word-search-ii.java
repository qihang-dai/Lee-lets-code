class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    
    TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w :words){
            TrieNode p = root;
            for(char c : w.toCharArray()){
                int i = c -'a';
                if(p.children[i] == null) p.children[i] = new TrieNode();
                p = p.children[i];
            }
            p.word = w;
        }
        return root;
    }
    
    void dfs(TrieNode p, char[][] board, int i, int j, List<String> res){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        char c = board[i][j];
        int index = c - 'a';
        if(c == '*' || p.children[index] == null) return;
        p = p.children[index];
        if(p.word != null){
            res.add(p.word);
            p.word = null; //de-duplicate;
        }
        board[i][j] = '*' ;
        dfs(p, board, i + 1, j, res);
        dfs(p, board, i - 1, j, res);
        dfs(p, board, i, j + 1, res);
        dfs(p, board, i, j - 1, res);
        board[i][j] = c;

    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(root, board, i, j, res);
            }
        }
        return res;
    }
    
    
}