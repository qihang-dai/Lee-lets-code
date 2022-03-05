class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for(String s : strings){
            int offset = s.charAt(0) - 'a';
            String key = "";
            for(char c : s.toCharArray()){
                char cur = (char) (c - offset);
                if(cur < 'a'){
                    cur += 26;
                }
                key += cur;
            }
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
            
        }
        
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            String key = entry.getKey();
            res.add(map.get(key));
        }
        return res;
    }
}