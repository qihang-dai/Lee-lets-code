class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean valid[] = new boolean[s.length() + 1];
        valid[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(valid[j] == true && wordDict.contains(s.substring(j,i))){
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
        
    }
}