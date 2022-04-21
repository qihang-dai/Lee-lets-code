class Solution { // ONE STAR VERSION
    public boolean isMatch(String s, String p) {
        
        int i = 0, j = 0, m = s.length(), n = p.length();
        
        int iStar = -1, jStar = -1;
        while(i < m){
            if(j < n && ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '?')){
                i++;
                j++;
            }
            
            else if(j < n && p.charAt(j) == '*'){
                iStar = i;
                jStar = j++;
            }
            
            else if(iStar != -1){
                i = ++iStar;
                j = jStar + 1;
            }
            
            else{
                return false;
            }
                
        }
        
        while(j < n && p.charAt(j) == '*') j++;
        
        return j == n;
        
    }
}