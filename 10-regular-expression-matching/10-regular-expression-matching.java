class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()][p.length()];
        return dp(s, 0, p, 0);
    }
    
    public boolean dp(String s, int i, String p, int j){
        if(j == p.length()){
            return i == s.length();
        }
        
        if(i == s.length()){
            if((p.length() - j) % 2 == 1) return false;
            for(; j + 1 < p.length(); j += 2){// make sure we get 2 2 2 pairs till the end
                if(p.charAt(j + 1) != '*') return false;
            }
            return true;
        }
        if(memo[i][j] != null) return memo[i][j];
        
        boolean res = false;
        
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            if((j+1) < p.length() && p.charAt(j + 1) == '*'){
                res =  dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            }else{
                res = dp(s, i + 1, p, j + 1);
            }
        }else{
            if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
                res = dp(s, i, p, j + 2);
            }else{
                res = false;
            }
        }
        memo[i][j] = res;
        return res;
    }
}