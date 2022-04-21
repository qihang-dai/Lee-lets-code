class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int i = 0, j = 0;
        int iStar = -1, jStar = -1; //match的第一个位置
        
        while(i < m){
            if(j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
                ++i; ++j;
            }else if(j < n && p.charAt(j) == '*'){
                iStar = i;
                jStar = j++;
            }else if(iStar >= 0){
                //greedy get the match. So if i match the first J wrong, i would return to this star and match the second J.
                i = ++iStar; //matched i index++
                j = jStar + 1;
            }else{
                return false;
            }
        }
        
        while(j < n && p.charAt(j) == '*') ++j;
        return j ==n;
        
        
        
        
    }
}