class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            Character cur = s.charAt(i);
            if(map.containsKey(cur)){
                j = Math.max(j, map.get(cur) +1); // make sure the window never goes back
            }
            map.put(cur, i);
            res = Math.max(res, i - j + 1);
        }
        return res;
        
    }
}