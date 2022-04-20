class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        String pp = removeDuplicate(p);
        memo = new Boolean[s.length()][pp.length()];
        return dp(s, 0, pp, 0);
    }
    
    String removeDuplicate(String s){
        if(s.length() == 0) return s;
        
        StringBuilder res = new StringBuilder();
        
        res.append(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '*' && s.charAt(i - 1) == '*'){
                continue;
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
    
    boolean dp(String s, int i , String p, int j){
        if(i == s.length() && j == p.length())
            return true;
        
        if(i == s.length()){
            for(int k = j; k < p.length(); k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        
        
        
        if(j == p.length()) return false;
        
        if(memo[i][j] != null) return memo[i][j];
        
        boolean res = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            res = dp(s, i + 1, p, j + 1);
        }else if(p.charAt(j) == '*'){
            res = dp(s, i + 1, p, j) || dp(s, i, p, j + 1);
        }
        memo[i][j] = res;
        return res;
    }

    
    
}