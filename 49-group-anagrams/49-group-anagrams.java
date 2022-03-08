class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String str : strs){
            char[] A = new char[26];
            for(char c :str.toCharArray()) A[c - 'a']++;
            String key = new String(A);
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
        
    }
}