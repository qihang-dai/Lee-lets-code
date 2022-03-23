class Trie{
    
    class Node{
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    };
    
    Node Root, cur;
    List<String> resBuffer;
    
    void dfs(Node cur, String word){
        if(resBuffer.size() == 3) return;
        if(cur.isWord) resBuffer.add(word);
        
        for(char c = 'a'; c <= 'z'; c++)
            if(cur.children.get(c - 'a') != null)
                dfs(cur.children.get(c - 'a'), word + c);
    }
            
    Trie(){
        Root = new Node();
    }
            
    void insert(String s){
        cur = Root;
        for(char c :s.toCharArray()){
            if(cur.children.get(c - 'a') == null)
                cur.children.set(c - 'a', new Node());
            cur = cur.children.get(c -'a');
        }
        
        cur.isWord = true;
    }
            
    List<String> getPrefix(String prefix){
        cur = Root;
        resBuffer = new ArrayList<String>();
        for(char c: prefix.toCharArray()){
            if(cur.children.get(c - 'a') == null) return resBuffer;
            cur = cur.children.get(c - 'a');
        }
        dfs(cur, prefix);
        return resBuffer;
    }
    
    
};

class Solution {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> res = new ArrayList();
        for(String w : products)
            trie.insert(w);
        String prefix = "";
        for(char c : searchWord.toCharArray()){
            prefix += c;
            res.add(trie.getPrefix(prefix));
        }
        return res;
        
    }
}