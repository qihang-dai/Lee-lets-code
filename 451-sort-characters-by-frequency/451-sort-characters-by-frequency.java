class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) +1);
        }
        int max = Collections.max(map.values());
        
        List<List<Character>> bucket = new ArrayList();
        for(int i = 0; i <= max; i++){
            bucket.add(new ArrayList<Character>());
        }
        for(char c : map.keySet()){
            int freq = map.get(c);
            bucket.get(freq).add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = max; i >= 1; i--){
            for(char c: bucket.get(i)){
                for(int j = 0; j < i; j++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
        
    }
}