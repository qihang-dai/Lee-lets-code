class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int j = 0, i = 0;
        int[] map = new int[256];
        while(i < s.length()){
            char c = s.charAt(i);
            map[c]++;
            i++;
            while(map[c] > 1){ //
                char d = s.charAt(j);
                j++;
                map[d]--;
            }
            res = Math.max(res, i - j ); // cause i plus one more 1 in the end, so no need to + 1
        }
        return res;
        
    }
}