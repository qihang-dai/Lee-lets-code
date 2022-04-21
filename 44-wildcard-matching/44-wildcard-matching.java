class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, m = s.length(), n = p.length();
        
        int istar = -1, jstar = -1;
        while(i < m){
            
            //condition 1: exact match
            if(j < n && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
                i++;
                j++;
            }
            
            //condition 2: we record every last star we have. So we can return to the last star if we mismatch
            else if(j < n && p.charAt(j) == '*'){
                istar = i; //matched position, but i not move, cause we can match empty
                jstar = j++; // star position, but j move cause the star is in use
            }
            
            //condition 3: no match, but we have star, we can greedily rerun the match from the last star position
            // this time we have to match one more 
            else if(istar != -1){
                i = ++istar; // istar moved, cause we defo need to match one more
                j = jstar + 1; // j return to the last star
                
            }
            
            //condition 4: no star, no match, or reach the length limited of j while i is not matched enough
            else{
                return false;
            }
        }
        
        //now we have matched all the s, but dunno p pattern string is matched all.
        while(j < n && p.charAt(j) == '*') j++;
        
        //if all j left is *, its a match, else not
        return j == n;
        
    }
}