class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, istar = -1, jstar = -1;
        int m = s.length(), n = p.length();
        // some special case:
        // if(m < n) return false; this is wrong, cause we can have endless star ***
        while(i < m){
            //condition 1: single char match                         //if after star we match something (star can be 0 or 1), we ++
            if(j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                i++;
                j++;
            //condtiion 2: match star： if there is one start, it can match as many as possible. If there is two consecutive star, the first one is not useful
            }else if(j < n && p.charAt(j) == '*'){
                //we record the matched sINdex, and the next real char j index, then another loop
                istar = i;
                jstar = j++;
            }else if(istar != -1){ // if we have a star, but we match it wrong, we get j and i back to the star position, we greedily need match star in i once
                i = ++istar;        // the greedy would work if we always need to match it, then the loop would run.
                j = jstar + 1;
            }else{
                return false;
            }
        }
        
        //at the end, i is matched. Lets see if j has only left star *
        
        while(j < n){
            if(p.charAt(j) != '*') return false;
            j++;
        }
        return true;
        
    }
}